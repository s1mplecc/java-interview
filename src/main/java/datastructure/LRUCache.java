package datastructure;

import java.util.*;

// least recently used: 缓存淘汰/页面置换
public class LRUCache {
    private final LinkedHashMap<Integer, Integer> cache;
    private final int capacity;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public void put(int value) {
        if (capacity > cache.size()) {
            cache.put(value, value);
            visitRecently(value);
        } else if (cache.containsKey(value)) {
            visitRecently(value);
        } else {
            int first = cache.keySet().iterator().next();
            cache.remove(first);
            cache.put(value, value);
        }
    }

    public int visit(int value) {
        if (!cache.containsKey(value))
            return -1;
        visitRecently(value);
        return cache.get(value);
    }

    private void visitRecently(int value) {
        cache.remove(value);
        cache.put(value, value);
    }

    public Object[] cacheSequence() {
//        Integer[] integers = Arrays.stream(cache.keySet().toArray()).toArray(Integer[]::new);
        return cache.keySet().toArray();
    }
}
