package com.dora.test_datastructures.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.dora.datastructures.stack.StackUsingDArray;

class StackUsingDArrayTest {

	@Test
	void createEmptyStack() {
		StackUsingDArray<Integer> stack = new StackUsingDArray<>();
		assertEquals(stack.getSize(), 0);
	}
	
	@Test
	void testPush() {
		
		StackUsingDArray<Integer> stack = new StackUsingDArray<>();
		
		for(int i = 0; i < 10; i++)
			stack.push(i);
		
		assertEquals(stack.getSize(), 10);
		
	}
	
	@Test
	void testPop() {
		StackUsingDArray<Integer> stack = new StackUsingDArray<>();
		
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
