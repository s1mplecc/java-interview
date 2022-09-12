package datastructure;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StackByQueueTest {
    @Test
    public void should_return_stack_is_or_not_empty() {
        StackByQueue stack = new StackByQueue();
        assertThat(stack.empty()).isTrue();
        stack.push(1);
        assertThat(stack.empty()).isFalse();
        stack.pop();
        assertThat(stack.empty()).isTrue();
        stack.pop();
        assertThat(stack.empty()).isTrue();
    }

    @Test
    public void should_push_and_pop_items() {
        StackByQueue stack = new StackByQueue();
        assertThat(stack.pop()).isEqualTo(-1);
        stack.push(1);
        stack.push(2);
        assertThat(stack.pop()).isEqualTo(2);
        stack.push(3);
        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.pop()).isEqualTo(1);
        stack.push(4);
        stack.push(5);
        assertThat(stack.pop()).isEqualTo(5);
        assertThat(stack.pop()).isEqualTo(4);
        assertThat(stack.pop()).isEqualTo(-1);
    }

    @Test
    public void should_return_top_item() {
        StackByQueue stack = new StackByQueue();
        assertThat(stack.top()).isEqualTo(-1);
        stack.push(1);
        stack.push(2);
        assertThat(stack.top()).isEqualTo(2);
        assertThat(stack.top()).isEqualTo(2);
        stack.pop();
        assertThat(stack.top()).isEqualTo(1);
        stack.push(3);
        stack.push(4);
        assertThat(stack.top()).isEqualTo(4);
        stack.pop();
        assertThat(stack.top()).isEqualTo(3);
        assertThat(stack.top()).isEqualTo(3);
    }
}