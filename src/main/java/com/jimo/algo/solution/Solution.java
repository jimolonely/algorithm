package com.jimo.algo.solution;

/**
 * 高级算法
 *
 * @author jimo
 * @date 19-1-18 上午8:09
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
}
