package com.jimo.algo.low;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
}
