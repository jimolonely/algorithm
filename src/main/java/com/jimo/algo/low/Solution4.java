package com.jimo.algo.low;

import java.util.Arrays;
import java.util.List;

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
}
