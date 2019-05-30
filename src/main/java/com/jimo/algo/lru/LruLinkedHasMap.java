package com.jimo.algo.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author jimo
 * @date 19-5-30 下午8:18
 */
public class LruLinkedHasMap<K, V> extends LinkedHashMap<K, V> {
    private int capacity;

    public LruLinkedHasMap(int capacity) {
        super(16, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        System.out.println("removeEldestEntry:(" + eldest.getKey() + "," + eldest.getValue() + ")");
        return size() > capacity;
    }
}
