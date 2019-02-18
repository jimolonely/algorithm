package com.jimo.algo.medium;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

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

	public double minAreaFreeRect(int[][] points) {
		double minArea = Double.MAX_VALUE;

		Point[] p = new Point[points.length];
		Set<Point> set = new HashSet<>();
		for (int i = 0; i < points.length; i++) {
			p[i] = new Point(points[i][0], points[i][1]);
			set.add(p[i]);
		}

		for (int i = 0; i < points.length; i++) {
			Point p1 = p[i];
			for (int j = 0; j < points.length; j++) {
				if (j == i) {
					continue;
				}
				Point p2 = p[j];
				for (int k = j + 1; k < points.length; k++) {
					if (k == i) {
						continue;
					}
					Point p3 = p[k];
					Point p4 = new Point(p2.x + p3.x - p1.x, p2.y + p3.y - p1.y);
					if (set.contains(p4)) {
						int dot = (p2.x - p1.x) * (p3.x - p1.x) + (p2.y - p1.y) * (p3.y - p1.y);
						if (dot == 0) {
							double area = p1.distance(p2) * p2.distance(p4);
							minArea = Math.min(minArea, area);
						}
					}
				}
			}
		}
		return minArea < Double.MAX_VALUE ? minArea : 0;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}
		int len = lists.length;
		while (len > 1) {
			int m = (len + 1) / 2;
			for (int i = 0; i < len / 2; i++) {
				lists[i] = mergeTwoList(lists[i], lists[i + m]);
			}
			len = m;
		}
		return lists[0];
	}

	private ListNode mergeTwoList(ListNode l1, ListNode l2) {
		ListNode headBefore = new ListNode(-1);
		ListNode cur = headBefore;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		if (l1 != null) {
			cur.next = l1;
		}
		if (l2 != null) {
			cur.next = l2;
		}
		return headBefore.next;
	}
}
