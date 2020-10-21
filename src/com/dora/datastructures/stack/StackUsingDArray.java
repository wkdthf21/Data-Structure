package com.dora.datastructures.stack;


/**
 * 
 * Stack Using Dynamic Array
 * 
 * If the capacity is exceeded, the capacity is doubled and reassigned
 * 
 * @author yesol
 *
 */
public class StackUsingDArray<T> {
	
	T[] arr;
	int capacity;
	int size;
	
	/**
	 * constructor
	 */
	public StackUsingDArray(){
		this(8);
	}
	
	public StackUsingDArray(int capacity){
		arr = (T[])new Object[capacity];
		this.capacity = capacity;
		this.size = 0;
	}
	
	// push, pop, isEmpty, getSize, isFull, peek
	public void push(T data) {
		
		if(isFull()) {
			capacity *= 2;
			T[] newArr = (T[])new Object[capacity];
			for(int i = 0; i < size; i++) newArr[i] = arr[i];
			arr = newArr;
		}
		
		arr[size++] = data;	
	}
	
	public T pop() {
		if(isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		
		T data = arr[size-1];
		arr[size-1] = null;
		size--;
		
		return data;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
		
	}
	
	public int getSize() {
		return size;
	}
	
	public T peek() {
		if(isEmpty()) throw new RuntimeException("Stack is Empty");
		return arr[size-1];
	}
	
	private boolean isFull() {
		return this.size == this.capacity;
	}
	
	
}
