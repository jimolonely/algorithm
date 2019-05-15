package com.jimo.algo.low;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}
