package com.jimo.algo.low;

import java.util.*;

/**
 * @author jimo
 * @date 19-3-24 下午9:44
 */
public class Solution3 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> re = new ArrayList<>();
        if (root == null) {
            return re;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node n = q.poll();
                list.add(n.val);
                for (Node child : n.children) {
                    q.offer(child);
                }
            }
            re.add(list);
        }
        return re;
    }

    public int countSegments(String s) {
        if (s == null || "".equals(s.trim())) {
            return 0;
        }
        return s.trim().split(" +").length;
    }

    public int countSegments2(String s) {
        if (s == null || "".equals(s.trim())) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int cnt = 0;
        for (int i = 0; i < chars.length; ) {
            while (i < chars.length && chars[i] == ' ') {
                i++;
            }
            if (i == chars.length) {
                break;
            }
            cnt++;
            while (i < chars.length && chars[i] != ' ') {
                i++;
            }
        }
        return cnt;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSumSearch(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int pathSumSearch(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int cnt = 0;
        if (sum == root.val) {
            cnt++;
        }
        return cnt + pathSumSearch(root.left, sum - root.val)
                + pathSumSearch(root.right, sum - root.val);
    }

    public int numberOfBoomerangs(int[][] points) {
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        // 每个点为顶点时
        for (int i = 0; i < points.length; i++) {
            map.clear();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int dist = (int) (Math.pow(points[i][0] - points[j][0], 2)
                            + Math.pow(points[i][1] - points[j][1], 2));
                    map.put(dist, map.getOrDefault(dist, 0) + 1);
                }
            }
            for (Integer n : map.values()) {
                if (n >= 2) {
                    // 有序，排列问题，从n个里选2个点
                    cnt += n * (n - 1);
                }
            }
        }
        return cnt;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int num : nums) {
            nums[Math.abs(num) - 1] = -Math.abs(nums[Math.abs(num) - 1]);
        }
        List<Integer> re = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                re.add(i + 1);
            }
        }
        return re;
    }

    public int minMoves(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            if (min > num) {
                min = num;
            }
        }
        return sum - min * nums.length;
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cd = 0;
        int ck = 0;
        while (ck < s.length && cd < g.length) {
            if (g[cd] <= s[ck]) {
                cd++;
            }
            ck++;
        }
        return cd;
    }

    public boolean repeatedSubstringPattern(String s) {
        return (s + s).substring(1, s.length() * 2 - 1).contains(s);
    }

    public int islandPerimeter(int[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    cnt += 4;
                    // left
                    if (j > 0 && grid[i][j - 1] == 1) {
                        cnt -= 2;
                    }
                    // up
                    if (i > 0 && grid[i - 1][j] == 1) {
                        cnt -= 2;
                    }
                }
            }
        }
        return cnt;
    }

    public int findComplement(int num) {
        int bit = 31;
        // find fist bit equals 1
        while ((0x80000000 & num) == 0) {
            bit--;
            num <<= 1;
        }
        int sum = 0;
        while (bit >= 0) {
            int x = num & 0x80000000;
            if (x == 0) {
                sum += Math.pow(2, bit);
            }
            num <<= 1;
            bit--;
        }
        return sum;
    }

    public int findComplement2(int num) {
        int t = num;
        int c = 1;
        while (t > 0) {
            t >>= 1;
            c = (c << 1) + 1;
        }
        c >>= 1;
        return t ^ c;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cnt = 0;
        for (int num : nums) {
            if (num == 0) {
                cnt = 0;
            } else {
                cnt++;
            }
            if (cnt > max) {
                max = cnt;
            }
        }
        return max;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] re = new int[nums1.length];
        boolean find;
        Map<Integer, Integer> map = new HashMap<>(nums2.length);
        for (int k = 0; k < nums2.length; k++) {
            map.put(nums2[k], k);
        }
        for (int i = 0; i < nums1.length; i++) {
            find = false;
            for (int j = map.get(nums1[i]) + 1; j < nums2.length; j++) {
                if (nums1[i] < nums2[j]) {
                    find = true;
                    re[i] = nums2[j];
                    break;
                }
            }
            if (!find) {
                re[i] = -1;
            }
        }
        return re;
    }

    public String[] findWords(String[] words) {
        List<String> re = new ArrayList<>();
        Set<Character> one = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        Set<Character> two = new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        Set<Character> three = new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));
        for (String word : words) {
            boolean[] ok = new boolean[3];
            Arrays.fill(ok, true);
            char[] chars = word.toLowerCase().toCharArray();
            for (char c : chars) {
                if (!one.contains(c)) {
                    ok[0] = false;
                }
                if (!two.contains(c)) {
                    ok[1] = false;
                }
                if (!three.contains(c)) {
                    ok[2] = false;
                }
            }
            if (ok[0] || ok[1] || ok[2]) {
                re.add(word);
            }
        }
        return re.toArray(new String[0]);
    }

    int nowCnt = 0;
    int preCnt = 0;
    int maxCnt = 0;

    public int[] findMode(TreeNode root) {
        List<Integer> re = new ArrayList<>();
        inorder(root, re);
        return re.stream().mapToInt(x -> x).toArray();
    }

    private void inorder(TreeNode root, List<Integer> re) {
        if (root == null) {
            return;
        }
        inorder(root.left, re);
        nowCnt = preCnt == root.val ? nowCnt + 1 : 1;
        if (nowCnt > maxCnt) {
            re.clear();
            re.add(root.val);
            maxCnt = nowCnt;
        } else if (nowCnt == maxCnt) {
            re.add(root.val);
        }
        preCnt = root.val;
        inorder(root.right, re);
    }

    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        int tmp = Math.abs(num);
        while (tmp > 0) {
            int b = tmp % 7;
            sb.append(b);
            tmp /= 7;
        }
        if (num < 0) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }

    public String[] findRelativeRanks(int[] nums) {
        TreeSet<Integer> s = new TreeSet<>((o1, o2) -> o2 - o1);
        Map<Integer, Integer> map = new HashMap<>();
        int j = 0;
        for (int num : nums) {
            s.add(num);
            map.put(num, j++);
        }
        String[] re = new String[s.size()];
        int i = 0;
        for (Integer num : s) {
            if (i == 0) {
                re[map.get(num)] = "Gold Medal";
            } else if (i == 1) {
                re[map.get(num)] = "Silver Medal";
            } else if (i == 2) {
                re[map.get(num)] = "Bronze Medal";
            } else {
                re[map.get(num)] = (i + 1) + "";
            }
            i++;
        }
        return re;
    }

    public boolean checkPerfectNumber(int num) {
        int sum = 1;
        for (int i = 2; i < num / i; i++) {
            if (num % i == 0) {
                sum += i + num / i;
            }
        }
        return (sum != 1) && sum == num;
    }

    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        int a = 0, b = 1;
        for (int i = 2; i <= N; i++) {
            int fi = a + b;
            a = b;
            b = fi;
        }
        return b;
    }

    public boolean detectCapitalUse(String word) {
        return word.equals(word.toLowerCase())
                || word.equals(word.toUpperCase())
                || word.equals(word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase());
    }

    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : (Math.max(a.length(), b.length()));
    }

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        long maxL = getMaxOfLeft(root.left);
        long minR = getMinOfRight(root.right);
        long min = Math.min(root.val - maxL, minR - root.val);
        return (int) Math.min(min, Math.min(getMinimumDifference(root.left),
                getMinimumDifference(root.right)));
    }

    private long getMinOfRight(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        TreeNode t = root;
        while (t.left != null) {
            t = t.left;
        }
        return t.val;
    }

    private long getMaxOfLeft(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        TreeNode t = root;
        while (t.right != null) {
            t = t.right;
        }
        return t.val;
    }

    int preSum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        root.val += preSum;
        preSum = root.val;
        convertBST(root.left);
        return root;
    }

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (i = 0; i + k <= chars.length; i += k) {
            if (i / k % 2 == 0) {
                for (int j = i + k - 1; j >= i; j--) {
                    sb.append(chars[j]);
                }
            } else {
                for (int j = i; j < i + k; j++) {
                    sb.append(chars[j]);
                }
            }
        }
        if (i < chars.length) {
            if (i / k % 2 == 0) {
                for (int j = chars.length - 1; j >= i; j--) {
                    sb.append(chars[j]);
                }
            } else {
                for (int j = i; j < chars.length; j++) {
                    sb.append(chars[j]);
                }
            }
        }
        return sb.toString();
    }
}
