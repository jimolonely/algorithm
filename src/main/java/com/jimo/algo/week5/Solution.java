package com.jimo.algo.week5;

/**
 * @author jimo
 * @date 19-1-27 上午10:29
 */
public class Solution {

	public String strWithout3a3b(int A, int B) {
		StringBuilder sb = new StringBuilder();
		char tA = 'a';
		char tB = 'b';
		if (A < B) {
			tA = 'b';
			tB = 'a';
			int t = B;
			B = A;
			A = t;
		}
		if (A <= B + 1) {
			for (int i = 0; i < A + B; i++) {
				if (i % 2 == 0) {
					sb.append(tA);
				} else {
					sb.append(tB);
				}
			}
		} else {
			int cnt = 0;
			int cntA = 0;
			for (int i = 0; i < A + B; i++) {
				if (cnt < 2 && cntA < A) {
					sb.append(tA);
					cnt++;
					cntA++;
				} else {
					sb.append(tB);
					cnt = 0;
				}
			}
		}
		return sb.toString();
	}
}
