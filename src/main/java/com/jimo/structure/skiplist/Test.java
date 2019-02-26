package com.jimo.structure.skiplist;

/**
 * @author jimo
 * @date 19-2-26 下午4:48
 */
public class Test {

	public static void main(String[] args) {
		SkipList<String> skipList = new SkipList<>();
		skipList.put(2, "like");
		skipList.put(1, "I");
		skipList.put(3, "Jimo");
		skipList.put(5, "much");
		skipList.put(4, "very");
		skipList.put(8, "I");
		skipList.put(6, ",");
		skipList.put(9, "do");
		skipList.put(7, "yes");
		skipList.put(6, "!");
		System.out.println(skipList);
		System.out.println(skipList.size());
		skipList.printByLevel();
	}
}
