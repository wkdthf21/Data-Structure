package com.dora.algorithm.shortestpath;

import java.util.Arrays;

public class FloydWarshall {

	int[][] entryNode;	/* save Node visited to go from i to j*/
	int[][] dist;
	private static final int INF = 2147483647;
	
	public FloydWarshall(int[][] graph) {
		
		dist = new int[graph.length][graph.length];
		entryNode = new int[graph.length][graph.length];
		
		for(int i = 0; i < graph.length; i++) {
			// 2d array deep copy
			System.arraycopy(graph[i], 0, dist[i], 0, graph.length);
			System.arraycopy(graph[i], 0, entryNode[i], 0, graph.length);
		}
		
		for(int i = 0; i < dist.length; i++) {
			for(int j = 0; j < dist[i].length; j++) {
				if(i == j) continue;
				if(dist[i][j] == 0) {
					dist[i][j] = INF;
				}
			}
		}
		
		
		for(int i = 0; i < entryNode.length; i++) {
			for(int j = 0; j < entryNode[i].length; j++) {
				if(entryNode[i][j] != 0) {
					entryNode[i][j] = i;
				}
				else {
					entryNode[i][j] = INF;
				}
			}
		}
		

	}
	
	public void printAllShortestPath() {
		
		floydWarshall();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("========== all shortest path cost ========== \n");
		for(int i = 0; i < dist.length; i++) {
			sb.append("start from " + i + " ---------- \n");
			for(int j = 0; j < dist.length; j++) {
				if(dist[i][j] >= INF) sb.append("0 ");
				else sb.append(dist[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	
	public void printShortestPath(int start, int end) {
		
		floydWarshall();
		
		StringBuilder sb = new StringBuilder();
		sb.append("========== shortest path from " + start + " to " + end + " ========== \n");
		sb.append(start + " -> ");
		int i = start;
		
		int cost = 0;
		while(entryNode[i][end] != i && entryNode[i][end] != INF) {
			cost += dist[i][entryNode[i][end]];
			sb.append(entryNode[i][end] + " -> ");
			i = entryNode[i][end];
		}
		cost += dist[i][end];
		sb.append(end + "\n");
		sb.append("cost is "  + cost + "\n");
		System.out.println(sb.toString());
		
	}
	
	
	private void floydWarshall() {
		
		for(int k = 0; k < dist.length; k++) {
			for(int i = 0; i < dist.length; i++) {
				for(int j = 0; j < dist.length; j++) {
					if(dist[i][k] == INF || dist[k][j] == INF) continue;
					
					if(dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
						entryNode[i][j] = k;
						entryNode[k][j] = k;
					}
					
				}
			}
		}
		
	}
}
