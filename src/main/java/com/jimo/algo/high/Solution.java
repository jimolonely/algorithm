package com.jimo.algo.high;

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
}
