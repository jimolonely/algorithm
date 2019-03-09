package com.jimo.algo.medium;

import java.awt.Point;
import java.util.*;

/**
 * @author jimo
 * @date 19-2-15 上午8:46
 */
public class Solution {

    public int brokenCalc(int X, int Y) {
        int cnt = 0;
        while (Y > X) {
            if (Y % 2 == 0) {
                Y /= 2;
            } else {
                Y++;
            }
            cnt++;
        }
        return cnt + X - Y;
    }

    public double minAreaFreeRect(int[][] points) {
        double minArea = Double.MAX_VALUE;

        Point[] p = new Point[points.length];
        Set<Point> set = new HashSet<>();
        for (int i = 0; i < points.length; i++) {
            p[i] = new Point(points[i][0], points[i][1]);
            set.add(p[i]);
        }

        for (int i = 0; i < points.length; i++) {
            Point p1 = p[i];
            for (int j = 0; j < points.length; j++) {
                if (j == i) {
                    continue;
                }
                Point p2 = p[j];
                for (int k = j + 1; k < points.length; k++) {
                    if (k == i) {
                        continue;
                    }
                    Point p3 = p[k];
                    Point p4 = new Point(p2.x + p3.x - p1.x, p2.y + p3.y - p1.y);
                    if (set.contains(p4)) {
                        int dot = (p2.x - p1.x) * (p3.x - p1.x) + (p2.y - p1.y) * (p3.y - p1.y);
                        if (dot == 0) {
                            double area = p1.distance(p2) * p2.distance(p4);
                            minArea = Math.min(minArea, area);
                        }
                    }
                }
            }
        }
        return minArea < Double.MAX_VALUE ? minArea : 0;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int len = lists.length;
        while (len > 1) {
            int m = (len + 1) / 2;
            for (int i = 0; i < len / 2; i++) {
                lists[i] = mergeTwoList(lists[i], lists[i + m]);
            }
            len = m;
        }
        return lists[0];
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode headBefore = new ListNode(-1);
        ListNode cur = headBefore;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return headBefore.next;
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> re = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            // handle one line
            int lineLen = 0;
            int strLen = 0;
            List<String> line = new ArrayList<>();
            while (i < words.length) {
                if (lineLen == 0) {
                    lineLen += words[i].length();
                    // ensure at least one space between two words
                } else if (lineLen + 1 + words[i].length() <= maxWidth) {
                    lineLen += words[i].length() + 1;
                } else {
                    break;
                }
                line.add(words[i]);
                strLen += words[i].length();
                i++;
            }
            // to this line, append space from left to right

            // the last line
            int j = 0;
            int restLen = maxWidth - strLen;
            if (i == words.length) {
                restLen -= line.size() - 1;
                while (restLen-- > 0) {
                    line.set(line.size() - 1, line.get(line.size() - 1) + " ");
                }
                re.add(String.join(" ", line));
            } else {
                while (restLen > 0) {
                    if (j != line.size() - 1 || line.size() == 1) {
                        line.set(j, line.get(j) + " ");
                        restLen--;
                    }
                    j = (j + 1) % line.size();
                }
                re.add(String.join("", line));
            }
            // the last word need to handle alone if it's last line or only one word
//			if (i == words.length || line.size() == 1) {
//				StringBuilder sb = new StringBuilder();
//
//				line.set(line.size()-1,line.get(line.size()-1)+);
//			}

        }
        return re;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> re = new ArrayList<>();

        if (root == null) {
            return re;
        }

        TreeNode pre = null;
        TreeNode cur;
        Stack<TreeNode> s = new Stack<>();

        s.push(root);

