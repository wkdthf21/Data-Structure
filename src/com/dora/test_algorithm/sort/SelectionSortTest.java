package com.dora.test_algorithm.sort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.dora.algorithm.sort.Sort;

class SelectionSortTest {

	
	private static Integer[] arr = {1, -1, 10, 5, 3 , 99, 77, 17};
	
	@Test
	void testSelectionSort() {
		Sort<Integer> sort = new Sort<>();
		arr = sort.selectionSort(arr);
		for(int i : arr) {
			System.out.print(i + " " );
		}
		System.out.println();
	}
	
	@Test
	void testInsertionSort() {
		Sort<Integer> sort = new Sort<>();
		arr = sort.insertionSort(arr);
		for(int i : arr) {
			System.out.print(i + " " );
		}
		System.out.println();
	}

	
	@Test
	void testBubbleSort() {
		Sort<Integer> sort = new Sort<>();
		Integer[] arr = {1, -1, 10, 5, 3 , 99, 77, 17};
		arr = sort.bubbleSort(arr);
		for(int i : arr) {
			System.out.print(i + " " );
		}
		System.out.println();
	}
	
	
	@Test
	void testHeapSort() {
		Sort<Integer> sort = new Sort<>();
		arr = sort.heapSort(arr);
		for(int i : arr) {
			System.out.print(i + " " );
		}
		System.out.println();
	}
	
	
	@Test
	void mergeSort() {
		Sort<Integer> sort = new Sort<>();
		arr = sort.mergeSort(arr);
		for(int i : arr) {
			System.out.print(i + " " );
		}
		System.out.println();
	}
	
}
