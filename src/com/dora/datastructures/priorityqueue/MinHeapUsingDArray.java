package com.dora.datastructures.priorityqueue;

import java.util.Arrays;

/**
 * 
 * Min Heap using Dynamic Array
 * 
 * @author yesol
 *
 * @param <T>
 */
public class MinHeapUsingDArray<T extends Comparable<T>> {
	
	private static final int DEFAULT_CAPACITY = 8;
	private int capacity;
	private int size;
	private T[] arr;
	
	/**
	 * 
	 * constructor
	 * 
	 */
	public MinHeapUsingDArray() {
		capacity = DEFAULT_CAPACITY;
		arr = (T[]) new Comparable[capacity];
		size = 0;
	}
	
	public MinHeapUsingDArray(T[] inputArr) {
		size = inputArr.length;
		capacity = size;
		arr = Arrays.copyOf(inputArr, size);
		buildMinHeap();
	}
	
	/**
	 * 
	 * Convert input array to heap
	 * 
	 * continues to decrease index 1 
	 * until the root node
	 * starting from the parent node of the last node
	 * 
	 */
	public void buildMinHeap() {
		for(int i = size / 2 - 1; i >= 0; i--) {
			sink(i);
		}
	}
	
	/**
	 * 
	 * pop the root of heap
	 * 
	 * @return
	 */
	public T poll() {
		
		if(isEmpty()) throw new RuntimeException("Min Heap is Empty");		
		
		T data = arr[0];
		
		// move last node to root & sink
		arr[0] = arr[--size];
		arr[size] = null;
		sink(0);
		
		return data;
	}
	
	
	/**
	 * 
	 * add data into the min heap
	 * 
	 * if min heap is full, double the size of min heap
	 * 
	 * @param data
	 */
	public void add(T data) {
		
		if(capacity == size) {
			capacity = capacity << 1;
			arr = Arrays.copyOf(arr, capacity);
		}
		
		arr[size++] = data;
		swim(size-1);
		
	}
	
	
	/**
	 * 
	 * Relocation compared to child nodes with higher priority 
	 * 
	 * @param index
	 */
	private void sink(int index) {
		
		while(hasLeftChild(index)) {
			
			int smallChild = getLeftChild(index);
			if(hasRightChild(index)) {
				if(less(arr[getRightChild(index)], arr[smallChild]))
					smallChild = getRightChild(index);
			}
			
			if(less(arr[index], arr[smallChild])) break;
			else
				swap(index, smallChild);
			
			index = smallChild;
		}
		
	}
	
	
	/**
	 * 
	 * Relocation compared to parent node 
	 * if child node is smaller than parent node
	 * 
	 * @param index
	 */
	private void swim(int index) {
		
		while(hasParent(index)) {
			int parent = getParent(index);
			if(less(arr[index], arr[parent])) {
				swap(parent, index);
				index = parent;
			}
			else break;
		}
		
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int getSize() {
		return size;
	}
	
	private int getLeftChild(int index) {
		return index * 2 + 1;
	}
	
	private int getRightChild(int index) {
		return index * 2 + 2;
	}
	
	private int getParent(int index) {
		return (index - 1) / 2;
	}
	
	private boolean hasLeftChild(int index) {
		return getLeftChild(index) < size;
	}

	private boolean hasRightChild(int index) {
		return getRightChild(index) < size;
	}
	
	private boolean hasParent(int index) {
		return getParent(index) >= 0;
	}
	
	private void swap(int index1, int index2) {
		T temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
	private static boolean less(Comparable o1, Comparable o2) {
		return o1.compareTo(o2) < 0;
	}
	
}
