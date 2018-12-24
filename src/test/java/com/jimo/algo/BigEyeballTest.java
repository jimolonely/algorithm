package com.jimo.algo;

import com.jimo.algo.week1.BigEyeball;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BigEyeballTest {

	private BigEyeball b;

	@Before
	public void setUp() {
		b = new BigEyeball();
	}

	@Test
	public void foundEqual() {
		boolean b1 = this.b.foundEqual(6, new int[]{1, 2, 3});
		assertTrue(b1);

		boolean b2 = this.b.foundEqual(9, new int[]{6, 2, 3, 4, 5, 1});
		assertTrue(b2);

		boolean b3 = this.b.foundEqual(7, new int[]{3, 2, 1});
		assertFalse(b3);
	}

	@Test
	public void getMax1() {
		int m1 = b.getMax1(new int[]{1, 4, 3, 2, 5});
		assertEquals(5, m1);

		int m2 = b.getMax1(new int[]{1, 4, 3, 5, 5});
		assertEquals(5, m2);

		int m3 = b.getMax1(new int[]{3, 3, 3, 3, 3});
		assertEquals(3, m3);
	}

	@Test
	public void getMax2() {
		int m1 = b.getMax2(new int[]{1, 4, 3, 2, 5});
		assertEquals(7, m1);

		int m2 = b.getMax2(new int[]{1, 4, 3});
		assertEquals(4, m2);

		int m3 = b.getMax2(new int[]{3, 3, 3, 3, 3});
		assertEquals(6, m3);
	}
}
