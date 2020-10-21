package com.dora.datastructures.priorityqueue;

public class HeapSort<T extends Comparable<T>> {
	
	MinHeapUsingDArray<T> minHeap;
	
	public HeapSort() {
	}
	
	public T[] sortDescending(T[] arr) {
		
		minHeap = new MinHeapUsingDArray<T>(arr);
		for(int i = minHeap.getSize() - 1 ; i >= 0; i--) {
			T min = minHeap.poll();
			arr[i] = min;
		}
		
		return arr;
	}

}
