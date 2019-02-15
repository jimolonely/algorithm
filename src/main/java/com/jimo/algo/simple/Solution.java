package com.jimo.algo.simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jimo
 * @date 19-2-15 上午8:22
 */
public class Solution {

	public List<Integer> addToArrayForm(int[] A, int K) {
		List<Integer> re = new ArrayList<>();

		int temp = K;
		for (int i = A.length - 1; i >= 0; i--) {
			temp = A[i] + temp;
			re.add(temp % 10);
			temp /= 10;
		}
		while (temp > 0) {
			re.add(temp % 10);
			temp /= 10;
		}
		Collections.reverse(re);
		return re;
	}
}
