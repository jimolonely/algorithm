package com.jimo.algo;


import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author jimo
 * @date 18-12-21 上午10:03
 */
public class Replace {

	public String replace(String path) throws IOException {
		String str = new String(Files.readAllBytes(Paths.get(path)));
		return str.replaceAll("\\$\\{starReportDate}", "2019-01-21")
				.replaceAll("\\$\\{endReportDate}", "2019-01-21")
				.replaceAll("\\$\\{cloudUuid}", "24a31fbd-b2bd-4f2a-9b5c-9624e376ded1")
				.replaceAll("\\$\\{cluster}", "RegionFCsan")
				.replaceAll("\\$\\{zq}", "day")
				.replaceAll("&gt;", ">")
				.replaceAll("&lt;", "<");
	}

	public String replaceIadTag(String path) throws IOException {
		String str = new String(Files.readAllBytes(Paths.get(path)));
		return str.replaceAll("\\$\\{starReportDate}", "2019-01-21")
				.replaceAll("\\$\\{endReportDate}", "2019-01-27")
				.replaceAll("\\$\\{iadTag}", "Hadoop")
				.replaceAll("\\$\\{zq}", "day")
				.replaceAll("&gt;", ">")
				.replaceAll("&lt;", "<");
	}

	public static void main(String[] args) throws IOException {
		System.out.println(new Replace().replace("/home/jack/workspace/Git/algorithm/src/main/resources/sql.txt"));
	}

	@Test
	public void iadTag() throws IOException {
		System.out.println(new Replace().replaceIadTag("/home/jack/workspace/Git/algorithm/src/main/resources/sql.txt"));
	}

	@Test
	public void jsonReplace() throws IOException {
		String path = "/home/jack/workspace/Git/algorithm/src/main/resources/json.txt";
		String str = new String(Files.readAllBytes(Paths.get(path)));
		System.out.println(str.replaceAll("\\\\n\" \\+", "")
				.replaceAll("\"", "").replaceAll("\\\\", "\""));
	}
}
