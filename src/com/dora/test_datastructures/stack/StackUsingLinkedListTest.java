package com.dora.test_datastructures.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.dora.datastructures.stack.StackUsingDArray;
import com.dora.datastructures.stack.StackUsingLinkedList;

class StackUsingLinkedListTest {

	@Test
	void createEmptyStack() {
		StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<>();
		assertEquals(stack.getSize(), 0);
	}
	
	@Test
	void testPush() {
		
		StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<>();
		
		for(int i = 0; i < 10; i++)
			stack.push(i);
		
		assertEquals(stack.getSize(), 10);
		
	}
	
	@Test
	void testPop() {
		
		StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<>();
		
		for(int i = 0; i < 10; i++)
			stack.push(i);
		
		int num = 0;
		for(int i = 0; i < 10; i++){
			num = stack.pop();
			assertEquals(stack.getSize(), 9 - i);
			assertEquals(num, 9 - i);
		}
		
	}

}
