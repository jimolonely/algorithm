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

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>(Math.min(list1.length, list2.length));
        List<String> re = new ArrayList<>();
        if (list1.length > list2.length) {
            doFind(list2, list1, map, re);
        } else {
            doFind(list1, list2, map, re);
        }
        return re.toArray(new String[0]);
    }

    private void doFind(String[] list1, String[] list2, Map<String, Integer> map, List<String> re) {
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int sum = i + map.get(list2[i]);
                if (sum == min) {
                    re.add(list2[i]);
                } else if (sum < min) {
                    re.clear();
                    re.add(list2[i]);
                    min = sum;
                }
            }
        }
    }

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "()";
        }
        StringBuilder sb = new StringBuilder();
        preOrderT(t, sb);
        return sb.toString();
    }

    private void preOrderT(TreeNode t, StringBuilder sb) {
        sb.append(t.val);
        if (t.left != null || t.right != null) {

            sb.append("(");
            if (t.left != null) {
                preOrderT(t.left, sb);
            }
            sb.append(")");
            if (t.right != null) {
                sb.append("(");
                preOrderT(t.right, sb);
                sb.append(")");
            }
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        TreeNode t = new TreeNode((t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val));
        t.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        t.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return t;
    }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int a = nums[0] * nums[1] * nums[len - 1];
        int b = nums[len - 3] * nums[len - 2] * nums[len - 1];
        return Math.max(a, b);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> re = new ArrayList<>();
        if (root == null) {
            return re;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            double avg = 0d;
            for (int i = 0; i < size; i++) {
                TreeNode n = q.removeFirst();
                avg += n.val;
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
            }
            re.add(avg / size);
        }
        return re;
    }

    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double avg = sum / k;
        for (int i = 1; i <= nums.length - k; i++) {
            sum = sum - nums[i - 1] + nums[i + k - 1];
            avg = Math.max(avg, sum / k);
        }
        return avg;
    }

    public int[] findErrorNums(int[] nums) {
        int[] re = new int[2];
        int sum = 0;
        int[] bucket = new int[nums.length + 1];
        for (int num : nums) {
            if (bucket[num] == 0) {
                bucket[num] = 1;
            } else {
                re[0] = num;
            }
            sum += num;
        }
        int trueSum = (nums.length * (nums.length + 1)) / 2;
        re[1] = trueSum - sum + re[0];
        return re;
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int t = list.get(left) + list.get(right);
            if (t == k) {
                return true;
            } else if (t < k) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public boolean judgeCircle(String moves) {
        Map<Character, Integer> map = new HashMap<>(4);
        for (char c : moves.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map.getOrDefault('L', 0).equals(map.getOrDefault('R', 0))
                && map.getOrDefault('U', 0).equals(map.getOrDefault('D', 0));
    }

    public boolean judgeCircle2(String moves) {
        char[] chars = moves.toCharArray();
        int udCnt = 0;
        int lrCnt = 0;
        for (char c : chars) {
            switch (c) {
                case 'L':
                    lrCnt--;
                    break;
                case 'R':
                    lrCnt++;
                    break;
                case 'U':
                    udCnt--;
                    break;
                case 'D':
                    udCnt++;
                    break;
                default:
            }
        }
        return udCnt == 0 && lrCnt == 0;
    }

    public int[][] imageSmoother(int[][] M) {
        int row = M.length;
        int col = M[0].length;
        int[][] re = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int sum = 0;
                int cnt = 0;
                for (int k = Math.max(0, i - 1); k <= Math.min(i + 1, row - 1); k++) {
                    for (int p = Math.max(0, j - 1); p <= Math.min(j + 1, col - 1); p++) {
                        sum += M[k][p];
                        cnt++;
                    }
                }
                re[i][j] = sum / cnt;
            }
        }
        return re;
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    public int findSecondMinimumValue2(TreeNode root) {
        if (root.left == null) {
            return -1;
        }
        if (root.left.val == root.right.val) {
            int sl = findSecondMinimumValue2(root.left);
            int sr = findSecondMinimumValue2(root.right);
            if (root.val == root.left.val) {
                if (sr == -1 && sl == -1) {
                    return -1;
                } else if (sl == -1) {
                    return sr;
                } else {
                    return sl;
                }
            } else {
                return root.val;
            }
        } else if (root.left.val < root.right.val) {
            int sl = findSecondMinimumValue2(root.left);
            if (sl == -1) {
                return root.left.val;
            } else {
                return sl;
            }
        } else {
            int sr = findSecondMinimumValue2(root.right);
            if (sr == -1) {
                return root.right.val;
            } else {
                return sr;
            }
        }
    }

    public int findSecondMinimumValue(TreeNode root) {
        int re = traverse(root, root.val);
        return re == Integer.MAX_VALUE ? -1 : re;
    }

    private int traverse(TreeNode root, int val) {
        if (root != null) {
            if (root.val > val) {
                return root.val;
            }
            return Math.min(traverse(root.left, val), traverse(root.right, val));
        }
        return Integer.MAX_VALUE;
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int cnt = 1;
        int maxCnt = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                maxCnt = Math.max(cnt, maxCnt);
                cnt = 1;
            } else {
                cnt++;
            }
        }
        maxCnt = Math.max(cnt, maxCnt);
        return maxCnt;
    }

    public int calPoints(String[] ops) {
        Stack<Integer> s = new Stack<>();
        int score = 0;
        for (String op : ops) {
            switch (op) {
                case "+":
                    Integer a = s.pop();
                    int score1 = a + s.peek();
                    score += score1;
                    s.push(a);
                    s.push(score1);
                    break;
                case "D":
                    int stt = 2 * s.peek();
                    score += stt;
                    s.push(stt);
                    break;
                case "C":
                    score -= s.pop();
                    break;
                default:
                    int st = Integer.parseInt(op);
                    score += st;
                    s.push(st);
            }
        }
        return score;
    }

    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (chars[i] != chars[j]) {
                return isValidPalindrome(chars, i + 1, j) || isValidPalindrome(chars, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isValidPalindrome(char[] chars, int i, int j) {
        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        int sum = 0;
        for (Employee e : employees) {
            if (e.id == id) {
                sum += e.importance;
                for (Integer subId : e.subordinates) {
                    sum += getImportance(employees, subId);
                }
            }
        }
        return sum;
    }

    public boolean hasAlternatingBits(int n) {
        if (n == 0) {
            return true;
        }
        int sum = 1;
        int tmp = n;
        while (tmp != 0) {
            tmp >>>= 1;
            sum = (sum << 1) + 1;
        }
        sum >>>= 1;
        return (n ^ (n >>> 1)) == sum;
    }

    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int cnt = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            char c = chars[i];
            int cnt1 = 0, cnt0 = 0;
            for (int j = i; j < chars.length; j++) {
                if (c == chars[j]) {
                    cnt0++;
                } else {
                    break;
                }
            }
            for (int j = i + cnt0; j < chars.length; j++) {
                if (c != chars[j]) {
                    cnt1++;
                } else {
                    break;
                }
            }
            cnt += cnt0 == cnt1 ? 1 : 0;
        }
        return cnt;
    }

    public int countBinarySubstrings2(String s) {
        int pre = 0;
        int cur = 1;
        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                cur++;
            } else {
                res += Math.min(pre, cur);
                pre = cur;
                cur = 1;
            }
        }
        res += Math.min(pre, cur);
        return res;
    }
}
