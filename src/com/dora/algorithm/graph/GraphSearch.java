package com.dora.algorithm.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphSearch {

	
	int[][] graph;
	boolean[] isVisited;
	
	public GraphSearch(int[][] graph) {
		
		this.graph = new int[graph.length][graph[0].length];
		
		for(int i = 0; i < graph.length; i++) {
			// 2d array deep copy
			System.arraycopy(graph[i], 0, this.graph[i], 0, graph.length);
		}
		
	}
	
	public void dfsRecursive() {	
		
		isVisited = new boolean[graph.length];
		Arrays.fill(isVisited, false);
		
		if(graph.length != 0) {
			System.out.println("======= DFS Recursive ======= ");
			dfsRecursive(0);
			System.out.println();
		}
		
	}
	
	
	public void dfsStack() {
		
		System.out.println("======= DFS Stack ======= ");
		
		isVisited = new boolean[graph.length];
		Arrays.fill(isVisited, false);
	
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		isVisited[0] = true;
		while(!stack.isEmpty()) {
			
			int cur = stack.pop();
			System.out.print(cur + " ");
			for(int i = graph.length - 1; i >= 0; i--) {
				if(graph[cur][i] == 1 && !isVisited[i]) {
					isVisited[i] = true;
					stack.push(i);
				}
			}
			
		}
		
		System.out.println();
	
	}
	
	
	public void bfs() {
		
		System.out.println("======= BFS ======= ");
		
		isVisited = new boolean[graph.length];
		Arrays.fill(isVisited, false);
		
		Queue<Integer> que = new LinkedList<>();
		que.add(0);
		
		while(!que.isEmpty()) {
			
			int cur = que.poll();
			
			System.out.print(cur + " ");
			isVisited[cur] = true;
			
			for(int i = 0; i < graph.length; i++) {
				if(graph[cur][i] == 1 && !isVisited[i]) {
					que.add(i);
				}
			}
			
		}
		
		System.out.println();
		
	}
	
	
	private void dfsRecursive(int cur) {
		
		System.out.print(cur + " ");
		
		isVisited[cur] = true;
		
		for(int i = 0; i < graph.length; i++) {
			if(graph[cur][i] == 1 && !isVisited[i]) {
				dfsRecursive(i);
			}
		}
		
	}
	
}
