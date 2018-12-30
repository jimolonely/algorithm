package com.jimo.algo.week2;

import java.util.*;

public class Solution {

	public int[] numsSameConsecDiff(int N, int K) {

		// 1000,0000,00 -> 2147,4836,47

		// 连续位上之差只能为0-9，特殊情况是0

		// 2<=N<=10 , 0<=k<=9, 采用暴力

		// 1: 1-2,2-3,...,8-9
		// 2: 1-3,2-4,...,7-9
		// 3:
		Map<Integer, List<Integer>> m = new HashMap<>(N);
		for (int i = 0; i <= 9; i++) {
			final int j = Math.abs(K + i);
			if (j < 10) {
				final List<Integer> l1 = m.getOrDefault(i, new ArrayList<>());
				l1.add(j);
				m.put(i, l1);
				final List<Integer> l2 = m.getOrDefault(j, new ArrayList<>());
				l2.add(i);
				m.put(j, l2);
			}
		}
		Set<Integer> re = new HashSet<>();
		if (N == 1) {
			return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		}
		for (int i = 1; i <= 9; i++) {
			final StringBuilder sb = new StringBuilder();
			concat(i, sb, m, re, N);
		}
		int[] a = new int[re.size()];
		int i = 0;
		for (Integer x : re) {
			a[i++] = x;
		}
		return a;
	}

	public void concat(int pre, StringBuilder sb, Map<Integer, List<Integer>> m, Set<Integer> re, int n) {
		if (n == sb.length()) {
			// 溢出
			if (n == 10) {
				final int prere = Integer.parseInt(sb.substring(0, 9));
				final boolean overflow =
						(prere > Integer.MAX_VALUE / 10 ||
								prere == Integer.MAX_VALUE / 10
										&& Integer.parseInt(sb.substring(9), 10) > 7
						);
				if (!overflow) {
					re.add(Integer.parseInt(sb.toString(), 10));
				}
			} else {
				re.add(Integer.parseInt(sb.toString(), 10));
			}
			return;
		}
		sb.append(pre);
		final List<Integer> back = m.get(pre);
		if (back != null) {
			for (Integer b : back) {
				concat(b, new StringBuilder(sb), m, re, n);
			}
		}
	}


	public String[] spellchecker(String[] wordlist, String[] queries) {

//		for (String query : queries) {
//			// 替换元音
//			query.replaceAll("a", )
//		}
		return null;
	}
}
