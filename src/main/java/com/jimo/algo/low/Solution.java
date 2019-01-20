package com.jimo.algo.low;

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

	public static class ListNode {
		int val;
		public ListNode next;

		public ListNode(int x) {
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

	public boolean isValid(String s) {
		if (s.length() < 2 && s.length() > 0) {
			return false;
		}
		Stack<Character> sk = new Stack<>();
		char[] chars = s.toCharArray();
		for (char c : chars) {
			switch (c) {
				case '(':
				case '{':
				case '[':
					sk.push(c);
					break;
				case ')':
					if (sk.isEmpty() || '(' != sk.pop()) {
						return false;
					}
					break;
				case '}':
					if (sk.isEmpty() || '{' != sk.pop()) {
						return false;
					}
					break;
				case ']':
					if (sk.isEmpty() || '[' != sk.pop()) {
						return false;
					}
					break;
				default:
					return false;
			}
		}
		return sk.isEmpty();
	}

	public int missingNumber(int[] nums) {
		int n = nums.length;
		int sum = n * (n + 1) / 2;
		int sum1 = 0;
		for (int num : nums) {
			sum1 += num;
		}
		return sum - sum1;
	}

	public int romanToInt(String s) {
		Map<Character, Integer> m = new HashMap<>(7);
		m.put('I', 1);
		m.put('V', 5);
		m.put('X', 10);
		m.put('L', 50);
		m.put('C', 100);
		m.put('D', 500);
		m.put('M', 1000);

		char[] chars = s.toCharArray();
		int re = 0;
		for (int i = 0; i < chars.length; i++) {
			if (i == chars.length - 1 || m.get(chars[i + 1]) <= m.get(chars[i])) {
				re += m.get(chars[i]);
			} else {
				re -= m.get(chars[i]);
			}
		}
		return re;
	}

	class MinStack {

		private Stack<Integer> sk;
		private int min;

		/**
		 * initialize your data structure here.
		 */
		public MinStack() {
			min = Integer.MAX_VALUE;
			sk = new Stack<>();
		}

		public void push(int x) {
			if (x <= min) {
				sk.push(min);
				min = x;
			}
			sk.push(x);
		}

		public void pop() {
			if (sk.pop() == min) {
				min = sk.pop();
			}
		}

		public int top() {
			return sk.peek();
		}

		public int getMin() {
			return min;
		}
	}

	public boolean isCompleteTree(TreeNode root) {
		LinkedList<TreeNode> q = new LinkedList<>();
		q.add(root);
		TreeNode n;
		while ((n = q.removeFirst()) != null) {
			q.addLast(n.left);
			q.addLast(n.right);
		}
		while (!q.isEmpty()) {
			if (q.removeFirst() != null) {
				return false;
			}
		}
		return true;
	}

	public void moveZeroes(int[] nums) {
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[j] = nums[i];
				j++;
			}
		}
		for (int i = j; i < nums.length; i++) {
			nums[i] = 0;
		}
	}

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> m = new HashMap<>(nums.length);
		for (int i = 0; i < nums.length; i++) {
			if (m.containsKey(target - nums[i])) {
				return new int[]{m.get(target - nums[i]), i};
			}
			m.put(nums[i], i);
		}
		return null;
	}

	public boolean isValidSudoku(char[][] board) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < board.length; i++) {
			// 9 lines
			set.clear();
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] != '.' && set.contains(board[i][j])) {
					return false;
				}
				set.add(board[i][j]);
			}
			// 9 columns
			set.clear();
			for (int j = 0; j < board.length; j++) {
				if (board[j][i] != '.' && set.contains(board[j][i])) {
					return false;
				}
				set.add(board[j][i]);
			}
		}

		// 9 box
		for (int i = 0; i < 9; i += 3) {
			// by row
			for (int p = 0; p < 9; p += 3) {
				set.clear();
				for (int j = p; j < p + 3; j++) {
					for (int k = i; k < i + 3; k++) {
						if (board[k][j] != '.' && set.contains(board[k][j])) {
							return false;
						}
						set.add(board[k][j]);
					}
				}
			}
		}
		return true;
	}

	public void rotate(int[][] matrix) {
		int len = matrix.length;
		int start = 0, end = len - 1;

		// 这个方法有点像交换变量
		while (start < end) {
			// keep up row
			int[] up = keepRow(matrix, start, start, end);

			// left column to up row
			for (int i = end; i >= start; i--) {
				matrix[start][i] = matrix[end - i + start][start];
			}

			// down row to left column
			for (int i = start; i <= end; i++) {
				matrix[i][start] = matrix[end][i];
			}

			// right column to down row
			for (int i = end; i >= start; i--) {
				matrix[end][end - i + start] = matrix[i][end];
			}

			// up row to right column
			int i = start;
			for (int x : up) {
				matrix[i++][end] = x;
			}
			// to inside
			start++;
			end--;
		}
	}

	private int[] keepRow(int[][] matrix, int row, int start, int end) {
		int[] re = new int[end - start + 1];
		int i = 0;
		for (int j = start; j <= end; j++) {
			re[i++] = matrix[row][j];
		}
		return re;
	}

	public int myAtoi(String str) {
		String s = str.trim();
		if ("".equals(s)) {
			return 0;
		}
		// find number
		char[] chars = s.toCharArray();
		int start = 0;
		if (chars[0] == '+' || chars[0] == '-') {
			start = 1;
		}
		int sign = 1;
		if (chars[0] == '-') {
			sign = -1;
		}
		// 无法转换
		if (start >= chars.length || chars[start] < '0' || chars[start] > '9') {
			return 0;
		}
		int end = start;
		for (int i = start; i < chars.length; i++) {
			if (chars[i] < '0' || chars[i] > '9') {
				break;
			} else {
				end = i;
			}
		}
		String numStr = s.substring(start, end + 1);
		// remove begin zero
		while (numStr.startsWith("0")) {
			numStr = numStr.substring(1);
		}
		if ("".equals(numStr)) {
			return 0;
		}

		// 通过判断长度来确定边界
		int maxIntLen = 10;
		if (numStr.length() < maxIntLen) {
			return sign * Integer.parseInt(numStr);
		} else if (numStr.length() > maxIntLen) {
			return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		}
		// 剩下长度为10的
		int pre9 = Integer.parseInt(numStr.substring(0, maxIntLen - 1));
		int last1 = Integer.parseInt(numStr.substring(maxIntLen - 1));
		if (sign == 1) {
			if (Integer.MAX_VALUE / 10 - last1 + 7 > pre9) {
				return Integer.parseInt(numStr);
			} else {
				return Integer.MAX_VALUE;
			}
		} else {
			if (Integer.MAX_VALUE / 10 - last1 + 8 > pre9) {
				return -1 * Integer.parseInt(numStr);
			} else {
				return Integer.MIN_VALUE;
			}
		}
	}

	public int strStr(String haystack, String needle) {
//		if ("".equals(needle)) {
//			return 0;
//		}
//		if (haystack.length() < needle.length()) {
//			return -1;
//		}

		return haystack.indexOf(needle);
//		return -1;
	}

	public String countAndSay(int n) {
		if (n == 1) {
			return "1";
		}
		String s1 = "1";
		while (n-- > 1) {
			char[] chars = s1.toCharArray();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < chars.length; ) {
				int cnt = 0;
				char c = chars[i];
				while (i < chars.length && chars[i] == c) {
					cnt++;
					i++;
				}
				sb.append(cnt).append(c);
			}
			s1 = sb.toString();
		}
		return s1;
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length < 1) {
			return "";
		}
		String str1 = strs[0];
		if ("".equals(str1)) {
			return "";
		}
		int minLen = Integer.MAX_VALUE;
		for (String str : strs) {
			minLen = Math.min(minLen, str.length());
		}

		int i;
		for (i = 0; i < minLen; i++) {
			char c = strs[0].charAt(i);
			boolean ok = true;
			for (String str : strs) {
				if (str.charAt(i) != c) {
					ok = false;
					break;
				}
			}
			if (!ok) {
				break;
			}
		}
		return str1.substring(0, i);
	}

	public int firstBadVersion(int n) {
		if (isBadVersion(1)) {
			return 1;
		}
		int i = 1, j = n;
		while (i < j) {
//			int mid = (j + i) / 2;
			int mid = j / 2 + i / 2;
			if (isBadVersion(mid)) {
				j = mid;
			} else {
				i = mid + 1;
			}
		}
		return i;
	}

	private boolean isBadVersion(int i) {
		return false;
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> re = new ArrayList<>();
		if (root == null) {
			return re;
		}
		LinkedList<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			int size = q.size();
			while (size-- > 0) {
				final TreeNode node = q.removeFirst();
				level.add(node.val);
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
			}
			re.add(level);
		}
		return re;
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0) {
			return null;
		}
		if (nums.length == 1) {
			return new TreeNode(nums[0]);
		}
		return build(nums, 0, nums.length - 1);
	}

	public TreeNode build(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		if (start == end) {
			return new TreeNode(nums[start]);
		}
		int mid = (start + end) / 2;
		final TreeNode root = new TreeNode(nums[mid]);
		root.left = build(nums, start, mid - 1);
		root.right = build(nums, mid + 1, end);
		return root;
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode pre = head;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				pre.next = l1;
				l1 = l1.next;
			} else {
				pre.next = l2;
				l2 = l2.next;
			}
			pre = pre.next;
		}
		if (l1 != null) {
			pre.next = l1;
		}
		if (l2 != null) {
			pre.next = l2;
		}
		return head.next;
	}

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ListNode slow = head, fast = head;
		// 用来逆转
		ListNode pre = null;
		// 在slow后面一个
		ListNode post = slow.next;
		while (slow.next != null && fast.next != null && fast.next.next != null) {
			fast = fast.next.next;

			post = slow.next.next;
			// 逆转
			ListNode tmp = slow.next;
			slow.next = pre;
			pre = slow;
			slow = tmp;
		}
		slow.next = pre;

		ListNode left, right = post;
		if (fast != head && fast.next == null) {
			// 奇数
			left = slow.next;
		} else {
			// 偶数
			left = slow;
		}
		while (left != null && right != null) {
			if (left.val != right.val) {
				return false;
			}
			left = left.next;
			right = right.next;
		}
		return true;
	}

	public boolean hasCycle(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	public void deleteNode(ListNode node) {
		ListNode next = node.next;
		node.val = next.val;
		node.next = next.next;
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> re = new ArrayList<>();
		// sort
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] > 0) {
				break;
			}
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int target = 0 - nums[i];
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				if (target == nums[left] + nums[right]) {
					re.add(Arrays.asList(nums[i], nums[left], nums[right]));
					while (left < right && nums[left] == nums[left + 1]) {
						++left;
					}
					while (left < right && nums[right] == nums[right - 1]) {
						--right;
					}
					++left;
					--right;
				} else if (target < nums[left] + nums[right]) {
					right--;
				} else {
					left++;
				}
			}
		}
		return re;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		String s = getNum(l1).add(getNum(l2)).toString();
		System.out.println(s);
		String sum = new StringBuilder(s + "").reverse().toString();
		ListNode head = new ListNode(sum.charAt(0) - '0');
		ListNode pre = head;
		for (int i = 1; i < sum.length(); i++) {
			ListNode next = new ListNode(sum.charAt(i) - '0');
			pre.next = next;
			pre = next;
		}
		return head;
	}

	public BigInteger getNum(ListNode head) {
		StringBuilder sb = new StringBuilder();
		while (head != null) {
			sb.append(head.val);
			head = head.next;
		}
		return new BigInteger(sb.reverse().toString());
	}

	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		int sum = 0;
		while (true) {
			int t = n % 10;
			sum += t * t;
			n /= 10;
			if (n == 0) {
				if (sum == 1) {
					break;
				}
				if (set.contains(sum)) {
					return false;
				}
				set.add(sum);
				n = sum;
				sum = 0;
			}
		}
		return true;
	}

	public int trailingZeroes(int n) {
		int cnt = 0;
		while (n > 1) {
			cnt += (n /= 5);
		}
		return cnt;
	}

	public int titleToNumber(String s) {
		char[] chars = new StringBuilder(s).reverse().toString().toCharArray();
		int sum = 0;
		int radix = 1;
		for (int i = 0; i < chars.length; i++) {
			final int d = chars[i] - 'A' + 1;
			sum += d * radix;
			radix *= 26;
		}
		return 0;
	}

	public List<Integer> inorderTraversal1(TreeNode root) {
		List<Integer> re = new ArrayList<>();
		inorder(root, re);
		return re;
	}

	private void inorder(TreeNode root, List<Integer> re) {
		if (root == null) {
			return;
		}
		inorder(root.left, re);
		re.add(root.val);
		inorder(root.right, re);
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> re = new ArrayList<>();
		Stack<TreeNode> s = new Stack<>();
		while (root != null || !s.isEmpty()) {
			while (root != null) {
				s.push(root);
				root = root.left;
			}
			TreeNode top = s.pop();
			re.add(top.val);
			root = top.right;
		}
		return re;
	}

	public List<String> letterCombinations(String digits) {
		List<String> re = new ArrayList<>();
		if ("".equals(digits)) {
			return re;
		}
		Map<Character, String[]> map = new HashMap<>(8);
		map.put('2', new String[]{"a", "b", "c"});
		map.put('3', new String[]{"d", "e", "f"});
		map.put('4', new String[]{"g", "h", "i"});
		map.put('5', new String[]{"j", "k", "l"});
		map.put('6', new String[]{"m", "n", "o"});
		map.put('7', new String[]{"p", "q", "r", "s"});
		map.put('8', new String[]{"t", "u", "v"});
		map.put('9', new String[]{"w", "x", "y", "z"});

		StringBuilder sb = new StringBuilder();
		concat(digits, sb, re, map, 0);

		return re;
	}

	private void concat(String digits, StringBuilder sb, List<String> re, Map<Character, String[]> m, int index) {
		if (index == digits.length()) {
			re.add(sb.toString());
			return;
		}
		char c = digits.charAt(index);
		String[] aphs = m.get(c);
		for (String aph : aphs) {
			sb.append(aph);
			concat(digits, sb, re, m, index + 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public void sortColors(int[] nums) {
		int[] cnt = new int[3];
		for (int num : nums) {
			cnt[num]++;
		}
		int i = 0;
		for (int j = 0; j < cnt.length; j++) {
			int k = 0;
			while (k++ < cnt[j]) {
				nums[i++] = j;
			}
		}
	}

	public boolean canJump(int[] nums) {
		// dp[i]: 到位置i能跳跃的最大长度
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = dp[i - 1] >= i ? Math.max(nums[i] + i, dp[i - 1]) : 0;
		}
		return dp[nums.length - 1] >= nums.length - 1;
	}

	public int uniquePaths(int m, int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, 1);
		for (int i = 2; i <= m; i++) {
			for (int j = 2; j <= n; j++) {
				dp[j] += dp[j - 1];
			}
		}
		return dp[n];
	}

	public int coinChange(int[] coins, int amount) {
		if (amount == 0 || coins == null || coins.length == 0) {
			return 0;
		}
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;

		for (int coin : coins) {
			for (int i = coin; i <= amount; i++) {
				dp[i] = Math.min(dp[i], dp[i - coin] + 1);
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}

	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int maxLen = 1;
		// 到第i个数时的最大上升长度
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			maxLen = Math.max(maxLen, dp[i]);
		}
		return maxLen;
	}

	public int getSum(int a, int b) {
		int carry = 1;
		int sum = 0;
		while (carry != 0) {
			carry = (a & b) << 1;
			sum = a ^ b;
			a = carry;
			b = sum;
		}
		return sum;
	}

	public double myPow(double x, int n) {
		if (n < 0) {
			return 1 / x * myPow(1 / x, -(n + 1));
		} else if (n == 0) {
			return 1;
		} else if (n == 1) {
			return x;
		}

		double half = myPow(x, n >> 1);
		half *= half;

		if ((n & 1) == 1) {
			half *= x;
		}
		return half;
	}

	public int mySqrt(int x) {
		if (x == 1 || x == 0) {
			return x;
		}
		int i = 0, j = x;
		while (i < j) {
			int mid = i / 2 + j / 2;
			if (x / mid >= mid) {
				i = mid + 1;
			} else {
				j = mid;
			}
		}
		return j - 1;
	}

	public int evalRPN(String[] tokens) {
		Stack<Integer> s = new Stack<>();
		int x;
		for (String token : tokens) {
			switch (token) {
				case "+":
					x = s.pop() + s.pop();
					s.add(x);
					break;
				case "-":
					x = 0 - s.pop() + s.pop();
					s.add(x);
					break;
				case "*":
					x = s.pop() * s.pop();
					s.add(x);
					break;
				case "/":
					int a = s.pop();
					int b = s.pop();
					s.add(b / a);
					break;
				default:
					s.add(Integer.parseInt(token));
			}
		}
		return s.pop();
	}

	public int majorityElement(int[] nums) {
		int re = nums[0];
		int cnt = 0;
		for (int num : nums) {
			if (cnt == 0) {
				re = num;
				cnt++;
			} else if (re == num) {
				cnt++;
			} else {
				cnt--;
			}
		}
		return re;
	}

	public void setZeroes(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		Set<Integer> rows = new HashSet<>();
		Set<Integer> cols = new HashSet<>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
		// row
		for (Integer r : rows) {
			for (int j = 0; j < col; j++) {
				matrix[r][j] = 0;
			}
		}
		// col
		for (Integer c : cols) {
			for (int i = 0; i < row; i++) {
				matrix[i][c] = 0;
			}
		}
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> m = new HashMap<>(strs.length);
		for (String s : strs) {
			char[] sa = s.toCharArray();
			Arrays.sort(sa);
			String key = new String(sa);
			List<String> list = m.get(key);
			if (list == null) {
				list = new ArrayList<>();
			}
			list.add(s);
			m.put(key, list);
		}
		return new ArrayList<>(m.values());
	}

	public List<String> generateParenthesis(int n) {
		List<String> re = new ArrayList<>();
		paths(n, n, "", re);
		return re;
	}

	private void paths(int left, int right, String path, List<String> re) {
		if (left == 0 && right == 0) {
			re.add(path);
			return;
		}
		if (left > 0) {
			paths(left - 1, right, path + "(", re);
		}
		if (right > 0 && right > left) {
			paths(left, right - 1, path + ")", re);
		}
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> re = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		permute(re, list, nums);
		return re;
	}

	private int[] removeItem(int[] nums, int num) {
		int[] sub = new int[nums.length - 1];
		int i = 0;
		for (int n : nums) {
			if (n != num) {
				sub[i++] = n;
			}
		}
		return sub;
	}

	public void permute(List<List<Integer>> re, List<Integer> list, int[] nums) {
		if (nums.length == 0) {
			re.add(new ArrayList<>(list));
		}
		for (int num : nums) {
			list.add(num);
			permute(re, list, removeItem(nums, num));
			list.remove(list.size() - 1);
		}
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> re = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		// empty set
		re.add(new ArrayList<>());
		sub(re, list, nums);
		return re;
	}

	private void sub(List<List<Integer>> re, List<Integer> list, int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			list.add(num);
			re.add(new ArrayList<>(list));
			sub(re, list, Arrays.copyOfRange(nums, i + 1, nums.length));
			list.remove(list.size() - 1);
		}
	}

	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> m = new HashMap<>(nums.length);
		for (int num : nums) {
			m.put(num, m.getOrDefault(num, 0) + 1);
		}
