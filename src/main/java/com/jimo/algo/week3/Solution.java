package com.jimo.algo.week3;

import java.util.*;

/**
 * @author jimo
 * @date 19-1-6 上午10:30
 */
public class Solution {

	public List<Integer> powerfulIntegers(int x, int y, int bound) {
		Set<Integer> set = new HashSet<>();
		int nx = (int) (Math.log(bound) / Math.log(x));
		int ny = (int) (Math.log(bound) / Math.log(y));
		if (x <= 1) {
			nx = 1;
		}
		if (y <= 1) {
			ny = 1;
		}
		for (int i = 0; i <= nx; i++) {
			for (int j = 0; j <= ny; j++) {
				int xi = (int) Math.pow(x, i);
				int yj = (int) Math.pow(y, j);
				if (xi + yj <= bound) {
					set.add(xi + yj);
				}
			}
		}
		return new ArrayList<>(set);
	}

	public List<Integer> pancakeSort(int[] A) {
		List<Integer> re = new ArrayList<>();
		for (int i = A.length - 1; i >= 0; i--) {
			// flip up
			int maxIndex = biggestIndex(A, i);
			flip(A, maxIndex);
			re.add(maxIndex + 1);
			// flip down
			flip(A, i);
			re.add(i + 1);
		}
		return re;
	}

	private void flip(int[] a, int end) {
		int i = 0, j = end;
		while (i < j) {
			int t = a[i];
			a[i] = a[j];
			a[j] = t;
			i++;
			j--;
		}
	}

	private int biggestIndex(int[] a, int i) {
		int max = a[i];
		int maxIndex = i;
		for (int j = 0; j < i; j++) {
			if (a[j] > max) {
				max = a[j];
				maxIndex = j;
			}
		}
		return maxIndex;
	}
/*
	private void flip(List<Integer> re, int[] a, int[] dest, int cnt) {
		if (cnt > a.length * 10) {
			return;
		}
		for (int i = 2; i < a.length; i++) {
			re.add(i);
			int[] ar = reverse(a, i);
			if (Arrays.equals(ar, dest)) {
				return;
			}
			flip(re, ar, dest, cnt + 1);
		}
	}

	public int[] reverse(int[] a, int end) {
		int[] re = new int[a.length];
		System.arraycopy(a, 0, re, 0, a.length);
		int j = 0;
		for (int i = end; i >= 0; i--) {
			re[j++] = a[i];
		}
		return re;
	}*/
}
