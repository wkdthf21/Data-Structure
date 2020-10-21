package com.dora.datastructures.queue;

/**
 * 
 * Queue using Doubly Linked List
 * 
 * @author yesol
 *
 * @param <T>
 */
public class QueueUsingLinkedList<T> {
	
	
	private static class QueueNode<T>{
		T data;
		QueueNode<T> prev;
		QueueNode<T> next;
		
		public QueueNode(T data, QueueNode<T> prev, QueueNode<T> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
	}
	
	
	int size;
	QueueNode<T> front;
	QueueNode<T> rear;
	
	public QueueUsingLinkedList(){
		this.size = 0;
		front = null;
		rear = null;
	}
	
	/**
	 * 
	 * push data at the last index
	 * 
	 * @param data
	 */
	public void push(T data) {
		
		QueueNode<T> node = new QueueNode<>(data, null, null);
		
		if(isEmpty()) {
			front = node;
			rear = node;
		}
		else {
			rear.next = node;
			node.prev = rear;
			rear = node;
		}
		
		++size;
		
		
	}
	
	/**
	 * 
	 * pop the data from the first index
	 * 
	 * @return
	 */
	public T pop() {
		
		if(isEmpty()) throw new RuntimeException("Stack is Empty");
		
		QueueNode<T> node = front;
		
		front = front.next;
		if(front == null) rear = null;
		else front.prev = null;
		
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
