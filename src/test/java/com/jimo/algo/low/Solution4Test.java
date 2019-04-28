package com.jimo.algo.low;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Solution4Test {

    @Test
    public void testCap() {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 641L;

        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(h == (e + f));
        System.out.println(h.equals(e + f));
        System.out.println(g.equals(a + b));
    }

    @Test
    public void compareStr() {
        String[] s = {"a", "ab", "c", "123"};
        Arrays.sort(s);
        for (String s1 : s) {
            System.out.println(s1);
        }
    }
}