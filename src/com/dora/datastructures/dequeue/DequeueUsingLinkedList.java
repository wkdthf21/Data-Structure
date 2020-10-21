package com.dora.datastructures.dequeue;

/**
 * 
 * Dequeue Using Doubly LinkedList 
 * 
 * @author yesol
 *
 * @param <T>
 */
public class DequeueUsingLinkedList<T> {
	
	
	private static class QueueNode<T>{
		
		T data;
		QueueNode<T> prev;
		QueueNode<T> next;
		
		public QueueNode(T data, QueueNode<T> prev, QueueNode<T> next){
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
	}
	
	int size;
	QueueNode<T> front;
	QueueNode<T> rear;
	
	public DequeueUsingLinkedList() {
		size = 0;
		front = null;
		rear = null;
	}
	
	/**
	 * 
	 * insert element into the first position of LinkedList
	 * 
	 * @param data
	 */
	public void insertFront(T data) {
		
		QueueNode<T> node = new QueueNode<>(data, null, null);
		
		if(isEmpty()) {
			front = node;
			rear = node;
		}
		else {
			node.next = front;
			front.prev = node;
			front = node;
		}
		
		++size;
		
	}

	/**
	 * 
	 * insert element into the last position of LinkedList
	 * 
	 * @param data
	 */
	public void insertRear(T data) {
		QueueNode<T> node = new QueueNode<>(data, null, null);
		
		if(isEmpty()) {
			front = node;
			rear = node;
		}
		else {
			node.prev = rear;
			rear.next = node;
			rear = node;
		}
		
		++size;
		
	}
	
	/**
	 * 
	 * pop element from the first position of linked list
	 * 
	 * @return
	 */
	public T popFront() {
		
		if(isEmpty()) throw new RuntimeException("Dequeue is Empty");
		
		QueueNode<T> node = front;
		front = front.next;
		if(front == null) rear = null;
		else {
			front.prev.next = null;
			front.prev = null;
		}
		
		--size;
	
		return node.data;
	}
	
	/**
	 * 
	 * pop element from the last position of linked list
	 * 
	 * @return
	 */
	public T popRear() {
		
		if(isEmpty()) throw new RuntimeException("Dequeue is Empty");
		
		QueueNode<T> node = rear;
		rear = rear.prev;
		if(rear == null) front = null;
		else {
			rear.next.prev = null;
			rear.next = null;
		}
		
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
