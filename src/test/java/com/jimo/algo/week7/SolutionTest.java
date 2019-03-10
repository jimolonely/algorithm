package com.jimo.algo.week7;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution s = new Solution();

    @Test
    public void largestSumAfterKNegations() {
        assertEquals(5, s.largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
        assertEquals(6, s.largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3));
        assertEquals(13, s.largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
        assertEquals(26, s.largestSumAfterKNegations(new int[]{4, -5, 4, -5, 9, 4, 5}, 1));
        assertEquals(13, s.largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
    }

    @Test
    public void clumsy() {
//        assertEquals(7, s.clumsy(4));
        assertEquals(12, s.clumsy(10));
    }
}