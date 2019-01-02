package com.jimo.algo.week2;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

	@Test
	public void numsSameConsecDiff() {
		final Solution s = new Solution();

		final int[] a = s.numsSameConsecDiff(1, 0);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}
}