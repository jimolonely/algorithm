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

    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>(nums.length > 16 ? nums.length / 4 : nums.length);
        int maxCnt = 1;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int[] record = map.get(nums[i]);
                record[0]++;
                record[2] = i;
                if (record[0] > maxCnt) {
                    maxCnt = record[0];
                }
            } else {
                // cnt:[0],startIndex:[1],endIndex:[2]
                map.put(nums[i], new int[]{1, i, i});
            }
        }
        int minLen = Integer.MAX_VALUE;
        for (int[] r : map.values()) {
            if (r[0] == maxCnt) {
                minLen = Math.min(minLen, r[2] - r[1] + 1);
            }
        }
        return minLen;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            return searchBST(root.right, val);
        }
        return searchBST(root.left, val);
    }

    class KthLargest {

        private int k;
        private PriorityQueue<Integer> q;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            q = new PriorityQueue<>(k);
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (q.size() < k) {
                q.offer(val);
            } else if (q.peek() < val) {
                q.poll();
                q.offer(val);
            }
            return q.peek();
        }
    }

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    class MyHashMap {
        int[] map = new int[1000000];

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            Arrays.fill(map, -1);
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            map[key] = value;
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            return map[key];
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            map[key] = -1;
        }
    }

    public String toLowerCase(String str) {
        return str.toLowerCase();
    }

    public boolean isOneBitCharacter(int[] bits) {
        int i = 0, step = 0;
        while (i < bits.length) {
            step = bits[i] == 1 ? 2 : 1;
            i += step;
        }
        return step == 1 && i == bits.length;
    }

    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String re = "";
        for (String word : words) {
            if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
                re = re.length() < word.length() ? word : re;
                set.add(word);
            }
        }
        return re;
    }

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((sum - nums[i]) % 2 != 0) {
                preSum += nums[i];
                continue;
            }
            if (preSum == (sum - nums[i]) / 2) {
                return i;
            }
            preSum += nums[i];
        }
        return -1;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> re = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (selfDivide(i)) {
                re.add(i);
            }
        }
        return re;
    }

    private boolean selfDivide(int n) {
        int tmp = n;
        while (n > 0) {
            int d = n % 10;
            if (d == 0 || tmp % d != 0) {
                return false;
            }
            n /= 10;
        }
        return true;
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int minLen = Integer.MAX_VALUE;
        String re = null;
        Map<Character, Integer> mL = new HashMap<>(7);
        Map<Character, Integer> mW = new HashMap<>(15);
        for (char c : licensePlate.toCharArray()) {
            char x;
            if (c >= 'A' && c <= 'Z') {
                x = (char) (c + 32);
            } else if (c >= 'a' && c <= 'z') {
                x = c;
            } else {
                continue;
            }
            mL.put(x, mL.getOrDefault(x, 0) + 1);
        }
        for (String word : words) {
            mW.clear();
            for (char c : word.toCharArray()) {
                mW.put(c, mW.getOrDefault(c, 0) + 1);
            }
            if (minLen > word.length()) {
                boolean ok = true;
                for (Map.Entry<Character, Integer> e : mL.entrySet()) {
                    final Integer cnt = mW.getOrDefault(e.getKey(), 0);
                    if (e.getValue() > cnt) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    re = word;
                    minLen = word.length();
                }
            }
        }
        return re;
    }

    public int countPrimeSetBits(int L, int R) {
        int[] prime = {0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0};
        int res = 0, bits, i, j;
        for (i = L; i <= R; ++i) {
            j = i;
            bits = 0;
            //统计有多少1最快的方法
            while (j != 0) {
                j = j & (j - 1);
                bits++;
            }
            //通过映射，直接判断是否素数
            res += prime[bits];
        }
        return res;
    }

    public int numJewelsInStones(String J, String S) {
        char[] chars = J.toCharArray();
        char[] c2 = S.toCharArray();
        Set<Character> s = new HashSet<>();
        for (char aChar : chars) {
            s.add(aChar);
        }
        int cnt = 0;
        for (char c : c2) {
            if (s.contains(c)) {
                cnt++;
            }
        }
        return cnt;
    }

    public List<String> letterCasePermutation(String S) {
        List<String> re = new ArrayList<>();
        char[] chars = S.toCharArray();
        getLetters(re, chars, 0, chars.length, "");
        return re;
    }

    private void getLetters(List<String> re, char[] chars, int start, int end, String s) {
        if (start == end) {
            re.add(s);
            return;
        }
        char c = chars[start];
        if (Character.isLetter(chars[start])) {
            getLetters(re, chars, start + 1, end, s + Character.toLowerCase(c));
            getLetters(re, chars, start + 1, end, s + Character.toUpperCase(c));
        } else {
            getLetters(re, chars, start + 1, end, s + c);
        }
    }

    public int rotatedDigits(int N) {
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            String s = String.valueOf(i);
            s = s.replaceAll("[0,1,8]", "");
            if (!"".equals(s)) {
                s = s.replaceAll("[2,5,6,9]", "");
                if ("".equals(s)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int leftMax = -101;
        TreeNode tmp = root.left;
        while (tmp != null) {
            leftMax = tmp.val;
            tmp = tmp.right;
        }
        int rightMax = Integer.MAX_VALUE;
        tmp = root.right;
        while (tmp != null) {
            rightMax = tmp.val;
            tmp = tmp.left;
        }
        int min = Math.min(root.val - leftMax, rightMax - root.val);
        return Math.min(min, Math.min(minDiffInBST(root.left), minDiffInBST(root.right)));
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        int col = matrix[0].length;
        int[] a = Arrays.copyOf(matrix[0], col);

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < col - 1; j++) {
                if (matrix[i][j + 1] != a[j]) {
                    return false;
                }
                a[j] = matrix[i][j];
            }
            a[col - 1] = matrix[i][col - 1];
        }
        return true;
    }

    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }

    public int uniqueMorseRepresentations(String[] words) {
        String[] map = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
                ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--",
                "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            char[] chars = word.toCharArray();
            sb.delete(0, sb.length());
            for (char c : chars) {
                sb.append(map[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
