package com.jimo.algo;

import com.jimo.algo.week1.BigEyeballDp;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class BigEyeballDpTest {

	private BigEyeballDp b = new BigEyeballDp();
	private Map<int[], Integer> data;

	@Before
	public void setUp() {
		data = new HashMap<>(10);
//		data.put(new int[]{1, 2}, 0);
//		data.put(new int[]{1, 2, 3, 6}, 6);
//		data.put(new int[]{1, 2, 3, 4, 5, 6}, 10);
//		data.put(new int[]{190, 20, 110, 130, 30, 170, 20, 70,}, 370);
//		data.put(new int[]{120, 140, 180, 150, 160, 160, 60, 90, 30, 170,}, 630);
//		data.put(new int[]{20, 150, 80, 70, 10, 180, 180, 190, 130, 60, 90, 170,}, 660);
//		data.put(new int[]{120, 170, 130, 180, 10, 50, 90, 170, 20, 70, 70, 90, 150, 20,}, 670);
//		data.put(new int[]{180, 100, 100, 150, 50, 140, 140, 120, 70, 60, 40, 60, 60, 30, 130, 170,}, 800);
//		data.put(new int[]{140, 30, 160, 20, 60, 40, 120, 150, 190, 90, 20, 90, 120, 150, 100, 30, 140, 40,}, 830);
//		data.put(new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 50, 50, 50, 150, 150, 150, 100, 100, 100, 123}, 1023);
		data.put(new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576,}, 0);
		data.put(new int[]{225, 217, 762, 15, 573, 143, 250, 665, 776, 615, 224, 320, 583, 236, 696, 816, 575, 366, 529, 969, 25, 671, 980, 272, 96,}, 0);
		data.put(new int[]{403, 797, 734, 25, 993, 302, 573, 635, 341, 518, 491, 731, 207, 338, 885, 673, 529, 4, 336, 158, 17, 966, 471, 511, 491, 144, 803, 162, 222, 270,}, 0);
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
	public void bigEyeballDim1() {
		for (Map.Entry<int[], Integer> in : data.entrySet()) {
			assertEquals((int) in.getValue(), b.bigEyeballDim1(in.getKey()));
		}
	}

	@Test
	public void data() {
		Random r = new Random();
		int x = 8;
		for (int i = 3; i < 9; i++) {
			System.out.print("data.put(new int[]{");
			for (int j = 0; j < x; j++) {
				int v = r.nextInt(200);
				v = v - v % 10;
				while (v == 0) {
					v = r.nextInt(200);
					v = v - v % 10;
				}
				System.out.print(v + ",");
			}
			System.out.print("},0);");
			x += 2;
			System.out.println();
		}
	}

	@Test
	public void data2() {
		int x = 31;
		System.out.print("data.put(new int[]{");
		for (int j = 0; j < x; j++) {
			System.out.print((int) Math.pow(2, j) + ",");
		}
		System.out.print("},0);");
		System.out.println();
	}
}
