package com.jimo.algo.week4;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {

	Solution s = new Solution();

	@Test
	public void sortedSquares() {
		System.out.println(Arrays.toString(s.sortedSquares(new int[]{-4, -1, 0, 3, 10})));
	}

	@Test
	public void maxTurbulenceSize() {
		assertEquals(5, s.maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}));
		assertEquals(2, s.maxTurbulenceSize(new int[]{4, 8, 12, 16}));
		assertEquals(1, s.maxTurbulenceSize(new int[]{100}));
	}

	@Test
	public void distributeCoins() {
//		Solution.TreeNode root = new Solution.TreeNode(1);
//		root.left = new Solution.TreeNode(0);
//		root.right = new Solution.TreeNode(2);
//		assertEquals(2, s.distributeCoins(root));

		Solution.TreeNode root = new Solution.TreeNode(3);
		root.left = new Solution.TreeNode(0);
		root.right = new Solution.TreeNode(0);
		assertEquals(2, s.distributeCoins(root));
		// [1,0,0,null,3]

	}
}