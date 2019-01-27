package com.jimo.algo.week5;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

	Solution s = new Solution();


	@Test
	public void strWithout3a3b() {
		System.out.println(s.strWithout3a3b(1, 2));
		System.out.println(s.strWithout3a3b(4, 1));
		System.out.println(s.strWithout3a3b(1, 1));
		System.out.println(s.strWithout3a3b(2, 3));
		System.out.println(s.strWithout3a3b(5, 6));
		System.out.println(s.strWithout3a3b(4, 2));
		System.out.println(s.strWithout3a3b(27, 33));
	}
}