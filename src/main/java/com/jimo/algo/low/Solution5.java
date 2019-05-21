package com.jimo.algo.low;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jimo
 * @date 19-5-15 上午8:02
 */
public class Solution5 {

    public String toGoatLatin(String S) {
        String[] s = S.split(" ");
        for (int i = 0; i < s.length; i++) {
            String fc = s[i].substring(0, 1);
        }
        return "";
    }


    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> re = new ArrayList<>();
        if (S.length() < 3) {
            return re;
        }
        char[] chars = S.toCharArray();
        int cnt = 1;
        int s = 0, i;
        char c = chars[0];
        for (i = 1; i < chars.length; i++) {
            if (chars[i] == c) {
                cnt++;
            } else {
                if (cnt >= 3) {
                    re.add(Arrays.asList(s, i - 1));
                }
                cnt = 1;
                s = i;
                c = chars[i];
            }
        }
        if (cnt >= 3) {
            re.add(Arrays.asList(s, i - 1));
        }
        return re;
    }

    public int[][] flipAndInvertImage(int[][] A) {
        int left = 0, right = 0;
        for (int[] row : A) {
            left = 0;
            right = row.length - 1;
            while (left <= right) {
                int t = row[left];
                row[left] = row[right] ^ 1;
                row[right] = t ^ 1;
                left++;
                right--;
            }
        }
        return A;
    }

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[len - 1], dp[len - 2]);
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        int left = 0, right = len - 1;
        char c = letters[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            if (letters[mid] > target) {
                c = letters[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return c;
    }

    public int dominantIndex(int[] nums) {
        int firstMax = 0, secondMax = 0, index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > firstMax) {
                secondMax = firstMax;
                firstMax = nums[i];
                index = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        return firstMax >= 2 * secondMax ? index : -1;
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        String[] sa = paragraph.split("([!?',;. ])");
        Map<String, Integer> m = new HashMap<>(sa.length / 2 > 0 ? sa.length / 2 : sa.length);
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        for (String s : sa) {
            s = s.toLowerCase();
            if (!"".equals(s) && !set.contains(s)) {
                m.put(s, m.getOrDefault(s, 0) + 1);
            }
        }
        int max = 0;
        String w = null;
        for (Map.Entry<String, Integer> e : m.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                w = e.getKey();
            }
        }
        return w;
    }
}
