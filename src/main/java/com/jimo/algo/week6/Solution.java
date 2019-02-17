package com.jimo.algo.week6;

import java.awt.*;
import java.util.LinkedList;

/**
 * @author jimo
 * @date 19-2-17 上午10:04
 */
public class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	static class Record {
		int val;
		int level;

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Record) {
				Record t = (Record) obj;
				return val != t.val && level == t.level;
			}
			return false;
		}
	}

	public boolean isCousins(TreeNode root, int x, int y) {
		Record rx = new Record();
		Record ry = new Record();
		traverse(root, rx, x, -1, 0);
		traverse(root, ry, y, -1, 0);
		return rx.equals(ry);
	}

	private void traverse(TreeNode p, Record r, int v, int pVal, int level) {
		if (p == null) {
			return;
		}
		if (p.val == v) {
			r.val = pVal;
			r.level = level;
		}
		traverse(p.left, r, v, p.val, level + 1);
		traverse(p.right, r, v, p.val, level + 1);
	}

	public int orangesRotting(int[][] grid) {
		int cnt = -1;

		while (!allBack(grid)) {
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					// 边缘

					// 中间

				}
			}
		}

		return cnt;
	}

	private boolean allBack(int[][] grid) {
		return false;
	}
}
