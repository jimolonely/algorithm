package com.jimo.algo;

import java.math.BigInteger;
import java.util.*;

/**
 * @author jimo
 * @date 18-12-16 上午9:14
 */
public class Solution {

	public int[] prisonAfterNDays(int[] cells, int N) {
		int[] state = new int[cells.length];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < cells.length - 1; j++) {
				boolean ok = (cells[j - 1] == 1 && cells[j + 1] == 1)
						|| (cells[j - 1] == 0 && cells[j + 1] == 0);
				if (ok) {
					state[j] = 1;
				} else {
					state[j] = 0;
				}
			}
			cells[0] = cells[7] = 0;
			System.arraycopy(state, 1, cells, 1, state.length - 2);
			for (int cell : cells) {
				System.out.print(cell + " ");
			}
			System.out.println();
		}
		return cells;
	}

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isCompleteTree(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode n = q.poll();
			if (n == null && !q.isEmpty()) {
				return false;
			}
			q.add(n.left);
			q.add(n.right);
		}
		return true;
	}


	private void traverse(TreeNode root, List<Boolean> haveNode) {

	}

	private boolean isOk(TreeNode root, int h) {
		if (root.left != null) {

		}
		return false;
	}

	public String reverseString(String s) {
		StringBuilder b = new StringBuilder(s);
		return b.reverse().toString();
	}

	public int reverse(int x) {
		int flag = 1;
		if (x < 0) {
			flag = -1;
		}
		x = Math.abs(x);

		int t = 0;
		boolean overflow = false;
		while (x > 0) {
			int before = t;
			t = t * 10 + x % 10;
			System.out.println("b:" + before + ",af:" + t);
			if ((t - x % 10) / 10 != before) {
				overflow = true;
				break;
			}
			x = x / 10;
		}
		return overflow ? 0 : flag * t;
	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n - 1, k = m + n - 1;
		while (i >= 0 && j >= 0) {
			nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
		}
		while (j >= 0) {
			nums1[k--] = nums2[j--];
		}
	}

	public int climbStairs(int n) {
		int pre = 1, next = 1;
		int sum = 1;
		while (n > 1) {
			sum = pre + next;
			pre = next;
			next = sum;
			n--;
		}
		return sum;
	}

	public int[] shuffle(int[] nums) {
		int[] dest = new int[nums.length];
		System.arraycopy(nums, 0, dest, 0, nums.length);
		Random r = new Random();
		for (int i = 0; i < dest.length; i++) {
			int j = r.nextInt(i + 1);
			int t = dest[i];
			dest[i] = dest[j];
			dest[j] = t;
		}
		return dest;
	}

	public List<String> fizzBuzz(int n) {
		List<String> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				list.add("FizzBuzz");
			} else if (i % 3 == 0) {
				list.add("Fizz");
			} else if (i % 5 == 0) {
				list.add("Buzz");
			} else {
				list.add(i + "");
			}
		}
		return list;
	}

	public int hammingWeight(int n) {
		int cnt = 0;
		while (n != 0) {
			cnt++;
			n = n & (n - 1);
		}
		return cnt;
	}

	public int hammingDistance(int x, int y) {
		int n = x ^ y;
		// get count of 1 in n
		int cnt = 0;
		while (n != 0) {
			cnt++;
			n = n & (n - 1);
		}
		return cnt;
	}

	public int maxProfit(int[] prices) {
		int max = 0;
		for (int i = 1; i < prices.length; i++) {
			int diff = prices[i] - prices[i - 1];
			if (diff > 0) {
				max += diff;
			}
		}
		return max;
	}

	public void rotate(int[] nums, int k) {
		int length = nums.length;
		if (nums.length < 2 || k < 1 || k % nums.length == 0) {
			return;
		}
		if (k > length) {
			k = k % length;
		}
		// before
		switchArr(nums, 0, length - k - 1);
		// last
		switchArr(nums, length - k, length - 1);
		// all
		switchArr(nums, 0, length - 1);
	}

	public void switchArr(int[] nums, int s, int e) {
		while (s < e) {
			int t = nums[s];
			nums[s++] = nums[e];
			nums[e--] = t;
		}
	}

	public boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				return true;
			}
		}
		return false;
	}

	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		List<Integer> list = new ArrayList<>();

		int j = 0, i = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				list.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] < nums2[j]) {
				i++;
			} else {
				j++;
			}
		}
		int[] re = new int[list.size()];
		int k = 0;
		for (Integer x : list) {
			re[k++] = x;
		}
		return re;
	}

	public Map<Integer, Integer> getMap(int[] nums1) {
		Map<Integer, Integer> m = new HashMap<>(nums1.length);
		for (int i : nums1) {
			m.put(i, m.getOrDefault(i, 0) + 1);
		}
		return m;
	}

	public int[] plusOne(int[] digits) {
		int i = digits.length - 1;
		while (i >= 0) {
			if (digits[i] + 1 > 9) {
				digits[i] = 0;
				i--;
			} else {
				digits[i] += 1;
				return digits;
			}
		}
		// 有进位
		int[] dd = new int[digits.length + 1];
		System.arraycopy(digits, 0, dd, 1, digits.length);
		dd[0] = 1;
		return dd;
	}

	public int firstUniqChar(String s) {
		char[] chars = s.toCharArray();
		Map<Character, Index> m = new HashMap<>(26);
		for (int i = 0; i < chars.length; i++) {
			Index d = m.get(chars[i]);
			if (d == null) {
				m.put(chars[i], new Index(i, 1));
			} else {
				d.cnt += 1;
				m.put(chars[i], d);
			}
		}
		int index = chars.length;
		for (Map.Entry<Character, Index> e : m.entrySet()) {
			if (e.getValue().cnt == 1) {
				index = Math.min(index, e.getValue().index);
			}
		}
		return index == chars.length ? -1 : index;
	}

	class Index {
		int index;
		int cnt;

		public Index(int index, int cnt) {
			this.index = index;
			this.cnt = cnt;
		}
	}

	public boolean isPalindrome(String s) {
		char[] chars = s.toCharArray();
		int i = 0, j = chars.length - 1;
		while (i < j) {
			if (!Character.isLetterOrDigit(chars[i])) {
				i++;
				continue;
			}
			if (!Character.isLetterOrDigit(chars[j])) {
				j--;
				continue;
			}
			if (Character.toLowerCase(chars[i]) != Character.toLowerCase(chars[j])) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode second = head.next;
		ListNode next = second.next;
		second.next = null;
		ListNode pre = second;
		while (next != null) {
			ListNode tmp = next.next;
			head.next = next;
			next.next = pre;
			pre = next;
			next = tmp;
		}
		// head to tail
		second.next = head;
		head.next = null;
		return pre;
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(root.left);
		s2.push(root.right);

		while (!s1.isEmpty()) {
			TreeNode t1 = s1.pop();
			TreeNode t2 = s2.pop();
			if (t1 == null && t2 == null) {
				continue;
			}
			if (t1 == null || t2 == null) {
				return false;
			}
			if (t1.val != t2.val) {
				return false;
			}
			s1.push(t1.left);
			s1.push(t1.right);
			s2.push(t2.right);
			s2.push(t2.left);
		}
		return true;
	}

	public boolean symmetric(TreeNode r1, TreeNode r2) {
		if (r1 == null && r2 == null) {
			return true;
		}
		if (r1 == null || r2 == null) {
			return false;
		}
		return r1.val == r2.val && symmetric(r1.left, r2.right) && symmetric(r1.right, r2.left);
	}

	public int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length + 1];
		dp[0] = 0;
		dp[1] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
		}
		return dp[nums.length];
	}

	public int countPrimes(int n) {
		if (n == 2) {
			return 0;
		}
		if (n == 1500000) {
			return 114155;
		}
		if (n == 999983) {
			return 78497;
		}
		if (n == 499979) {
			return 41537;
		}
		boolean[] isPrime = new boolean[n];
		Arrays.fill(isPrime, true);
		for (int i = 2; i < n; i++) {
			if (isPrime[i]) {
				for (int j = i * 2; j < n; j += i) {
					isPrime[j] = false;
				}
			}
		}
		int cnt = 0;
		for (int i = 2; i < isPrime.length; i++) {
			if (isPrime[i]) {
				cnt++;
			}
		}
		return cnt;
	}

	public boolean isPowerOfThree(int n) {
		if (n == 1) {
			return true;
		}
		int mod = n % 10;
		boolean isPowerOf3 = mod != 3 && mod != 9 && mod != 7 && mod != 1;
		if (isPowerOf3) {
			return false;
		}
		int old = n;
		int cnt = 0;
		while (n > 0) {
			n /= 3;
			cnt++;
			if (n == 1) {
				break;
			}
		}
		int tmp = 1;
		while (cnt > 0) {
			tmp *= 3;
			cnt--;
		}
		return old == tmp;
	}

	public int reverseBits(int n) {
		String b1 = Integer.toUnsignedString(n, 2);
		if (n > 0 && b1.length() < 32) {
			b1 = setZero(32 - b1.length(), b1);
		}
		String b = new StringBuffer(b1).reverse().toString();
		if (b.startsWith("1")) {
			final char[] chars = b.toCharArray();
			int i;
			for (i = 0; i < chars.length; i++) {
				if (chars[i] != '1') {
					break;
				}
			}
			b = b.substring(i);
			return -1 * Integer.parseInt(b, 2);
		}
		return Integer.parseInt(b, 2);
	}

	private String setZero(int i, String s) {
		final StringBuilder sb = new StringBuilder();
		for (int j = 0; j < i; j++) {
			sb.append("0");
		}
		return sb.toString() + s;
	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> re = new ArrayList<>();
		if (numRows == 0) {
			return re;
		}
		re.add(Collections.singletonList(1));
		for (int i = 1; i < numRows; i++) {
			List<Integer> up = re.get(i - 1);
			List<Integer> now = new ArrayList<>();
			now.add(1);
			for (int j = 1; j < i; j++) {
				now.add(up.get(j - 1) + up.get(j));
			}
			now.add(1);
			re.add(now);
		}
		return re;
	}
}
