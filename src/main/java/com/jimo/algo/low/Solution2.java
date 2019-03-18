package com.jimo.algo.low;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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

    public List<Integer> getRow(int rowIndex) {
        List<Integer> re = new ArrayList<>();
        re.add(1);
        if (rowIndex == 0) {
            return re;
        }
        int len = rowIndex + 1;
        long x = 1;
        for (int i = 1; i < len; i++) {
            x = x * (len - i) / i;
            re.add((int) x);
        }
        return re;
    }

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) (n % 26 + 'A'));
            n = n / 26;
        }
        return sb.reverse().toString();
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }

    public int reverseBits(int n) {
        // return Integer.reverse(n);
        int i = 0;
        int re = 0;
        while (i < 32) {
            re += ((1 & (n >> i)) << (31 - i));
            i++;
        }
        return re;
    }
}
