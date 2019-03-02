package com.jimo.algo.medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution s = new Solution();

    @Test
    public void stringJoin() {

        List<String> strings = Arrays.asList("a ", "b ", " c  ");
        System.out.println(String.join("", strings) + "sdf");
    }

    @Test
    public void codes() {
        Solution.Codec codec = new Solution.Codec();
        Solution.TreeNode deserialize = codec.deserialize("1,2,3,null,null,4,5,null,null,null,null");
        String serialize = codec.serialize(deserialize);
        assertEquals("1,2,3,null,null,4,5,null,null,null,null", serialize);
    }

    @Test
    public void skyLine() {
        int[][] b = new int[][]{
                {2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}
        };
        List<int[]> skyline = s.getSkyline(b);
        for (int[] x : skyline) {
            System.out.println("[" + x[0] + "," + x[1] + "]");
        }
    }
}