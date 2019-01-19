package com.jimo.algo.high;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jimo
 * @date 2019/1/19 11:44
 */
public class Solution {

	public int[] productExceptSelf(int[] nums) {
		int[] pre = new int[nums.length];
		int[] post = new int[nums.length];

		pre[0] = 1;
		post[nums.length - 1] = 1;
		for (int i = 1; i < nums.length; i++) {
			pre[i] = pre[i - 1] * nums[i - 1];
		}
		for (int i = nums.length - 2; i >= 0; i--) {
			post[i] = post[i + 1] * nums[i + 1];
		}
		int[] output = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			output[i] = pre[i] * post[i];
		}
		return output;
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> re = new ArrayList<Integer>();
		if (matrix.length == 0) {
			return re;
		}
		int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length;
		// one line
		if (down == 0) {
			for (int i = 0; i < right; i++) {
				re.add(matrix[0][i]);
			}
			return re;
		}
		// one column
		if (right == 0) {
			for (int i = 0; i < down; i++) {
				re.add(matrix[i][0]);
			}
			return re;
		}
		while (up <= down) {
			for (int i = left; i <= right; i++) {
				re.add(matrix[up][i]);
			}
			if (up + 1 > down) {
				break;
			}
			for (int i = up + 1; i <= down; i++) {
				re.add(matrix[i][right]);
			}
			if (right - 1 < left) {
				break;
			}
			for (int i = right - 1; i >= left; i--) {
				re.add(matrix[down][i]);
			}
			if (down - 1 < up) {
				break;
			}
			for (int i = down - 1; i > up; i--) {
				re.add(matrix[i][left]);
			}
			up++;
			down--;
			left++;
			right--;
		}
		return re;
	}
}
