package com.jimo.structure.skiplist;

import java.util.Random;

import static com.jimo.structure.skiplist.SkipListNode.HEAD_KEY;
import static com.jimo.structure.skiplist.SkipListNode.TAIL_KEY;

/**
 * @author jimo
 * @date 19-2-26 下午4:07
 */
public class SkipList<T> {

	private SkipListNode<T> head, tail;
	private int nodes;
	private int level;
	private Random random;
	private static final double PROBABILITY = 0.5;

	public SkipList() {
		random = new Random();
		head = new SkipListNode<>(HEAD_KEY, null);
		tail = new SkipListNode<>(TAIL_KEY, null);
		linkHorizontal(head, tail);
		level = 0;
		nodes = 0;
	}

	public boolean isEmpty() {
		return nodes == 0;
	}

	public int size() {
		return nodes;
	}

	private SkipListNode<T> findNode(int key) {
		SkipListNode<T> p = this.head;
		while (true) {
			while (p.right.key != TAIL_KEY && p.right.key <= key) {
				p = p.right;
			}
			if (p.down != null) {
				p = p.down;
			} else {
				break;
			}
		}
		return p;
	}

	public SkipListNode<T> search(int key) {
		SkipListNode<T> p = findNode(key);
		if (p.key == key) {
			return p;
		}
		return null;
	}

	public void put(int k, T v) {
		SkipListNode<T> p = findNode(k);
		if (k == p.key) {
			p.value = v;
			return;
		}
		SkipListNode<T> newNode = new SkipListNode<>(k, v);
		linkToRight(p, newNode);
		int currentLevel = 0;
		// 抛硬币
		while (random.nextDouble() < PROBABILITY) {
			if (currentLevel >= level) {
				level++;
				SkipListNode<T> p1 = new SkipListNode<>(HEAD_KEY, null);
				SkipListNode<T> p2 = new SkipListNode<>(TAIL_KEY, null);
				linkHorizontal(p1, p2);
				linkVertical(p1, head);
				linkVertical(p2, tail);
				head = p1;
				tail = p2;
			}
			// p移到上一层
			while (p.up == null) {
				p = p.left;
			}
			p = p.up;

			SkipListNode<T> e = new SkipListNode<>(k, null);
			linkToRight(p, e);
			linkVertical(e, newNode);
			newNode = e;
			currentLevel++;
		}
		nodes++;
	}

	/**
	 * n2 插在 n1后面
	 * @author jimo
	 * @date 19-2-26 下午4:19
	 */
	private void linkToRight(SkipListNode<T> n1, SkipListNode<T> n2) {
		n2.left = n1;
		n2.right = n1.right;
		n1.right.left = n2;
		n1.right = n2;
	}

	private void linkHorizontal(SkipListNode<T> n1, SkipListNode<T> n2) {
		n1.right = n2;
		n2.left = n1;
	}

	private void linkVertical(SkipListNode<T> n1, SkipListNode<T> n2) {
		n1.down = n2;
		n2.up = n1;
	}


	public void printByLevel() {
		SkipListNode<T> p = this.head;
		while (p != null) {
			SkipListNode<T> tmp = p;
			StringBuilder sb = new StringBuilder();
			while (p != null) {
				sb.append(p).append(" ");
				p = p.right;
			}
			System.out.println(sb.toString());
			p = tmp.down;
		}
	}

	@Override
	public String toString() {
		if (isEmpty()) {
			return "empty";
		}
		StringBuilder sb = new StringBuilder();
		SkipListNode<T> p = this.head;
		while (p.down != null) {
			p = p.down;
		}
		while (p.left != null) {
			p = p.left;
		}
		if (p.right != null) {
			p = p.right;
		}
		while (p.right != null) {
			sb.append(p);
			sb.append("\n");
			p = p.right;
		}
		return sb.toString();
	}
}
