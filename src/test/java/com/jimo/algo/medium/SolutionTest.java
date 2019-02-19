package com.jimo.algo.medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

	@Test
	public void stringJoin() {
		List<String> strings = Arrays.asList("a ", "b ", " c  ");
		System.out.println(String.join("", strings)+"sdf");
	}
}