        while (!s.isEmpty()) {
            cur = s.peek();

            boolean canAccess = (cur.left == null && cur.right == null)
                    || (pre != null && (pre == cur.left || pre == cur.right));
            if (canAccess) {
                re.add(cur.val);
                pre = s.pop();
            } else {
                if (cur.right != null) {
                    s.push(cur.right);
                }
                if (cur.left != null) {
                    s.push(cur.left);
                }
            }
        }
        return re;
    }

    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {

            if (root == null) {
                return "";
            }
            List<String> re = new ArrayList<>();

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            re.add("" + root.val);

            while (!q.isEmpty()) {
                TreeNode t = q.poll();
                if (t.left == null) {
                    re.add("null");
                } else {
                    re.add("" + t.left.val);
                    q.offer(t.left);
                }
                if (t.right == null) {
                    re.add("null");
                } else {
                    re.add("" + t.right.val);
                    q.offer(t.right);
                }
            }
            return String.join(",", re);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if ("".equals(data)) {
                return null;
            }
            String[] vals = data.split(",");

            int i = 0;
            Queue<TreeNode> q = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(vals[i]));
            q.offer(root);

            while (!q.isEmpty() /*&& i < vals.length - 1*/) {
                TreeNode t = q.poll();
                if ("null".equals(vals[++i])) {
                    t.left = null;
                } else {
                    TreeNode left = new TreeNode(Integer.parseInt(vals[i]));
                    t.left = left;
                    q.offer(left);
                }
                if ("null".equals(vals[++i])) {
                    t.right = null;
                } else {
                    TreeNode right = new TreeNode(Integer.parseInt(vals[i]));
                    t.right = right;
                    q.offer(right);
                }
            }
            return root;
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        Map<Integer, int[]> candidate = new LinkedHashMap<>();
        int[] bx = new int[buildings.length * 2];
        for (int i = 0; i < buildings.length; i++) {
            bx[i * 2] = buildings[i][0];
            bx[i * 2 + 1] = buildings[i][1];
        }
        Arrays.sort(bx);

        for (int i = 0; i < bx.length; i++) {
            int x = bx[i];
            int maxHeight = -1;
            for (int j = i / 2; j >= 0; j--) {
                int[] b2 = buildings[j];
                // b的x轴在b2范围内
                if (b2[0] <= x && b2[1] >= x && b2[2] > maxHeight) {
                    maxHeight = b2[2];
                    if (candidate.containsKey(maxHeight)) {
                        int[] old = candidate.get(maxHeight);
                        if (old[0] > b2[0]) {
                            candidate.put(maxHeight, new int[]{b2[0], maxHeight});
                        }
                    } else {
                        candidate.put(maxHeight, new int[]{b2[0], maxHeight});
                    }
                }
            }
        }
        return new ArrayList<>(candidate.values());
    }

    public boolean judgePoint24(int[] nums) {
        List<Double> a = new ArrayList<>();
        for (int num : nums) {
            a.add((double) num);
        }
        return solve(a);
    }

    private boolean solve(List<Double> nums) {
        if (nums.size() == 0) {
            return false;
        }
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) < 1e-6;
        }
        // A(4,2) * 4 * A(3,2) * 4 * 4 = 9216
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i == j) {
                    continue;
                }
                List<Double> nextNums = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) {
                        nextNums.add(nums.get(k));
                    }
                }
                // 4种运算
                for (int k = 0; k < 4; k++) {
                    // 因为加法和乘法没有顺序，不必重复计算
                    if (k < 2 && j > i) {
                        continue;
                    }
                    switch (k) {
                        case 0:
                            nextNums.add(nums.get(i) + nums.get(j));
                            break;
                        case 1:
                            nextNums.add(nums.get(i) * nums.get(j));
                            break;
                        case 2:
                            nextNums.add(nums.get(i) - nums.get(j));
                            break;
                        case 3:
                            if (nums.get(j) != 0) {
                                nextNums.add(nums.get(i) / nums.get(j));
                            } else {
                                continue;
                            }
                            break;
                        default:
                    }
                    if (solve(nextNums)) {
                        return true;
                    }
                    nextNums.remove(nextNums.size() - 1);
                }
            }
        }
        return false;
    }
}
