package com.dora.datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/* LRU implementation using Linked List and Map */
/* The most recently used page is at the beginning of the list (head) */
/* Deletion is done in reverse order */
public class LRU {

	private static class Node{
		int key;
		int value;
		Node prev;
		Node next;

		public Node(int key, int value){
			this.key = key;
			this.value = value;
		}
	}

	private Node head;
	private Node tail;
	private Map<Integer, Node> nodeMap;
	int cacheCapacity;

	public LRU(int cacheCapacity){
		this.nodeMap = new HashMap<>();
		this.cacheCapacity = cacheCapacity;
	}

	/* Delete Element in Map & Linked List */
	private void removeNode(Node node){
		if(node.prev != null) node.prev.next = node.next;
		if(node.next != null) node.next.prev = node.prev;
		if(node.prev == null && node.next == null){ head = null; tail = null; }
		nodeMap.remove(node.key);
	}

	/* Move Node to head */
	private void moveToHead(Node node){
		if(head == null && tail == null){
			head = node;
			tail = node;
			nodeMap.put(node.key, node);
			return;
		}
		if(node.prev != null) node.prev.next = node.next;
		if(node.next != null) node.next.prev = node.prev;
		if(head == tail) tail.next = null;
		head.prev = node;
		node.next = head;
		node.prev = null;
		head = node;
		nodeMap.put(node.key, node);
	}

	/* Call cache having key */
	public int get(int key){
		if(!nodeMap.containsKey(key)) throw new NoSuchElementException();
		Node node = nodeMap.get(key);
		removeNode(node);
		moveToHead(node);
		return node.value;
	}

	/* Write new data to cache */
	/* Remove Least Recently Used data by LRU algorithm */
	public void put(int key, int value){
		if(nodeMap.containsKey(key)){
			Node oldNode = nodeMap.get(key);
			removeNode(oldNode);
			moveToHead(oldNode);
		}
		else {
			Node newNode = new Node(key, value);
			if (nodeMap.size() == this.cacheCapacity) {
				removeNode(tail);
			}
			moveToHead(newNode);
		}
	}

	/* Print Linked List */
	public void print(){

		if(head == null){
			System.out.println("no element");
			return;
		}

		Node curNode = head;
		while(true){
			System.out.print(curNode.key + " : " + curNode.value);
			curNode = curNode.next;
			if(curNode != null) System.out.print(" --> ");
			else break;
		}
		System.out.println();
	}

	public int getMapSize(){
		return nodeMap.size();
	}

}
