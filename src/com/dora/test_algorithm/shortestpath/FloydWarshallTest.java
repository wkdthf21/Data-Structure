package com.dora.test_algorithm.shortestpath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.dora.algorithm.shortestpath.FloydWarshall;

class FloydWarshallTest {

	
	int[][] graph = {
			
			{0, 3, 0, 3 ,2},
			{0, 0, 0, 0, 5},
			{0, 0, 0, 0, 0},
			{0, 0, 0, 0, 5},
			{0, 0, 6, 0, 0},
	};
	
	
	@Test
	void test() {
		FloydWarshall floydWarshall = new FloydWarshall(graph);
		floydWarshall.printAllShortestPath();
		floydWarshall.printShortestPath(0, 2);
	}

}
