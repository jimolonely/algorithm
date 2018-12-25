package com.jimo.algo.week1;

import java.util.Arrays;

import static java.lang.Math.*;

/**
 * @author jimo
 * @date 18-12-15 下午5:59
 */
public class BigEyeballDp {

	public int bigEyeball(int[] eyes) {
		int n = eyes.length;
		int[][] dp = new int[n + 1][];

		int sum = sum(eyes);

		initArray(dp, sum);

		dp[0][0] = 0;

		for (int i = 1; i <= eyes.length; i++) {
			int s = eyes[i - 1];
			for (int j = 0; j <= sum - s; j++) {
				if (dp[i - 1][j] < 0) {
					continue;
				}
				// not choose
				dp[i][j] = max(dp[i][j], dp[i - 1][j]);
				// put in bigger
				dp[i][j + s] = max(dp[i][j + s], dp[i - 1][j]);
				// put in smaller, 2 situation
				dp[i][abs(j - s)] = max(dp[i][abs(j - s)], dp[i - 1][j] + min(j, s));
			}
		}
//		printArray(dp);
		return dp[n][0];
	}

	private void initArray(int[][] dp, int sum) {
		for (int i = 0; i < dp.length; i++) {
			dp[i] = new int[sum + 1];
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = -1;
			}
		}
	}

	private int sum(int[] eyes) {
		int sum = 0;
		for (int s : eyes) {
			sum += s;
		}
		return sum;
	}

	private void printArray(int[][] a) {
		System.out.println();
		for (int[] ai : a) {
			System.out.print("[");
			for (int i : ai) {
				System.out.print(i + " ");
			}
			System.out.print("]");
			System.out.println();
		}
	}


	public int bigEyeballDim1(int[] eyes) {
		int n = eyes.length;
		int sum = sum(eyes);
		int[] dp = new int[sum + 1];

		Arrays.fill(dp, -1);
		dp[0] = 0;
		for (int s : eyes) {
			int[] old = Arrays.copyOf(dp, dp.length);
			for (int i = 0; i <= sum - s; i++) {
				if (old[i] < 0) {
					continue;
				}
				dp[i + s] = max(dp[i + s], old[i]);
				dp[abs(i - s)] = max(dp[abs(i - s)], old[i] + min(s, i));
			}
		}
		return dp[0];
	}
}
