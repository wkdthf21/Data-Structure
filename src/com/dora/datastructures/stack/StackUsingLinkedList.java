package com.dora.datastructures.stack;

/**
 * 
 * Stack using Single Linked List
 * 
 * 
 * @author yesol
 *
 */
public class StackUsingLinkedList<T> {
	
	
	private static class StackNode<T>{
		
		T data;
		StackNode<T> next;
		
		public StackNode(T data, StackNode<T> next) {
			this.data = data;
			this.next = next;
		}
		
	}
	
	
	int size;
	StackNode<T> top;	// top points at first element of linked list
	
	public StackUsingLinkedList() {
		size = 0;
		top = null;
	}
	
	
	/**
	 * push node into first element of linked list
	 * 
	 * @param data
	 */
	public void push(T data) {
		
		if(top == null) {
			top = new StackNode<>(data, null);
		}
		else {
			StackNode<T> newNode = new StackNode<>(data, null);
			newNode.next = top;
			top = newNode;
		}
		
		++size;
		
	}
	
	
	/**
	 * 
	 * pop the first element of linked list
	 * 
	 * @return
	 */
	public T pop() {
		
		if(isEmpty()) throw new RuntimeException("Stack is Empty");
		
		StackNode<T> node = top;
		top = top.next;
		
		--size;
		
		return node.data;
	}
	
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	
	public int getSize() {
		return size;
	}
	
	
	
}
