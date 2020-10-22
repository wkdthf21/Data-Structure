package com.dora.datastructures.tree;

/**
 * 
 * Binary Search Tree Using Linked List
 * 
 * @author yesol
 *
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>>{

	
	private static class Node<T>{
		T data;
		Node<T> left;
		Node<T> right;
		
		public Node(T data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
	}
	
	
	private Node<T> root;
	private int nodeCount;
	
	
	public BinarySearchTree() {
		root = null;
		nodeCount = 0;
	}
	
	
	/**
	 * 
	 * add data if tree does not contain data
	 * 
	 * @param data
	 * @return
	 */
	public boolean add(T data) {
		
		if(contains(data)) return false;
		else {
			root = add(root, data);
			++nodeCount;
			return true;
		}
		
	}
	
	
	/**
	 * 
	 * remove data if tree contains data
	 * 
	 * @param data
	 * @return
	 */
	public boolean remove(T data) {
		
		if(!contains(data)) return false;
		else {
			root = remove(root, data);
			--nodeCount;
			return true;
		}
	}
	
	
	/**
	 * 
	 * add data 
	 * 
	 * if node is null, create & return new node
	 * new node is connected recursively
	 * 
	 * @param node
	 * @param data
	 * @return
	 */
	private Node<T> add(Node<T> node, T data) {
		
		if(node == null) {
			return new Node<>(data, null, null);
		}
		else {
			
			int comp = node.data.compareTo(data);
			if(0 < comp) {
				node.left = add(node.left, data);
			}
			else {
				node.right = add(node.right, data);
			}
			
		}
		
		return node;
		
	}
	
	
	/**
	 * 
	 * remove data 
	 * 
	 * find node until find data
	 * if find node,
	 * 
	 * case 1. left child is null or no subtree at all
	 * case 2. only right child is null
	 * case 3. left & right child exist 
	 * 			-> find min value from right subtree
	 * 
	 * @param node
	 * @param data
	 * @return
	 */
	private Node<T> remove(Node<T> node, T data){
		
		int comp = node.data.compareTo(data);
		
		if(0 < comp) {
			node.left = remove(node.left, data);
		}
		else if(comp < 0) {
			node.right = remove(node.right, data);
		}
		else {
			
			if(node.left == null) {
				
				Node<T> rightChild = node.right;
				node.data = null;
				node.right = null;
				return rightChild;
				
			}
			else if(node.right == null) {
				Node<T> leftChild = node.left;
				node.data = null;
				node.right = null;
				return leftChild;
			}
			else {
				
				// find min value from right subtree
				Node<T> minNode = findMin(node.right);
				
				node.data = minNode.data;
				
				node.right = remove(node.right, minNode.data);
				
			}
			
		}
		
		return node;
	}
	
	
	public boolean isEmpty() {
		return nodeCount == 0;
	}
	
	public int getSize() {
		return nodeCount;
	}
	
	private Node<T> findMin(Node<T> node){
		while(node.left != null) node = node.left;
		return node;
	}
	
	private boolean contains(T data) {
		return contains(root, data);
	}
	
	
	private boolean contains(Node<T> node, T data) {
		
		if(node == null) return false;
		
		int comp = node.data.compareTo(data);
		
		// data < node.data 
		if(0 < comp) return contains(node.left, data);
		
		// node.data < data
		else if(comp < 0) return contains(node.right, data);
		
		// node.data == data
		else return true;

	}
	
}
