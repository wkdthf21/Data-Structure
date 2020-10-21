package com.dora.datastructures.array;

import java.util.Iterator;

/**
 * 
 * generic dynamic array
 * 
 * If the capacity is exceeded, the capacity is doubled and reassigned
 * 
 * @author wkdthf21
 *
 * @param <T>
 */
public class DynamicArray<T> implements Iterable<T> {

	T[] arr;
	int size;
	int capacity;
	
	
	/*
	 * 	constructor
	 * 
	 */
	public DynamicArray() {
		this(8);
	}
	
	public DynamicArray(int capacity) {
		
		if(capacity < 0)
			throw new IllegalArgumentException("Dynamic Array Illegal Capacity : " + capacity);
		
		this.capacity = capacity;
		arr = (T[])new Object[capacity];
		size = 0;
		
	}
	
	
	/**
	 * get element using index
	 * 
	 * @param index
	 * @return
	 */
	public T get(int index) {
		return arr[index];
	}
	
	
	/**
	 * add element into last index
	 * 
	 * @param element
	 */
	public void add(T element) {
		
		// If the capacity is exceeded
		if(this.capacity == this.size) {
			
			// the capacity is doubled and reassigned
			if(this.capacity == 0) this.capacity = 1;
			else if(0 < this.capacity) this.capacity *= 2;
			
			T[] newArr = (T[])new Object[capacity];
			
			for(int i = 0; i < this.size; i++) {
				newArr[i] = this.arr[i];
			}
			
			arr = newArr;
			
		}
		
		arr[size++] = element;
		
	}
	
	
	/*
	 * return whether the array is empty
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	
	/**
	 * 
	 * remove element at the input index
	 * 
	 * @param index
	 * @return
	 */
	public T removeAt(int index) {
		
		if(index < 0 || this.size <= index) throw new IndexOutOfBoundsException();
		
		T data = this.arr[index];
		if(index == this.size - 1) this.arr[index] = null;
		else {
			for(int i = index + 1; i < this.size; i++) {
				this.arr[i - 1] = this.arr[i];
			}
		}
		
		--this.size;
		
		return data;
	}
	
	
	/**
	 * 
	 * return input object's index in the array
	 * 
	 * @param obj
	 * @return
	 */
	public int indexOf(Object obj) {
		
		
		if(obj == null) {
			for(int i = 0; i < size; i++) {
				if(this.arr[i] == null) return i;
			}
		}
		
		else {
			for(int i = 0; i < size; i++) {
				if(obj.equals(arr[i])) return i;
			}
		}
		
		return -1;
	}
	
	
	/*
	 * get dynamic array size
	 * 
	 */
	public int getSize() {
		return this.size;
	}
	
	/*
	 * get dynamic array capacity
	 * 
	 */
	public int getCapacity() {
		return this.capacity;
	}


	@Override
	public Iterator<T> iterator() {
		return new java.util.Iterator<T>() {

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				return null;
			}
			
		};
	}
	
}
