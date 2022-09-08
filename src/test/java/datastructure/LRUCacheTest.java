package datastructure;

import datastructure.LRUCache;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LRUCacheTest {
    @Test
    public void should_cache_values() {
        LRUCache cache = new LRUCache(3);

        cache.put(1);
        cache.put(2);
        assertThat(cache.cacheSequence()).containsExactly(1, 2);
        cache.put(3);
        assertThat(cache.cacheSequence()).containsExactly(1, 2, 3);
    }

    @Test
    public void should_swap_out_least_recently_visit() {
        LRUCache cache = new LRUCache(3);
        cache.put(1);
        cache.put(2);
        cache.put(3);

        cache.visit(1);
        assertThat(cache.cacheSequence()).containsExactly(2, 3, 1);
        cache.put(4);
        assertThat(cache.cacheSequence()).containsExactly(3, 1, 4);
        cache.visit(1);
        assertThat(cache.cacheSequence()).containsExactly(3, 4, 1);
    }

    @Test
    public void should_return_cache_not_hit() {
        LRUCache cache = new LRUCache(3);
        cache.put(1);
        assertThat(cache.visit(2)).isEqualTo(-1);
    }
}