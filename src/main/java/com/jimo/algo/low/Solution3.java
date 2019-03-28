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
}
