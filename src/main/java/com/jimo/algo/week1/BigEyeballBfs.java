package com.jimo.algo.week1;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
public class BigEyeballBfs {

	public int bigEyeball(int[] eyes) {
		int maxSize = 0;

		for (int i = 0; i < Math.pow(3, eyes.length); i++) {
			int k = i;
			int s1 = 0;
			int s2 = 0;
			for (int s : eyes) {
				int flag = 0;
				if (k % 3 == 0) {
					// 加入球1
					s1 += s;
					flag = 1;
				} else if (k % 3 == 1) {
					// 加入球2
					s2 += s;
					flag = 2;
				} else {
					// 都不加入
				}
//				System.out.print(flag + " ");
				k /= 3;
			}
//			System.out.println();
			if (s1 == s2) {
				maxSize = Math.max(maxSize, s1);
			}
		}
		/*Ball[] state = new Ball[(int) Math.pow(3, eyes.length)];
		int t = 0;
		state[t++] = new Ball(0, 0);
		for (int size : eyes) {
			int end = t;
			for (int i = 0; i < end; i++) {
				Ball b = state[i];
				// 放入s1
				state[t++] = new Ball(b.s1 + size, b.s2);
				// 放入s2
				state[t++] = new Ball(b.s1, b.s2 + size);
				// 不放，舍去
			}
		}
		for (Ball b : state) {
			if (b.s1 == b.s2) {
				maxSize = Math.max(maxSize, b.s1);
			}
		}*/
		return maxSize;
	}


	public int bigEyeBallHalf(int[] eyes) {
		int maxSize = 0;

		int n = eyes.length;
		Map<Integer, Integer> delta1 = cal(Arrays.copyOfRange(eyes, 0, n / 2));
		Map<Integer, Integer> delta2 = cal(Arrays.copyOfRange(eyes, n / 2, n));

		// 合并，差值为0的最大情况
		for (Integer d : delta1.keySet()) {
			if (delta2.containsKey(-d)) {
				maxSize = Math.max(maxSize, delta1.get(d) + delta2.get(-d));
			}
		}

		return maxSize;
	}

	private Map<Integer, Integer> cal(int[] sizes) {
		Ball[] state = new Ball[(int) Math.pow(3, sizes.length)];
		int t = 0;
		state[t++] = new Ball(0, 0);
		for (int size : sizes) {
			int end = t;
			for (int i = 0; i < end; i++) {
				Ball b = state[i];
				// 放入s1
				state[t++] = new Ball(b.s1 + size, b.s2);
				// 放入s2
				state[t++] = new Ball(b.s1, b.s2 + size);
				// 不放，舍去
			}
		}
//		for (Ball b : state) {
//			System.out.println(b);
//		}
		Map<Integer, Integer> map = new HashMap<>(t);
		for (int i = 0; i < t; i++) {
			int s1 = state[i].s1;
			int s2 = state[i].s2;
			map.put(s1 - s2, Math.max(map.getOrDefault(s1 - s2, 0), s1));
		}
//		System.out.println();
//		for (Map.Entry<Integer, Integer> m : map.entrySet()) {
//			System.out.print("[" + m.getKey() + "," + m.getValue() + "],");
//		}
//		System.out.println();
		return map;
	}

	class Ball {
		int s1;
		int s2;

		Ball(int s1, int s2) {
			this.s1 = s1;
			this.s2 = s2;
		}

		@Override
		public String toString() {
			return "Ball{" +
					"s1=" + s1 +
					", s2=" + s2 +
					'}';
		}
	}
}
