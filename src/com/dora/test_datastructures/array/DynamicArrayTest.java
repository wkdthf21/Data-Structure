package com.dora.test_datastructures.array;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.dora.datastructures.array.DynamicArray;

class DynamicArrayTest {

	@Test
	void createEmptyList() {
		DynamicArray<Integer> darr = new DynamicArray<>();
		assertTrue(darr.isEmpty());
	}
	
	@Test
	void removeIllegalIndex() {
		DynamicArray<Integer> darr = new DynamicArray<>();
		
		for(int i = 0; i < 10; i++)
			darr.add(i);
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			darr.removeAt(100);
		});
	
	}
	
	@Test
	void testSizeAndCapacity() {
		
		DynamicArray<Integer> darr = new DynamicArray<>();
		
		int prevSize = darr.getSize();
		int prevCapacity = darr.getCapacity();
		
		assertEquals(prevSize, 0);
		
		for(int i = 0; i < 10; i++) {
			darr.add(i);
		}
		
		assertEquals(darr.getSize(), 10);
		assertEquals(prevCapacity * 2, darr.getCapacity());
		
	}

}