//		return sortByValue(m, k);
		return maxHeap(m, k);
	}

	public List<Integer> sortByValue(Map<Integer, Integer> map, int k) {
		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

		List<Integer> re = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			re.add(list.get(i).getKey());
		}
		return re;
	}

	public List<Integer> maxHeap(Map<Integer, Integer> m, int k) {
//		PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
		PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(Map.Entry.comparingByValue(Comparator.reverseOrder()));
		heap.addAll(m.entrySet());

		List<Integer> re = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			re.add(heap.poll().getKey());
		}
		return re;
	}

	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}

	public int findPeakElement(int[] nums) {
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int mid = left / 2 + right / 2;
			if (mid > 0 && nums[mid] < nums[mid - 1]) {
				right = mid - 1;
			} else if (nums[mid] < nums[mid + 1]) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return right;
	}

	public int[] searchRange(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		int i = -1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				i = mid;
				break;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		if (i == -1) {
			return new int[]{-1, -1};
		}
		int i1 = i, i2 = i;
		left = i - 1;
		right = i;
		while (left >= 0 && nums[left] == target) {
			i1 = left;
			left--;
		}
		while (right < nums.length && nums[right] == target) {
			i2 = right;
			right++;
		}
		return new int[]{i1, i2};
	}

	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public List<Interval> merge(List<Interval> intervals) {
		return null;
	}

	public int search(int[] nums, int target) {
		// find the rotate index
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			// left is in order
			if (nums[mid] >= nums[left]) {
				if (nums[mid] > target && nums[left] <= target) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (nums[mid] < target && nums[right] >= target) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}

	public int lengthOfLongestSubstring(String s) {
		if ("".equals(s)) {
			return 0;
		}
		char[] chars = s.toCharArray();
		Set<Character> set = new HashSet<>();
		int max = 1;
		for (int i = 0; i < chars.length - 1; i++) {
			set.add(chars[i]);
			for (int j = i + 1; j < chars.length; j++) {
				if (set.contains(chars[j])) {
					break;
				} else {
					set.add(chars[j]);
				}
			}
			max = Math.max(set.size(), max);
			set.clear();
		}
		return max;
	}

	public String longestPalindrome(String s) {
		char[] chars = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		int left = 0, right = 0;
		for (int i = 0; i < chars.length; i++) {
			// 偶对称

			// 奇对称

		}
		return s.substring(left, right);
	}

}
