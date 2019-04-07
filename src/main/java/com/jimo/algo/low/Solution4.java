package com.jimo.algo.low;

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
}
