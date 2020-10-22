package com.dora.test_algorithm.sort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.dora.algorithm.sort.Sort;

class SelectionSortTest {

	private static Integer[] arr = {1, -1, 10, 5, 3 , 99, 77, 17};
	
	@Test
	void testSelectionSort() {
		Sort<Integer> sort = new Sort<>();
		Integer[] arr = {1, -1, 10, 5, 3 , 99, 77, 17};
		arr = sort.selectionSort(arr);
		System.out.println("Selection Sort ======== ");
		for(int i : arr) {
			System.out.print(i + " " );
		}
		System.out.println();
	}
	
	@Test
	void testInsertionSort() {
		Sort<Integer> sort = new Sort<>();
		Integer[] arr = {1, -1, 10, 5, 3 , 99, 77, 17};
		arr = sort.insertionSort(arr);
		System.out.println("Insertion Sort ======== ");
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
		System.out.println("Bubble Sort ======== ");
		for(int i : arr) {
			System.out.print(i + " " );
		}
		System.out.println();
	}
	
	
	@Test
	void testHeapSort() {
		Sort<Integer> sort = new Sort<>();
		Integer[] arr = {1, -1, 10, 5, 3 , 99, 77, 17};
		arr = sort.heapSort(arr);
		System.out.println("Heap Sort ======== ");
		for(int i : arr) {
			System.out.print(i + " " );
		}
		System.out.println();
	}
	
	
	@Test
	void mergeSort() {
		Sort<Integer> sort = new Sort<>();
		Integer[] arr = {1, -1, 10, 5, 3 , 99, 77, 17};
		arr = sort.mergeSort(arr);
		System.out.println("Merge Sort ======== ");
		for(int i : arr) {
			System.out.print(i + " " );
		}
		System.out.println();
	}
	
	@Test
	void quickSort() {
		Sort<Integer> sort = new Sort<>();
		Integer[] arr = {1, -1, 10, 5, 3 , 99, 77, 17};
		arr = sort.quickSort(arr);
		System.out.println("Quick Sort ======== ");
		for(int i : arr) {
			System.out.print(i + " " );
		}
		System.out.println();
	}
	
}
