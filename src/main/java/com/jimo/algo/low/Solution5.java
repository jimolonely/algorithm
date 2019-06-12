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

    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            // xy
            int xz = 0, yz = 0, xy = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    xy++;
                }
                xz = Math.max(grid[i][j], xz);
                yz = Math.max(grid[j][i], yz);
            }
            sum += xz + yz + xy;
        }
        return sum;
    }

    public String[] uncommonFromSentences1(String A, String B) {
        String[] s1 = A.split(" ");
        String[] s2 = B.split(" ");
        Set<String> re = new HashSet<>();
        Set<String> set = new HashSet<>();

        for (String s : s1) {
            if (set.contains(s)) {
                re.remove(s);
            } else {
                re.add(s);
            }
            set.add(s);
        }
        HashSet<String> sa = new HashSet<>(set);
        set.clear();
        for (String s : s2) {
            if (set.contains(s)) {
                re.remove(s);
            } else {
                if (sa.contains(s)) {
                    re.remove(s);
                } else {
                    re.add(s);
                }
            }
            set.add(s);
        }
        return re.toArray(new String[0]);
    }

    public String[] uncommonFromSentences(String A, String B) {
        String s = A + " " + B;
        String[] a = s.split(" ");
        Set<String> set = new HashSet<>();
        Set<String> re = new HashSet<>();
        for (String s1 : a) {
            if (set.contains(s1)) {
                re.remove(s1);
            } else {
                re.add(s1);
            }
            set.add(s1);
        }
        return re.toArray(new String[0]);
    }

    public int[] fairCandySwap(int[] A, int[] B) {
        int sa = 0, sb = 0;
        for (int a : A) {
            sa += a;
        }
        for (int b : B) {
            sb += b;
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0, j = 0;
        // sa+y-x=sb+x-y
        // diff = x - y = (sa - sb)/2
        int diff = (sa - sb) / 2;
        while (i < A.length && j < B.length) {
            if (A[i] - B[j] == diff) {
                return new int[]{A[i], B[j]};
            } else if (A[i] - B[j] < diff) {
                i++;
            } else {
                j++;
            }
        }
        return new int[]{0, 0};
    }

    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String s : A) {
            int[] cnt = new int[52];
            for (int i = 0; i < s.length(); i++) {
                cnt[s.charAt(i) - 'a' + 26 * (i % 2)]++;
            }
            set.add(Arrays.toString(cnt));
        }
        return set.size();
    }

    public boolean isMonotonic(int[] A) {
        if (A.length < 3) {
            return true;
        }
        boolean asc = false, desc = false;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] < A[i]) {
                asc = true;
            } else if (A[i - 1] > A[i]) {
                desc = true;
            }
        }
        return !(asc && desc);
    }

    private TreeNode head;

    public TreeNode increasingBST(TreeNode root) {
        head = new TreeNode(0);
        TreeNode dumy = head;
        rebuild(root);
        return dumy.right;
    }

    private void rebuild(TreeNode root) {
        if (root == null) {
            return;
        }
        rebuild(root.left);
        head.right = new TreeNode(root.val);
        head = head.right;
        rebuild(root.right);
    }

    public int[] sortArrayByParity(int[] A) {
        int left = 0, right = A.length - 1;
        while (left < right) {
            if (A[left] % 2 == 1 && A[right] % 2 == 0) {
                int t = A[left];
                A[left] = A[right];
                A[right] = t;
            } else if (A[left] % 2 == 0) {
                left++;
            } else if (A[right] % 2 == 1) {
                right--;
            }
        }
        return A;
    }

    public int smallestRangeI(int[] A, int K) {
        int max = 0, min = Integer.MAX_VALUE;
        for (int i : A) {
            max = Math.max(i, max);
            min = Math.min(i, min);
        }
        return Math.max(0, max - min - 2 * K);
    }

    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (!Character.isLetter(chars[left])) {
                left++;
                continue;
            }
            if (!Character.isLetter(chars[right])) {
                right--;
                continue;
            }
            char t = chars[left];
            chars[left] = chars[right];
            chars[right] = t;
            left++;
            right--;
        }
        return new String(chars);
    }

    public int[] sortArrayByParityII(int[] A) {
        // 奇偶指针
        int i = 0, j = 1;
        while (i < A.length) {
            if (A[i] % 2 == 0) {
                i += 2;
            } else {
                while (j < A.length && A[j] % 2 == 1) {
                    j += 2;
                }
                if (j < A.length) {
                    int t = A[i];
                    A[i] = A[j];
                    A[j] = t;
                }
            }
        }
        return A;
    }

    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) {
            return false;
        }
        char[] names = name.toCharArray();
        char[] typeds = typed.toCharArray();

        int i = 0, j = 0, cntName = 0, cntTyped = 0;
        while (i < names.length && j < typeds.length) {
            int cnt = 1;
            while (i + 1 < names.length && names[i] == names[i + 1]) {
                i++;
                cnt++;
            }
            int cnt2 = 1;
            while (j + 1 < typeds.length && typeds[j] == typeds[j + 1]) {
                j++;
                cnt2++;
            }
            if (names[i] != typeds[j] || cnt > cnt2) {
                return false;
            }
            i++;
            j++;
        }
        return i == names.length && j == typeds.length;
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] a = email.split("@");
            int i = a[0].indexOf('+');
            String left;
            if (i > -1) {
                left = a[0].substring(0, i).replaceAll("\\.", "");
            } else {
                left = a[0].replaceAll("\\.", "");
            }
            set.add(left + "@" + a[1]);
        }
        return set.size();
    }
}
