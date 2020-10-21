package com.dora.test_datastructures.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.dora.datastructures.linkedlist.DoublyLinkedList;

class DoublyLinkedListTest {

	@Test
	void createEmptyList() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		assertTrue(list.isEmpty());
	}
	
	@Test
	void testAddElement() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		
		int size = 10;
		for(int i = 0; i < size; i++){
			list.add(i);
		}
		
		assertEquals(list.getSize(), size);
	}
	
	@Test
	void testInsertFirst() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		
		int size = 10;
		for(int i = 0; i < size; i++){
			list.add(i);
		}
		
		list.insert(0, 0);
		
		assertEquals(list.getSize(), size + 1);
	}
	
	@Test
	void testInsertList() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		
		int size = 10;
		for(int i = 0; i < size; i++){
			list.add(i);
		}
		
		list.insert(10, 10);
		
		assertEquals(list.getSize(), size + 1);
	}
	
	@Test
	void testSearch() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		
		int size = 10;
		for(int i = 0; i < size; i++){
			list.add(i);
		}
		
		list.insert(10, 10);
		
		assertEquals(list.indextOf(0), 0);
		assertEquals(list.indextOf(10), 10);
	}
	
	@Test
	void testRemoveException() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		
		int size = 10;
		for(int i = 0; i < size; i++){
			list.add(i);
		}
		
		assertFalse(list.remove(11));
		
	}
	
	@Test
	void testRemoveFirst() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		
		int size = 10;
		for(int i = 0; i < size; i++){
			list.add(i);
		}
		
		list.remove(0);
		
		assertEquals(list.getSize(), size-1);
		assertEquals(list.indextOf(1), 0);
	}
	
	@Test
	void testRemove() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		
		int size = 10;
		for(int i = 0; i < size; i++){
			list.add(i);
		}
		
		list.remove(4);
		list.remove(7);
		
		assertEquals(list.getSize(), size - 2);
	}
	
	@Test
	void testAllRemove() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		
		int size = 10;
		for(int i = 0; i < size; i++){
			list.add(i);
		}
		
		for(int i = 0; i < size; i++){
			list.remove(i);
		}
		
		assertTrue(list.isEmpty());
	}
	
}
