package com.jimo.algo.lru;

import java.util.Map;

/**
 * @author jimo
 * @date 19-5-30 下午7:29
 */
public class Main {

    public static void main(String[] args) {

        Map<Integer, Integer> lru = new LruLinkedHasMap<>(2);

        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1));
        lru.put(3, 3);
        System.out.println(lru.get(2));
        System.out.println(lru.get(3));
        lru.put(4, 4);
        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));
    }
}
