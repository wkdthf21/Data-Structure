package com.dora.test_algorithm.shortestpath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.dora.algorithm.shortestpath.Dijkstra;

class DijkstraTest {

	
	int[][] graph = {
			
			{0, 3, 0, 3 ,2},
			{0, 0, 0, 0, 5},
			{0, 0, 0, 0, 0},
			{0, 0, 0, 0, 5},
			{0, 0, 6, 0, 0},
	};
	
	@Test
	void test() {
		Dijkstra dijkstra = new Dijkstra(graph);
		dijkstra.printShortestPath(0);
	}

}
