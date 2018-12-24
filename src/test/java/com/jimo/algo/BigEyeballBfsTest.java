package com.jimo.algo;

import com.jimo.algo.week1.BigEyeballBfs;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BigEyeballBfsTest {

	private BigEyeballBfs b = new BigEyeballBfs();

	private Map<int[], Integer> data;

	@Before
	public void setUp() {
		data = new HashMap<>(10);
//		data.put(new int[]{1, 2}, 0);
		data.put(new int[]{1, 2, 3, 6}, 6);
//		data.put(new int[]{1, 2, 3, 4, 5, 6}, 10);
//		data.put(new int[]{190, 20, 110, 130, 30, 170, 20, 70,}, 370);
//		data.put(new int[]{120, 140, 180, 150, 160, 160, 60, 90, 30, 170,}, 630);
//		data.put(new int[]{20, 150, 80, 70, 10, 180, 180, 190, 130, 60, 90, 170,}, 660);
//		data.put(new int[]{120, 170, 130, 180, 10, 50, 90, 170, 20, 70, 70, 90, 150, 20,}, 670);
//		data.put(new int[]{180, 100, 100, 150, 50, 140, 140, 120, 70, 60, 40, 60, 60, 30, 130, 170,}, 800);
//		data.put(new int[]{140, 30, 160, 20, 60, 40, 120, 150, 190, 90, 20, 90, 120, 150, 100, 30, 140, 40,}, 830);
//		data.put(new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 50, 50, 50, 150, 150, 150, 100, 100, 100, 123}, 1023);
		data.put(new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608,
				16777216, 33554432, 67108864, 134217728, 268435456, 536870912,}, 0);
	}

	@Test
	public void bigEyeball() {
		for (Map.Entry<int[], Integer> in : data.entrySet()) {
//			assertEquals((int) in.getValue(), b.bigEyeball(in.getKey()));
			System.out.println(b.bigEyeball(in.getKey()));
		}
	}

	@Test
	public void bigEyeBallHalf() {
		for (Map.Entry<int[], Integer> in : data.entrySet()) {
//			assertEquals((int) in.getValue(), b.bigEyeBallHalf(in.getKey()));
			System.out.println(b.bigEyeBallHalf(in.getKey()));
		}
	}
}
