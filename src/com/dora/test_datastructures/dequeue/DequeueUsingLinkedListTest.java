package com.dora.test_datastructures.dequeue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.dora.datastructures.dequeue.DequeueUsingLinkedList;

class DequeueUsingLinkedListTest {

	@Test
	void createEmptyDequeue() {
		DequeueUsingLinkedList<Integer> dequeue = new DequeueUsingLinkedList<>();
		assertTrue(dequeue.isEmpty());
	}
	
	@Test
	void testInsertFront() {
		
		DequeueUsingLinkedList<Integer> dequeue = new DequeueUsingLinkedList<>();
		
		for(int i = 0; i < 10; i++) dequeue.insertFront(i);
		
		assertEquals(dequeue.getSize(), 10);
		for(int i = 0; i < 10; i++) assertEquals(dequeue.popRear(), i);
		assertTrue(dequeue.isEmpty());
		
	}
	
	@Test
	void testInsertRear() {
		
		DequeueUsingLinkedList<Integer> dequeue = new DequeueUsingLinkedList<>();
		
		for(int i = 0; i < 10; i++) dequeue.insertRear(i);
		
		assertEquals(dequeue.getSize(), 10);
		for(int i = 0; i < 10; i++) assertEquals(dequeue.popFront(), i);
		assertTrue(dequeue.isEmpty());
	}
	
	
	@Test
	void popEmptyDequeue() {
		
		DequeueUsingLinkedList<Integer> dequeue = new DequeueUsingLinkedList<>();
		
		for(int i = 0; i < 10; i++) dequeue.insertFront(i);
		
		for(int i = 0; i < 10; i++) dequeue.popFront();
		
		assertThrows(RuntimeException.class, () -> {
			dequeue.popFront();
		});
		
	}

}
