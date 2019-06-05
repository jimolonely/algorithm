package com.jimo.algo.low;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jimo
 * @date 19-5-15 上午8:02
 */
public class Solution5 {

    public String toGoatLatin(String S) {
        String[] s = S.split(" ");
        for (int i = 0; i < s.length; i++) {
            String fc = s[i].substring(0, 1);
        }
        return "";
    }


    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> re = new ArrayList<>();
        if (S.length() < 3) {
            return re;
        }
        char[] chars = S.toCharArray();
        int cnt = 1;
        int s = 0, i;
        char c = chars[0];
        for (i = 1; i < chars.length; i++) {
            if (chars[i] == c) {
                cnt++;
            } else {
                if (cnt >= 3) {
                    re.add(Arrays.asList(s, i - 1));
                }
                cnt = 1;
                s = i;
                c = chars[i];
            }
        }
        if (cnt >= 3) {
            re.add(Arrays.asList(s, i - 1));
        }
        return re;
    }

    public int[][] flipAndInvertImage(int[][] A) {
        int left = 0, right = 0;
        for (int[] row : A) {
            left = 0;
            right = row.length - 1;
            while (left <= right) {
                int t = row[left];
                row[left] = row[right] ^ 1;
                row[right] = t ^ 1;
                left++;
                right--;
            }
        }
        return A;
    }

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[len - 1], dp[len - 2]);
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        int left = 0, right = len - 1;
        char c = letters[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            if (letters[mid] > target) {
                c = letters[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return c;
    }

    public int dominantIndex(int[] nums) {
        int firstMax = 0, secondMax = 0, index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > firstMax) {
                secondMax = firstMax;
                firstMax = nums[i];
                index = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        return firstMax >= 2 * secondMax ? index : -1;
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        String[] sa = paragraph.split("([!?',;. ])");
        Map<String, Integer> m = new HashMap<>(sa.length / 2 > 0 ? sa.length / 2 : sa.length);
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        for (String s : sa) {
            s = s.toLowerCase();
            if (!"".equals(s) && !set.contains(s)) {
                m.put(s, m.getOrDefault(s, 0) + 1);
            }
        }
        int max = 0;
        String w = null;
        for (Map.Entry<String, Integer> e : m.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                w = e.getKey();
            }
        }
        return w;
    }

    public boolean backspaceCompare(String S, String T) {
        if (S.equals(T)) {
            return true;
        }
        Stack<Character> s = new Stack<>();
        Stack<Character> t = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '#') {
                if (!s.isEmpty()) {
                    s.pop();
                }
            } else {
                s.push(c);
            }
        }
        for (char c : T.toCharArray()) {
            if (c == '#') {
                if (!t.isEmpty()) {
                    t.pop();
                }
            } else {
                t.push(c);
            }
        }
        return s.equals(t);
    }

    public int[][] transpose(int[][] A) {
        int[][] re = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                re[j][i] = A[i][j];
            }
        }
        return re;
    }

    public int peakIndexInMountainArray(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int left = 0, right = A.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            } else if (A[mid] > A[mid + 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return 0;
    }

    public int binaryGap(int N) {
        int max = 0;
        int lastIndex = -1;
        for (int i = 0; i < 32; i++) {
            if (((N >> i) & 1) > 0) {
                if (lastIndex > -1) {
                    max = Math.max(max, i - lastIndex);
                }
                lastIndex = i;
            }
        }
        return max;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        inorder(root1, l1);
        inorder(root2, l2);

        if (l1.size() != l2.size()) {
            return false;
        }
        for (int i = 0; i < l1.size(); i++) {
            if (!l1.get(i).equals(l2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private void inorder(TreeNode root, List<Integer> l) {
        if (root == null) {
            return;
        }
        inorder(root.left, l);
        if (root.left == null && root.right == null) {
            l.add(root.val);
        }
        inorder(root.right, l);
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
