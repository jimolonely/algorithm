package com.jimo.algo.high;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

	Solution s = new Solution();

	@Test
	public void calculate() {
		assertEquals(7, s.calculate("3+ 2* 2"));
	}
}