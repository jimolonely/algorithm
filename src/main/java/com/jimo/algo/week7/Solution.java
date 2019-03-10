package com.jimo.algo.week7;

import java.util.*;

/**
 * @author jimo
 * @date 19-3-10 上午10:33
 */
public class Solution {


    public int largestSumAfterKNegations(int[] A, int K) {
        int c1 = 0;
        int sum = 0;
        List<Integer> ac = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                ac.add(A[i]);
                A[i] = -A[i];
                c1++;
            }
            sum += A[i];
        }
        Arrays.sort(A);
        Collections.sort(ac);

        if (c1 >= K) {
            for (int i = ac.size() - 1; i >= K; i--) {
                int x = ac.get(i);
                sum += 2 * x;
            }
        } else {
            for (int i = 0; i < K - c1; i++) {
                A[0] = -A[0];
            }
            if (A[0] < 0) {
                sum += 2 * A[0];
            }
        }
        return sum;
    }

    public int clumsy(int N) {
        if (N < 4) {
            switch (N) {
                case 3:
                    return 6;
                case 2:
                    return 2;
                case 1:
                    return 1;
                default:
            }
        }
        int group = N / 4;
        int left = N % 4;
        int s = N;
        int re = 0;
        for (int i = 0; i < group; i++) {
            int t = s * (s - 1) / (s - 2);
            if (i == 0) {
                re = t;
            } else {
                re -= t;
            }
            re += s - 3;
            s -= 4;
        }
        switch (left) {
            case 3:
                re -= 6;
                break;
            case 2:
                re -= 2;
                break;
            case 1:
                re -= 1;
                break;
            default:
        }
        return re;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int start, int end) {
        if (start == end) {
            return new TreeNode(preorder[start]);
        }
        if (start > end) {
            return null;
        }
        int rootVal = preorder[start];
        TreeNode root = new TreeNode(rootVal);
        int leftIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (preorder[i] > rootVal) {
                break;
            }
            leftIndex = i;
        }
        root.left = build(preorder, start + 1, leftIndex);
        root.right = build(preorder, leftIndex + 1, end);
        return root;
    }
}
