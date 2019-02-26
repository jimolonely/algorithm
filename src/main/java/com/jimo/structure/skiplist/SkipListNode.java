package com.jimo.structure.skiplist;

import java.util.Objects;

/**
 * @author jimo
 * @date 19-2-26 下午4:03
 */
public class SkipListNode<T> {

	public int key;
	public T value;
	public SkipListNode<T> up, down, left, right;

	public static final int HEAD_KEY = Integer.MIN_VALUE;
	public static final int TAIL_KEY = Integer.MAX_VALUE;

	public SkipListNode(int key, T value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SkipListNode<?> that = (SkipListNode<?>) o;
		return key == that.key &&
				Objects.equals(value, that.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(key, value);
	}

	@Override
	public String toString() {
		return "[" + key + "," + value + "]";
	}
}
