package com.jimo.algo.low;

import java.math.BigInteger;
import java.util.*;

/**
 * @author jimo
 * @date 19-3-16 下午8:45
 */
public class Solution2 {

    public boolean isPalindrome(int x) {
        String s = x + "";
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            while (left <= right && nums[left] != val) {
                left++;
            }
            while (left <= right && nums[right] == val) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
                left++;
                right--;
            }
        }
        return right + 1;
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int lengthOfLastWord(String s) {
        String s1 = s.trim();
        int cnt = 0;
        for (int i = s1.length() - 1; i >= 0; i--) {
            if (s1.charAt(i) == ' ') {
                break;
            }
            cnt++;
        }
        return cnt;
    }

    public String addBinary(String a, String b) {
        BigInteger ai = new BigInteger(a, 2);
        BigInteger bi = new BigInteger(b, 2);
        return ai.add(bi).toString(2);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> re = new ArrayList<>();
        re.add(1);
        if (rowIndex == 0) {
            return re;
        }
        int len = rowIndex + 1;
        long x = 1;
        for (int i = 1; i < len; i++) {
            x = x * (len - i) / i;
            re.add((int) x);
        }
        return re;
    }

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) (n % 26 + 'A'));
            n = n / 26;
        }
        return sb.reverse().toString();
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }

    public int reverseBits(int n) {
        // return Integer.reverse(n);
        int i = 0;
        int re = 0;
        while (i < 32) {
            re += ((1 & (n >> i)) << (31 - i));
            i++;
        }
        return re;
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode pre = dump, cur = dump.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dump.next;
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>(s.length() / 2);
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            int len = i + k > nums.length - 1 ? nums.length - 1 : i + k;
            for (int j = i + 1; j <= len; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (nums == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    class MyStack {

        private Queue<Integer> q;
        private int size;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            size = 0;
            q = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            q.offer(x);
            for (int i = 0; i < size; i++) {
                q.offer(q.poll());
            }
            size++;
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            size--;
            return q.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return q.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return size == 0;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    class MyQueue {

        private Stack<Integer> s;
        private Stack<Integer> h;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            s = new Stack<>();
            h = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            while (!s.isEmpty()) {
                h.push(s.pop());
            }
            s.push(x);
            while (!h.isEmpty()) {
                s.push(h.pop());
            }
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            return s.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return s.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return s.isEmpty();
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || q == null || p == null) {
            return null;
        }
        if (root.val > Math.max(p.val, q.val)) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < Math.max(p.val, q.val)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    List<String> re = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return re;
        }
        searchPath(root, "");
        return re;
    }

    private void searchPath(TreeNode root, String s) {
        if (root.left == null && root.right == null) {
            re.add(s + root.val);
            return;
        }
        if (root.left != null) {
            searchPath(root.left, s + root.val + "->");
        }
        if (root.right != null) {
            searchPath(root.right, s + root.val + "->");
        }
    }

    public int addDigits2(int num) {
        while (num > 9) {
            int sum = 0;
            int n = num;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            num = sum;
        }
        return num;
    }

    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        if (num % 9 == 0) {
            return 9;
        }
        return num % 9;
    }

    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        while (num > 2) {
            if (num % 5 == 0) {
                num /= 5;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 2 == 0) {
                num /= 2;
            } else {
                return false;
            }
        }
        return num == 1;
    }

    public boolean canWinNim(int n) {
        return canWinNim(n, 0);
    }

    public boolean canWinNim(int n, int deep) {
        if (n > 3) {
            boolean ok3 = canWinNim(n - 3, deep + 1);
            boolean ok2 = canWinNim(n - 2, deep + 1);
            boolean ok1 = canWinNim(n - 1, deep + 1);
            return ok3 || ok2 || ok1;
        } else {
            return deep % 2 == 0;
        }
    }

    public boolean wordPattern(String pattern, String str) {
        String[] sa = str.split(" ");
        if (pattern.length() != sa.length) {
            return false;
        }
        String[] pa = pattern.split("");
        Map<String, String> map = new HashMap<>(pattern.length());
        Map<String, String> map2 = new HashMap<>(pattern.length());
        for (int i = 0; i < pa.length; i++) {
            if (notEqual(pa[i], sa[i], map)) {
                return false;
            }
            if (notEqual(sa[i], pa[i], map2)) {
                return false;
            }
        }
        return true;
    }

    private boolean notEqual(String p, String s, Map<String, String> map) {
        if (map.containsKey(p)) {
            return !map.get(p).equals(s);
        } else {
            map.put(p, s);
        }
        return false;
    }

    class NumArray {

        private int[] sum;

        public NumArray(int[] nums) {
            if (nums.length == 0) {
                return;
            }
            sum = new int[nums.length + 1];
            sum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            if (i == 0) {
                return sum[j];
            } else {
                return sum[j] - sum[i - 1];
            }
        }
    }

    public boolean isPowerOfFour(int num) {
        if (num <= 0 || (num & (num - 1)) != 0) {
            return false;
        }
        return (num & 0x55555555) != 0;
    }

    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        Set<Character> vowel = new HashSet<>(
                Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'O', 'U', 'I'));
        int left = 0, right = chars.length - 1;
        while (left < right) {
            while (left < right && !vowel.contains(chars[left])) {
                left++;
            }
            while (left < right && !vowel.contains(chars[right])) {
                right--;
            }
            if (left < right) {
                char t = chars[left];
                chars[left] = chars[right];
                chars[right] = t;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}
