package com.jimo.algo.low;

import java.math.BigInteger;

/**
 * @author jimo
 * @date 19-3-16 下午8:45
 */
public class Solution2 {

    public boolean isPalindrome(int x) {
        String s = x + "";
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            while (left <= right && nums[left] != val) {
                left++;
            }
            while (left <= right && nums[right] == val) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
                left++;
                right--;
            }
        }
        return right + 1;
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int lengthOfLastWord(String s) {
        String s1 = s.trim();
        int cnt = 0;
        for (int i = s1.length() - 1; i >= 0; i--) {
            if (s1.charAt(i) == ' ') {
                break;
            }
            cnt++;
        }
        return cnt;
    }

    public String addBinary(String a, String b) {
        BigInteger ai = new BigInteger(a, 2);
        BigInteger bi = new BigInteger(b, 2);
        return ai.add(bi).toString(2);
    }
}
