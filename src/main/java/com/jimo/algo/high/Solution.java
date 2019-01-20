package com.jimo.algo.high;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jimo
 * @date 2019/1/19 11:44
 */
public class Solution {

	public int maxProduct(int[] nums) {
		Tuple[] dp = new Tuple[nums.length];
		int max = nums[0];
		dp[0] = new Tuple(nums[0], nums[0]);
		for (int i = 1; i < nums.length; i++) {
			int t1 = dp[i - 1].min * nums[i];
			int t2 = dp[i - 1].max * nums[i];
			dp[i] = new
					Tuple(Math.min(nums[i], Math.min(t1, t2)), Math.max(nums[i], Math.max(t1, t2)));
			max = Math.max(dp[i].max, max);
		}
		return max;
	}

	public class Tuple {
		int min;
		int max;

		public Tuple(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}

	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[] buy = new int[n + 1];
		int[] sell = new int[n + 1];
		int[] cold = new int[n + 1];
		buy[0] = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			buy[i + 1] = Math.max(cold[i] - prices[i], buy[i]);
			sell[i + 1] = Math.max(buy[i] + prices[i], sell[i]);
			cold[i + 1] = Math.max(sell[i], Math.max(buy[i], cold[i]));
		}
		return sell[n];
	}

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

	public int longestConsecutive(int[] nums) {
		int max = 0;

		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}

		for (int num : nums) {
			set.remove(num);
			int cnt = 1;
			int low = num - 1;
			while (set.contains(low)) {
				set.remove(low);
				cnt++;
				low--;
			}
			int high = num + 1;
			while (set.contains(high)) {
				set.remove(high);
				cnt++;
				high++;
			}
			max = Math.max(max, cnt);
		}
		return max;
	}
}
