package com.jimo.algo.week5;

/**
 * @author jimo
 * @date 19-1-27 上午10:29
 */
public class Solution {

	public String strWithout3a3b(int A, int B) {
		StringBuilder sb = new StringBuilder();
		while (A > 0 || B > 0) {
			boolean writeA = false;
			int len = sb.length();
			if (len >= 2 && sb.charAt(len - 1) == sb.charAt(len - 2)) {
				if (sb.charAt(len - 1) == 'b') {
					writeA = true;
				}
			} else if (A >= B) {
				writeA = true;
			}
			if (writeA) {
				A--;
				sb.append('a');
			} else {
				B--;
				sb.append('b');
			}
		}
		return sb.toString();
	}
}
