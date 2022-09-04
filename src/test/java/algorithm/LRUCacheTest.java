package algorithm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LRUCacheTest {
    @Test
    public void should_enqueue_items_and_adjust_order() {
        LRUCache lruCache = new LRUCache();
        lruCache.enqueue(3);
        lruCache.enqueue(2);
        lruCache.enqueue(1);
        assertThat(lruCache.queue()).containsExactly(3, 2, 1);
        lruCache.enqueue(3);
        assertThat(lruCache.queue()).containsExactly(2, 1, 3);
        lruCache.enqueue(4);
        assertThat(lruCache.queue()).containsExactly(2, 1, 3, 4);
        lruCache.enqueue(1);
        assertThat(lruCache.queue()).containsExactly(2, 3, 4, 1);
    }

    @Test
    public void should_dequeue_lru_item() {
        LRUCache lruCache = new LRUCache();
        lruCache.enqueue(3);
        lruCache.enqueue(2);
        lruCache.enqueue(1);
        lruCache.enqueue(3);
        assertThat(lruCache.dequeue()).isEqualTo(2);
    }
}