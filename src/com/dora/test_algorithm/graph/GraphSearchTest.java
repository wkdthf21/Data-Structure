package com.dora.test_algorithm.graph;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.dora.algorithm.graph.GraphSearch;

class GraphSearchTest {

	int[][] graph = {
			{0, 1, 0, 0, 0, 0, 0},
			{0, 0, 1, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 0},
			{0, 0, 0, 0, 1, 1, 0},
			{0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1},
			{0, 0, 0, 0, 0, 0, 0}
	};
	
	@Test
	void testDfsRecursive() {
		GraphSearch gs = new GraphSearch(graph);
		gs.dfsRecursive();
	}
	
	@Test
	void testDfsStack() {
		GraphSearch gs = new GraphSearch(graph);
		gs.dfsStack();
	}
	
	@Test
	void testBfs() {
		GraphSearch gs = new GraphSearch(graph);
		gs.bfs();
	}

}
