package com.jimo.algo.medium;

/**
 * @author jimo
 * @date 19-2-15 上午8:46
 */
public class Solution {

	public int brokenCalc(int X, int Y) {
		int cnt = 0;
		while (Y > X) {
			if (Y % 2 == 0) {
				Y /= 2;
			} else {
				Y++;
			}
			cnt++;
		}
		return cnt + X - Y;
	}
}
