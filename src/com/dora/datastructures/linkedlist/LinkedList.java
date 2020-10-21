package com.dora.datastructures.linkedlist;

/**
 * single linekd list
 * 
 * @author yesol
 *
 */

public class LinkedList<T> {

	
	// Node inner class
	private static class Node<T>{
		
		private T data;
		private Node<T> next;
		
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
		
	}
	
	private Node<T> head;
	private int size;
	
	/**
	 * constructor
	 */
	public LinkedList(){
		head = null;
		size = 0;
	}
	
	
	/**
	 * add data to the last index
	 * @param data
	 */
	public void add(T data) {
		
		if(isEmpty()) {
			head = new Node<>(data, null);
			++size;
			return;
		}
		
		Node<T> cur = head;
		
		while(cur.next != null)
			cur = cur.next;
		
		Node<T> newNode = new Node<>(data, null);
		cur.next = newNode;
		++size;
		
	}
	
	
	
	/**
	 * insert data at the input index
	 * 
	 * @param data
	 * @param index
	 */
	public void insert(T data, int index) {
		
		if(index < 0 || size < index) throw new IndexOutOfBoundsException();
		
		if(isEmpty()) {
			
			if(index != 0) throw new IndexOutOfBoundsException();
			else {
				head = new Node<>(data, null);
				++size;
			}
			
			return;
		}
		
		else {
			
			Node<T> cur = head;
			Node<T> prev = null;
			
			for(int i = 0; i < index; i++) {
				if(i == index - 1) prev = cur;
				cur = cur.next;
			}
			
			Node<T> newNode = new Node<>(data, null);
			// index == 0 (index at first index)
			if(prev == null) {
				newNode.next = head;
				head = newNode;
			}
			// index == size (insert at last index)
			else if(cur == null) {
				prev.next = newNode;
			}
			else {
				prev.next = newNode;
				newNode.next = cur;
			}
			
			++size;
			
		}
		
	}
	
	
	
	/**
	 * remove input object from LinkedList
	 * 
	 * @param obj
	 */
	public boolean remove(Object obj) {
		
		Node<T> cur = head;
		Node<T> prev = null;
		
		boolean isFound = false;
		if(obj == null) {
			
			for(; cur != null; cur = cur.next) {
				
				if(cur.data == null) {
					isFound = true;
					break;
				}
				
				prev = cur;
				
			}
			
		}
		else {
			
			for(; cur != null; cur = cur.next) {
				
				if(cur.data.equals(obj)) {
					isFound = true;
					break;
				}
				
				prev = cur;
				
			}
			
		}
		
		
		if(isFound == false) return false;
		
		if(prev == null) {
			head = head.next;
			--this.size;
			return true;
		}
		else if(cur.next == null) {
			prev.next = null;
			--this.size;
			return true;
		}
		else {
			prev.next = cur.next;
			--this.size;
			return true;
		}
		
	}
	
	
	/**
	 * find index of input object
	 * 
	 * @param obj
	 * @return
	 */
	public int indextOf(Object obj) {
		
		if(isEmpty()) return -1;
		
		Node<T> cur = head;
		
		if(obj == null) {
			for(int index = 0; cur != null; cur = cur.next, index++) {
				if(cur.data == null) return index;
			}
		}
		else {
			
			for(int index = 0; cur != null; cur = cur.next, index++) {
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
	
}
