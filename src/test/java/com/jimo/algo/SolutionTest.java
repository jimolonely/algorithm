package com.jimo.algo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

	Solution s = new Solution();

	@Test
	public void test() {

		int[] re = s.prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7);
		for (int i : re) {
			System.out.print(i + " ");
		}
	}

	@Test
	public void reverseString() {
		assertEquals("54321", s.reverseString("12345"));
	}

	@Test
	public void reverse() {
		assertEquals(123, s.reverse(321));
		assertEquals(-123, s.reverse(-321));
		assertEquals(-12, s.reverse(-210));
//		Integer.MIN_VALUE;
		assertEquals(0, s.reverse(1534236469));

		System.out.println(Integer.MAX_VALUE + 1);
	}

	@Test
	public void merge() {
		int[] n1 = {1, 2, 3, 0, 0, 0};
		int[] n2 = {2, 5, 6};
		s.merge(n1, 3, n2, 3);
		for (int i : n1) {
			System.out.print(i + " ");
		}
	}

	@Test
	public void fizzBuzz() {
		List<String> list = s.fizzBuzz(15);
		list.forEach(System.out::println);
	}

	@Test
	public void hammingWeight() {
		int c = s.hammingWeight(-3);
		assertEquals(31, c);
	}

	@Test
	public void hammingDistance() {
		int c = s.hammingDistance(4, 2);
		assertEquals(2, c);
	}

	@Test
	public void maxProfit() {
		assertEquals(7, s.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
		assertEquals(4, s.maxProfit(new int[]{1, 2, 3, 4, 5}));
		assertEquals(0, s.maxProfit(new int[]{7, 6, 4, 3, 1}));
	}

	@Test
	public void rotate() {
		int[] n = {1, 2, 3, 4, 5, 6, 7};
		s.rotate(n, 3);
		for (int i : n) {
			System.out.print(i + " ");
		}
		s.rotate(n, 7);
		for (int i : n) {
			System.out.print(i + " ");
		}
	}

	@Test
	public void intersect() {
		int[] n = s.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
		for (int i : n) {
			System.out.print(i + " ");
		}
	}

	@Test
	public void plusOne() {
		for (int i : s.plusOne(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
				9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
				9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9})) {
			System.out.print(i + " ");
		}
	}

	@Test
	public void firstUniqChar() {
		assertEquals(8, s.firstUniqChar("dddccdbba"));
		assertEquals(0, s.firstUniqChar("leetcode"));
		assertEquals(2, s.firstUniqChar("loveleetcode"));
	}

	@Test
	public void isPalindrome() {
		assertTrue(s.isPalindrome("A man, a plan, a canal: Panama"));
		assertFalse(s.isPalindrome("race a car"));
	}
}

