package com.jimo.algo.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用双向链表+HashMap实现LRU， get和put都是O(1)复杂度
 *
 * @author jimo
 * @date 19-5-30 下午8:20
 */
public class MyLru<K, V> {

    private int capacity;
    private Node head;
    private Node tail;
    private Map<K, Node> map;

    public MyLru(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(8);
    }

    public void put(K k, V v) {
        // 如果链表为空
        if (head == null) {
            head = new Node(k, v);
            tail = head;
            map.put(k, head);
            return;
        }
        Node node = map.get(k);
        // 如果存在，则提到链表开始, 并更新值
        if (node != null) {
            node.value = v;
            removeToHead(node);
        } else {
            // 否则新建一个节点到开始
            Node newNode = new Node(k, v);
            // 如果长度到了容量，需要去除结尾的节点
            if (map.size() >= capacity) {
                System.out.println("移除末尾节点：[" + tail.key + "," + tail.value + "]");
                map.remove(tail.key);
                tail = tail.prev;
                tail.next = null;
            }
            // 连到开始
            map.put(k, newNode);
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * 访问时，如果缓存有，则返回并把该节点放到最前面
     */
    public V get(K key) {
        Node node = map.get(key);
        if (node == null) {
            return null;
        }
        removeToHead(node);
        return node.value;
    }

    private void removeToHead(Node node) {
        if (node == head) {
            return;
        } else if (node == tail) {
            tail = node.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        // set node to head
        node.next = head;
        head.prev = node;
        node.prev = null;
        head = node;
    }

    class Node {
        Node prev;
        Node next;
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
