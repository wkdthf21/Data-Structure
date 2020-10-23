package com.dora.algorithm.shortestpath;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {

	private int[][] graph;
	private boolean[] isVisited;
	private int[] dist;
	private static final int INF = 2147483647;
	
	public Dijkstra(int[][] graph) {
		this.graph = Arrays.copyOf(graph, graph.length);
		this.isVisited = new boolean[graph.length];
		this.dist = new int[graph.length];
		Arrays.fill(isVisited, false);
		Arrays.fill(dist, INF);
	}
	
	
	private static class Node implements Comparable<Node>{
		
		int idx;
		int cost;
		
		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node target) {
			return cost - target.cost;
		}
		
	}
	
	public void printShortestPath(int start) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		isVisited[start] = true;
		for(int i = 0; i < graph[start].length; i++) {
			if(i == start) dist[start] = 0;
			else {
				if(graph[start][i] != 0) {
					dist[i] = graph[start][i];
					Node node = new Node(i, dist[i]);
					pq.add(node);
				}
			}
		}
		
		
		while(!pq.isEmpty()) {
			
			
			Node node = pq.poll();
			
			if(isVisited[node.idx]) continue;
			isVisited[node.idx] = true;
			
			
			for(int i = 0; i < graph.length; i++) {
				
				if(graph[node.idx][i] != 0 && !isVisited[i]) {
					
					if(dist[node.idx] + graph[node.idx][i] < dist[i]) {
						dist[i] = dist[node.idx] + graph[node.idx][i];
						Node nextNode = new Node(i, dist[i]);
						pq.add(nextNode);
					}
					
				}
				
			}
			
			
		}
		
		
		System.out.println("All Shortest Path starting from " + start);
		
		for(int i = 0; i < graph.length; i++) {
			System.out.print(dist[i] + " ");
		}
		
		System.out.println();
		
	}
	
	
}
