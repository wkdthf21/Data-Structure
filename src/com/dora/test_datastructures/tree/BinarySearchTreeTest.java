package com.dora.test_datastructures.tree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.dora.datastructures.tree.BinarySearchTree;

class BinarySearchTreeTest {

	@Test
	void makeEmptyBST() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		assertTrue(bst.isEmpty());
	}
	
	@Test
	void addNode() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for(int i = 0; i < 10; i++)
			bst.add(i);
		
		assertEquals(bst.getSize(), 10);
	}
	
	@Test
	void removeNode() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for(int i = 0; i < 10; i++)
			bst.add(i);
		
		for(int i = 9; i >= 0; i--) {
			assertTrue(bst.remove(i));
			assertEquals(bst.getSize(), i);
		}
	}

}
