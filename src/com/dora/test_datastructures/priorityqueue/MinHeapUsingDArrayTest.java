package com.dora.test_datastructures.priorityqueue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.dora.datastructures.priorityqueue.HeapSort;
import com.dora.datastructures.priorityqueue.MinHeapUsingDArray;

class MinHeapUsingDArrayTest {

	@Test
	void createEmptyMinHeap() {
		MinHeapUsingDArray<Integer> minHeap = new MinHeapUsingDArray<>();
		assertTrue(minHeap.isEmpty());
	}
	
	@Test
	void testBuildMinHeap() {
		Integer[] arr = {1, 4, 5, 2, 3, 10};
		MinHeapUsingDArray<Integer> minHeap = new MinHeapUsingDArray<>(arr);
		assertEquals(minHeap.getSize(), arr.length);
	}
	
	@Test
	void testAdd() {
		MinHeapUsingDArray<Integer> minHeap = new MinHeapUsingDArray<>();
		
		for(int i = 9; i >= 0; i--) {
			minHeap.add(i);
		}
		
		assertEquals(minHeap.getSize(), 10);
	}
	
	@Test
	void findMinValue() {
		MinHeapUsingDArray<Integer> minHeap = new MinHeapUsingDArray<>();
		for(int i = 9; i >= 0; i--) {
			minHeap.add(i);
		}
		for(int i = 0; i < 10; i++) {
			assertEquals(minHeap.poll(), i);
		}
	}
	
	@Test
	void testHeapSort() {
		
		Integer[] arr = {1, 4, 5, 2, 3, 10};
		Integer[] answer = {10, 5, 4, 3, 2, 1};
		HeapSort<Integer> heapSort = new HeapSort<>();
		
		arr = heapSort.sortDescending(arr);
		for(int i = 0; i < arr.length; i++) {
			assertEquals(arr[i], answer[i]);
		}
		
	}

}
