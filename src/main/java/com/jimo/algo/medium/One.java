package com.jimo.algo.medium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author jimo
 * @date 19-2-22 下午10:11
 */
public class One {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream(new File("file.in")));
		int N = sc.nextInt();
		int Q = sc.nextInt();
		int[] e = new int[N];
		for (int i = 0; i < N; i++) {
			e[i] = sc.nextInt();
		}
		Path[] paths = new Path[N - 1];
		for (int i = 0; i < N - 1; i++) {
			paths[i] = new Path(sc.nextInt(), sc.nextInt());
		}
		Desc[] descs = new Desc[Q];
		for (int i = 0; i < Q; i++) {
			descs[i] = new Desc(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}

		One one = new One();
		List<Integer> re = one.solution(e, descs, paths);
		System.out.println(Arrays.toString(re.toArray()));
	}

	public List<Integer> solution(int[] e, Desc[] desc, Path[] paths) {
		List<Integer> re = new ArrayList<>();
		for (Desc d : desc) {
			if (d.flag == 1) {
				// change();
				e[d.i - 1] = d.j;
			} else if (d.flag == 2) {
				// cal
				re.add(getValue(e, paths, d.i, d.j, 0));
			}
		}
		return re;
	}

	private int getValue(int[] e, Path[] paths, int from, int to, int v) {
		if (from == to) {
			return v ^ e[to - 1];
		}
		for (Path p : paths) {
			if (p.i == from) {
				int re = getValue(e, paths, p.j, to, v ^ e[from - 1]);
				if (re != -1) {
					return re;
				}
			}
		}
		return -1;
	}


	static class Path {
		int i;
		int j;

		Path(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static class Desc {
		int flag;
		int i;
		int j;

		Desc(int flag, int i, int j) {
			this.flag = flag;
			this.i = i;
			this.j = j;
		}
	}
}
