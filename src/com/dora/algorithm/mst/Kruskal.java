package com.dora.algorithm.mst;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 
 * input is Cost Graph 2D Array
 * 
 * @author yesol
 *
 */
public class Kruskal {
	
	// -1 : is not connected
	private int[][] graph;
	private int[] parent;
	private PriorityQueue<Edge> pq = new PriorityQueue<>();
	
	
	public static class Edge implements Comparable<Edge> {
		int s;
		int e;
		int cost;
		
		Edge(int s, int e, int cost){
			this.s = s;
			this.e = e;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge target) {
			return this.cost - target.cost;
		}
		
	}
	
	
	public Kruskal(int[][] graph) {
		this.graph = new int[graph.length][graph.length];
		
		for(int i = 0; i < graph.length; i++) {
			// 2d array deep copy
			System.arraycopy(graph[i], 0, this.graph[i], 0, graph.length);
		}	
		
		this.parent = new int[graph.length];
	}
	
	public void printMST() {
		
		makePriorityQueue();
		makeSet();
		
		while(!pq.isEmpty()) {
			
			Edge edge = pq.poll();
			
			if(isCycle(edge)) continue;
			
			int p1 = findParent(edge.s);
			int p2 = findParent(edge.e);
			
			union(p1, p2);
			
			System.out.println(edge.s + " -> " +edge.e + " : " + edge.cost);
			
		}
		
	}
	
	

	/**
	 * 
	 * check if edge is added into MST, cycle occurs 
	 * 
	 * @param s
	 * @param e
	 * @return
	 */
	private boolean isCycle(Edge edge) {
		
		int p1 = findParent(edge.s);
		int p2 = findParent(edge.e);
		
		if(p1 == p2) return true;
		else return false;
	}
	
	
	/**
	 * 
	 * Union & Find
	 * 
	 */
	
	private void makeSet() {
		for(int i = 0; i < graph.length; i++) parent[i] = i;
	}
	
	private void union(int x1, int x2) {
		
		int y1 = findParent(x1);
		int y2 = findParent(x2);
		
		if(y1 != y2) {
			parent[y1] = y2;
		}
		
	}
	
	private int findParent(int x1) {
		if(parent[x1] == x1) return x1;
		return parent[x1] = findParent(parent[x1]);
	}
	
	
	/**
	 * 
	 * make Priority Queue
	 * 
	 * This is used to find min cost edge
	 * 
	 */
	private void makePriorityQueue() {
		
		for(int i = 0; i < graph.length; i++) {
			for(int j = 0; j < graph.length; j++) {
				if(graph[i][j] != -1) {
					Edge e = new Edge(i, j, graph[i][j]);
					pq.add(e);
				}
			}
		}
		
	}
	
}
