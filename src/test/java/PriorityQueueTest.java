
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PriorityQueueTest {

    @Test
    public void should_dequeue_and_enqueue_values() {
        PriorityQueue queue = new PriorityQueue();
        queue.enqueue(3);
        assertThat(queue.dequeue()).isEqualTo(3);
    }

    @Test
    public void should_enqueue_compare_and_swap_with_parent_node() {
        PriorityQueue queue = new PriorityQueue();
        queue.enqueue(3);
        queue.enqueue(1);
        assertThat(queue.queue()).containsSequence(3, 1);
        queue.enqueue(6);
        assertThat(queue.queue()).containsSequence(6, 1, 3);
        queue.enqueue(2);
        assertThat(queue.queue()).containsSequence(6, 2, 3, 1);
        queue.enqueue(7);
        assertThat(queue.queue()).containsSequence(7, 6, 3, 1, 2);
    }

    @Test
    public void should_enqueue_values_with_constructor() {
        PriorityQueue queue = new PriorityQueue(3, 1, 6, 2, 7);
        assertThat(queue.queue()).containsSequence(7, 6, 3, 1, 2);
    }

    @Test
    public void should_dequeue_max_priority_value() {
        PriorityQueue queue = new PriorityQueue(3, 1, 6, 2, 7);

        assertThat(queue.dequeue()).isEqualTo(7);
        assertThat(queue.queue()).containsSequence(6, 2, 3, 1);
        assertThat(queue.dequeue()).isEqualTo(6);
        assertThat(queue.queue()).containsSequence(3, 2, 1);
        assertThat(queue.dequeue()).isEqualTo(3);
        assertThat(queue.queue()).containsSequence(2, 1);
        assertThat(queue.dequeue()).isEqualTo(2);
        assertThat(queue.dequeue()).isEqualTo(1);
    }
}