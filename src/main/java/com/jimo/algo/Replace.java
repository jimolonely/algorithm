package com.jimo.algo;

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
		return str.replaceAll("\\$\\{starReportDate}", "2019-01-07")
				.replaceAll("\\$\\{endReportDate}", "2019-01-07")
				.replaceAll("\\$\\{cloudUuid}", "86595a76-567b-4521-ab88-715c11f6738e")
				.replaceAll("\\$\\{cluster}", "default_cluster")
				.replaceAll("\\$\\{zq}", "day")
				.replaceAll("&gt;", ">")
				.replaceAll("&lt;", "<");
	}

	public static void main(String[] args) throws IOException {
		System.out.println(new Replace().replace("/home/jack/workspace/Git/algorithm/src/main/resources/sql.txt"));
	}
}
