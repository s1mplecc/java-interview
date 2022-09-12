package datastructure;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueueByStackTest {
    @Test
    public void should_return_queue_is_empty_or_not() {
        QueueByStack queue = new QueueByStack();
        assertThat(queue.empty()).isTrue();
        queue.push(1);
        queue.push(2);
        assertThat(queue.empty()).isFalse();
        queue.pop();
        assertThat(queue.empty()).isFalse();
        queue.pop();
        assertThat(queue.empty()).isTrue();
    }

    @Test
    public void should_push_and_pop_items() {
        QueueByStack queue = new QueueByStack();
        queue.push(1);
        queue.push(2);
        assertThat(queue.pop()).isEqualTo(1);
        queue.push(3);
        assertThat(queue.pop()).isEqualTo(2);
        queue.push(4);
        queue.push(5);
        assertThat(queue.pop()).isEqualTo(3);
        assertThat(queue.pop()).isEqualTo(4);
        assertThat(queue.pop()).isEqualTo(5);
        assertThat(queue.pop()).isEqualTo(-1);
    }

    @Test
    public void should_peek_item() {
        QueueByStack queue = new QueueByStack();
        assertThat(queue.peek()).isEqualTo(-1);
        queue.push(1);
        queue.push(2);
        assertThat(queue.peek()).isEqualTo(1);
        assertThat(queue.peek()).isEqualTo(1);
        queue.pop();
        queue.push(3);
        assertThat(queue.peek()).isEqualTo(2);
    }
}