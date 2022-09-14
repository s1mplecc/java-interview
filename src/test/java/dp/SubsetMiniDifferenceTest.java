package dp;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubsetMiniDifferenceTest {
    @Test
    public void should_divide_subset_mini_difference_by_dp() {
        SubsetMiniDifference divide = new SubsetMiniDifference();

        assertThat(divide.lastStoneWeightII(new int[]{1, 1, 4, 2, 2})).isEqualTo(0);
        assertThat(divide.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1})).isEqualTo(1);
    }
}