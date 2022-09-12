package datastructure;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MonotonicStackTest {
    @Test
    public void should_return_next_greater_daily_temperatures() {
        MonotonicStack stack = new MonotonicStack();
        int[] input = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        assertThat(stack.dailyTemperatures(input)).containsExactly(1, 1, 4, 2, 1, 1, 0, 0);
    }


    @Test
    public void should_return_next_greater_elements() {
        MonotonicStack stack = new MonotonicStack();
        int[] input = {1, 2, 1};
        assertThat(stack.nextGreaterElements(input)).containsExactly(2, -1, 2);
    }
}