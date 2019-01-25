package com.jimo.algo.high;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

	Solution s = new Solution();

	@Test
	public void calculate() {
		assertEquals(7, s.calculate("3+ 2* 2"));
	}

	@Test
	public void findDuplicate() {
		assertEquals(2, s.findDuplicate(new int[]{1, 3, 4, 2, 2}));
		assertEquals(4, s.findDuplicate(new int[]{4, 3, 1, 4, 2}));
	}
}