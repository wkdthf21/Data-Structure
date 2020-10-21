package com.dora.test_datastructures.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.dora.datastructures.queue.QueueUsingLinkedList;

class QueueUsingLinkedListTest {

	@Test
	void createEmptyQueue() {
		QueueUsingLinkedList<Integer> queue = new QueueUsingLinkedList<>();
		assertTrue(queue.isEmpty());
	}
	
	@Test
	void testPush() {
		QueueUsingLinkedList<Integer> queue = new QueueUsingLinkedList<>();
		
		for(int i = 0; i < 10; i++) queue.push(i);
		
		assertEquals(queue.getSize(), 10);
		
	}
	
	@Test
	void testPop() {
		QueueUsingLinkedList<Integer> queue = new QueueUsingLinkedList<>();
		
		for(int i = 0; i < 10; i++) queue.push(i);
		
		for(int i = 0; i < 10; i++) {
			int num = queue.pop();
			assertEquals(queue.getSize(), 9 - i);
			assertEquals(num, i);
		}
	}

}
