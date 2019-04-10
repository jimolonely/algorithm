package com.jimo.algo.low;

import java.util.*;

/**
 * @author jimo
 * @date 19-4-7 上午10:17
 */
public class Solution4 {
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

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        for (Node child : root.children) {
            max = Math.max(max, maxDepth(child));
        }
        return 1 + max;
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int tiltLeft = findTilt(root.left);
        int tiltRight = findTilt(root.right);
        int leftSum = sumTree(root.left);
        int rightSum = sumTree(root.right);
        return tiltLeft + tiltRight + Math.abs(leftSum - rightSum);
    }

    private int sumTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sumLeft = sumTree(root.left);
        int sumRight = sumTree(root.right);
        return sumLeft + sumRight + root.val;
    }

    public int findTilt2(TreeNode root) {
        int[] sum = new int[1];
        postOrderSum(root, sum);
        return sum[0];
    }

    private int postOrderSum(TreeNode root, int[] sum) {
        if (root == null) {
            return 0;
        }
        int leftSum = postOrderSum(root.left, sum);
        int rightSum = postOrderSum(root.right, sum);
        sum[0] += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return nums;
        }
        int rn = nums.length;
        int cn = nums[0].length;
        int n = rn * cn;
        if (n != r * c) {
            return nums;
        }
        int[][] re = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int row = (i * c + j) / cn;
                int col = (i * c + j) % cn;
                re[i][j] = nums[row][col];
            }
        }
        return re;
    }

    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int candy : candies) {
            set.add(candy);
        }
        int half = candies.length / 2;
        return set.size() > half ? half : set.size();
    }

    public List<Integer> preorder(Node root) {
        List<Integer> re = new ArrayList<>();
        doPreOrder(root, re);
        return re;
    }

    private void doPreOrder(Node root, List<Integer> re) {
        if (root != null) {
            re.add(root.val);
            for (Node child : root.children) {
                doPreOrder(child, re);
            }
        }
    }

    public List<Integer> preorder2(Node root) {
        List<Integer> re = new ArrayList<>();
        if (root == null) {
            return re;
        }
        LinkedList<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node n = q.poll();
            re.add(n.val);
            q.addAll(0, n.children);
        }
        return re;
    }

    public List<Integer> postorder(Node root) {
        List<Integer> re = new ArrayList<>();
        if (root == null) {
            return re;
        }
        Stack<Node> s = new Stack<>();
        Stack<Integer> sl = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            Node n = s.pop();
            for (Node child : n.children) {
                s.push(child);
            }
            sl.push(n.val);
        }
        while (!sl.isEmpty()) {
            re.add(sl.pop());
        }
        return re;
    }

    public int maxCount(int m, int n, int[][] ops) {
        int r = m, c = n;
        for (int[] op : ops) {
            int a = op[0];
            int b = op[1];
            r = Math.min(r, a);
            c = Math.min(c, b);
        }
        return r * c;
    }
}
