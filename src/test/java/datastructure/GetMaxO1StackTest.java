package datastructure;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GetMaxO1StackTest {
    @Test
    public void should_return_max_value() {
        GetMaxO1Stack stack = new GetMaxO1Stack();
        stack.push(2);
        stack.push(1);
        assertThat(stack.getMax()).isEqualTo(2);
        stack.push(4);
        assertThat(stack.getMax()).isEqualTo(4);
        stack.push(3);
        assertThat(stack.getMax()).isEqualTo(4);
        stack.push(4);
        assertThat(stack.getMax()).isEqualTo(4);
        assertThat(stack.pop()).isEqualTo(4);
        assertThat(stack.getMax()).isEqualTo(4);
        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.getMax()).isEqualTo(4);
        assertThat(stack.pop()).isEqualTo(4);
        assertThat(stack.getMax()).isEqualTo(2);
    }
}