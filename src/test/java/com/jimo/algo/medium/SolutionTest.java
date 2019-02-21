package com.jimo.algo.medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

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
}