package com.jimo.algo.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jimo
 * @date 19-1-20 上午10:30
 */
public class Solution {

	public int[] sortedSquares(int[] A) {
		int[] re = new int[A.length];

//		int mid = 0;
//		for (int i = 0; i < A.length - 1; i++) {
//			if (A[i] < 0 && A[i + 1] >= 0) {
//				mid = i + 1;
//			}
//		}

		for (int i = 0; i < A.length; i++) {
			re[i] = A[i] * A[i];
		}
		Arrays.sort(re);
		return re;
	}

	public int maxTurbulenceSize(int[] A) {
		int max = 1;
		for (int i = 0; i < A.length - 1; i++) {
			int cnt1 = 1;
			int cnt2 = 1;
			boolean c1 = true, c2 = true;
			for (int j = i + 1; j < A.length; j++) {
				if (c1) {
					if (A[j - 1] < A[j]) {
						cnt1++;
						c1 = false;
					} else {
						break;
					}
				} else {
					if (A[j - 1] > A[j]) {
						cnt1++;
						c1 = true;
					} else {
						break;
					}
				}
			}
			for (int j = i + 1; j < A.length; j++) {
				if (c2) {
					if (A[j - 1] > A[j]) {
						cnt2++;
						c2 = false;
					} else {
						break;
					}
				} else {
					if (A[j - 1] < A[j]) {
						cnt2++;
						c2 = true;
					} else {
						break;
					}
				}
			}
			max = Math.max(Math.max(cnt1, cnt2), max);
		}
		return max;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int distributeCoins(TreeNode root) {
		if (root == null) {
			return 0;
		}
		List<Integer> coins = new ArrayList<>();
		inorder(root, coins);
		int cnt = 0;
		for (int i = 0; i < coins.size(); i++) {
			if (coins.get(i) == 0) {
				int left = i - 1, right = i + 1;
				while (left >= 0 && coins.get(left) <= 1) {
					left--;
				}
				while (right < coins.size() && coins.get(right) <= 1) {
					right++;
				}
//				if (left < 0 && right < coins.size()) {
//					cnt += right - i;
//					coins.add(right, coins.get(right) - 1);
//					continue;
//				}
				int isLeft = 0;
				if (left >= 0) {
					if (right < coins.size()) {
						if (i - left < right - i) {
							isLeft = 1;
						} else {
							isLeft = 2;
						}
					} else {
						isLeft = 1;
					}
				} else if (right < coins.size()) {
					isLeft = 2;
				}
				if (isLeft == 1) {
					cnt += i - left;
					coins.set(left, coins.get(left) - 1);
				} else if (isLeft == 2) {
					cnt += right - i;
					coins.set(right, coins.get(right) - 1);
				}
			}
		}
		return cnt;
	}

	private void inorder(TreeNode root, List<Integer> coins) {
		if (root.left != null) {
			inorder(root.left, coins);
		} else if (root.right != null) {
			inorder(root.right, coins);
		}
		coins.add(root.val);
		if (root.right != null) {
			inorder(root.right, coins);
		}
	}
}
