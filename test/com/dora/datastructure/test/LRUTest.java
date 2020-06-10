package com.dora.datastructure.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.dora.datastructure.LRU;

public class LRUTest {

	LRU lru = new LRU(3);

	@Before
	public void 캐시데이터추가(){

		for(int i = 1; i <= 3; i++)
			lru.put(i, i);

		// 3 : 3 --> 2 : 2 --> 1 : 1
		lru.print();
	}

	@Test
	public void 캐시갱신테스트(){

		lru.get(2);

		// 2 : 2 --> 3 : 3 --> 1 : 1
		lru.print();
	}

	@Test
	public void 캐시페이지교체테스트(){

		assertEquals(lru.getMapSize(), 3);

		lru.put(4, 4);

		// 4 : 4 --> 3 : 3 --> 2 : 2
		lru.print();

		assertEquals(lru.getMapSize(), 3);
	}
}