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

    @Test
    public void should_catch_rain_by_dp() {
        MonotonicStack stack = new MonotonicStack();
        int[] input = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        assertThat(stack.catchRainByDP(input)).isEqualTo(6);
        int[] input2 = new int[]{4, 2, 0, 3, 2, 5};
        assertThat(stack.catchRainByDP(input2)).isEqualTo(9);
    }

    @Test
    public void should_catch_rain_by_monotonic_stack() {
        MonotonicStack stack = new MonotonicStack();
        int[] input = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        assertThat(stack.catchRain(input)).isEqualTo(6);
        int[] input2 = new int[]{4, 2, 0, 3, 2, 5};
        assertThat(stack.catchRain(input2)).isEqualTo(9);
    }
}