package com.jimo.algo.week1;

/**
 * <p>
 * 超哥开了一个造仿真机器人的公司，最近新出了一个造机器人眼球的测试机，但是造出来的眼球大小不一，你知道造眼球的原料很贵的，为了不浪费，
 * 他想将这些眼球合并成2个最大的眼球，当然不是为了摸的，是用来做广告宣传。
 * 问题来了，2个眼球必须一样大，且原来的单个小眼球不可分割，如果能够造成功，返回最大眼球的size，否则返回0。
 * 例如：
 * 输入小眼球数组(eyeball[n])：[1,1,2,3,6]，输出6（1，2，3合并为6,余下1）；
 * 输入：[1,2]，返回0，不可造。
 * <p>
 * 请大家帮助超哥吧^_^。
 * <p>
 * 数据限制：
 * 1. 1<= n <=20
 * 2. 1<= eyeball[i] <=1000 (0<=i<n)
 * 3. sum(eyeball[i])<=5000(即眼球之和最大为5000)
 * </p>
 *
 * @author jimo
 * @date 18-12-14 上午8:28
 */
public class BigEyeball {

	class Comb {
		int sum;
		int[] sub;
	}

	int bigEyeball(int[] eyes) {
		int maxSize = 0;
		// 1
		maxSize = Math.max(maxSize, getMax1(eyes));
		// 2
		maxSize = Math.max(maxSize, getMax2(eyes));
		//...
		// 20
		maxSize = Math.max(maxSize, getMax2(eyes));

		// 每一种情况：从1到n-1
		for (int i = 1; i < eyes.length; i++) {
			// 求得这种情况下所有组合和子数组
			Comb[] c = getCombination(eyes, i);
			for (Comb comb : c) {
				if (foundEqual(comb.sum, comb.sub)) {
					maxSize = Math.max(maxSize, comb.sum);
				}
			}
		}

		return maxSize;
	}

	private Comb[] getCombination(int[] eyes, int cnt) {
		return new Comb[0];
	}

	/**
	 * 求在只有一个眼球为最大时的情况
	 */
	private int getMax(int i, int[] eyes) {

		// 1


		// 2
		int max = getMax2(eyes);

		// 3
		for (int j = 0; j < eyes.length; j++) {
			int[] sub = removeIndex(eyes, j);
			//2
			max = Math.max(max, eyes[j] + getMax2(sub));
		}

		return 0;
	}

	public int getMax2(int[] eyes) {
		int max = 0;
		///
//		for (int j = 0; j < eyes.length; j++) {
//			int[] sub = removeIndex(eyes, j);
//			//1
//			max = Math.max(max, eyes[j] + getMax1(sub));
//		}
		for (int i = 0; i < eyes.length - 1; i++) {
			for (int j = i + 1; j < eyes.length; j++) {
				int[] sub = removeIndex(removeIndex(eyes, j), i);
				int x = eyes[i] + eyes[j];
				if (foundEqual(x, sub)) {
					max = Math.max(max, x);
				}
			}
		}
		return max;
	}

	public int getMax1(int[] eyes) {
		int max = 0;
		for (int j = 0; j < eyes.length; j++) {
			if (foundEqual(eyes[j], removeIndex(eyes, j))) {
				max = Math.max(max, eyes[j]);
			}
		}
		return max;
	}

	/**
	 * 判断x是否可以由arr中的数字不重复相加得到
	 *
	 * x = 0 + arr(n)
	 *          |
	 *          a1 + arr(n-1)
	 *                  |
	 *                  a2 + arr(n-2)
	 *                          ...
	 *                          an-1 + arr1
	 */
	public boolean foundEqual(int x, int[] arr) {
		if (x == 0) {
			return true;
		}
		if (x < 0) {
			return false;
		}
		if (arr.length == 1) {
			return x == arr[0];
		}
		for (int i = 0; i < arr.length; i++) {
			int[] sub = removeIndex(arr, i);
			boolean ok = foundEqual(x - arr[i], sub);
			if (ok) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 移除arr中下标i对应的元素，返回一个新的数组
	 */
	private int[] removeIndex(int[] arr, int i) {
		int[] sub = new int[arr.length - 1];
		int k = 0;
		for (int j = 0; j < arr.length; j++) {
			if (i != j) {
				sub[k++] = arr[j];
			}
		}
		return sub;
	}
}
