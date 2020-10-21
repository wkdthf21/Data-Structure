package com.dora.datastructures.linkedlist;

/**
 * 
 * doubly Linked List
 * 
 * @author yesol
 *
 * @param <T>
 */
public class DoublyLinkedList<T> implements Iterable<T>{	
	
	// Node inner class
	private static class Node<T>{
		
		private T data;
		private Node<T> prev;
		private Node<T> next;
		
		public Node(T data, Node<T> prev, Node<T> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
	}
	
	
	private int size;
	private Node<T> head;
	private Node<T> tail;
	
	
	/**
	 * constructor
	 */
	public DoublyLinkedList(){
		size = 0;
		head = null;
		tail = null;
	}
	
	
	/**
	 * add data to the last index
	 * @param data
	 */
	public void add(T data) {
		
		if(isEmpty()) {
			head = new Node<>(data, null, null);
			tail = head;
		}
		else {
			Node<T> newNode = new Node<>(data, tail, null);
			tail.next = newNode;
			tail = newNode;
		}
		
		++this.size;
	}
	
	
	
	/**
	 * insert data at the input index
	 * 
	 * @param data
	 * @param index
	 */
	public void insert(T data, int index) {
		
		if(index < 0 || this.size < index) throw new IndexOutOfBoundsException();
		
		if(isEmpty()) {
			
			if(index != 0) throw new IndexOutOfBoundsException();
			else {
				head = new Node<>(data, null, null);
				tail = head;
			}
			
		}
		else {
			
			Node<T> cur = head;
			
			for(int i = 0; i < index; i++) {
				cur = cur.next;
			}
			
			Node<T> newNode = new Node<>(data, null, null);
			
			// insert last
			if(cur == null) {
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
			}
			// insert first
			else if(cur.prev == null) {
				newNode.next = cur;
				cur.prev = newNode;
				head = newNode;
			}
			else {
				cur.prev.next = newNode;
				newNode.next = cur;
				newNode.prev = cur.prev;
				cur.prev = newNode; 
			}
			
			++this.size;
			
		}
		
	}
	
	
	
	/**
	 * remove input object from LinkedList
	 * 
	 * @param obj
	 */
	public boolean remove(Object obj) {
		
		
		if(isEmpty()) throw new RuntimeException("List is Empty");
		
		Node<T> cur = head;
		boolean isFound = false;
		if(obj == null) {
			for(; cur != null; cur = cur.next) {
				if(cur.data == null) {
					isFound = true;
					break;
				}
			}
		}
		else {
			
			for(; cur != null; cur = cur.next) {
				if(cur.data.equals(obj)) {
					isFound = true;
					break;
				}
			}
			
		}
		
		
		if(isFound == false) return false;
		
		// remove first
		if(cur.prev == null) {
			head = cur.next;
			if(cur.next == null) tail = null;
			else {
				cur.next.prev = null;
				cur.next = null;	
			}
		}
		// remove last
		else if(cur.next == null) {
			tail = cur.prev;
			cur.prev.next = null;
			cur.prev = null;
		}
		else {
			cur.prev.next = cur.next;
			cur.next.prev = cur.prev;
			cur.prev = null;
			cur.next = null;
		}
		
		--this.size;
		
		return true;
		
	}
	
	
	/**
	 * find index of input object
	 * 
	 * @param obj
	 * @return
	 */
	public int indextOf(Object obj) {
		
		int index = 0;
		Node<T> cur = head;
		
		if(obj == null) {
			for(; cur != null; cur = cur.next, index++) {
				if(cur.data == null) {
					return index;
				}
			}
		}
		else {
			for(; cur != null; cur = cur.next, index++) {
				if(cur.data.equals(obj)) {
					return index;
				}
			}
		}
		
		
		return -1;
		
	}
	
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	
	public int getSize() {
		return this.size;
	}
	
	
	@Override
	public java.util.Iterator<T> iterator(){
		return new java.util.Iterator<T>() {
			
			private Node<T> cur = head;
			
			@Override
			public boolean hasNext() {
				return cur != null;
			}
			
			@Override
			public T next() {
				T data = cur.data;
				cur = cur.next;
				return data;
			}
			
		};
	}
	
}
