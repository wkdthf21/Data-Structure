package com.dora.test_algorithm.mst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.dora.algorithm.mst.Kruskal;

class KruskalTest {

	
	int[][] graph = {
			{-1, 5, 4, -1, -1, -1},
			{5, -1, 2, 7, -1, -1},
			{4, 2, -1, 6, 11, -1},
			{-1, 7, 6, -1, 3, 8},
			{-1, -1, 11, 3, -1, 8},
			{-1, -1, -1, 8, 8, -1},
	};
	
	
	@Test
	void testKruskal() {
		Kruskal kruskal = new Kruskal(graph);
		kruskal.printMST();
	}

}
