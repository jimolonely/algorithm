package com.jimo.algo.week6;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {


	@Test
	public void record() {
		Solution.Record record = new Solution.Record();
		record.val = 2;
		record.level = 1;
		Solution.Record r2 = new Solution.Record();
		r2.val = 1;
		r2.level = 1;

		assertEquals(record, r2);
		record.val = 1;
		assertNotEquals(record, r2);
	}
}