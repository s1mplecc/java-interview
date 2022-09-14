package dp;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TargetSumTest {
    @Test
    public void should_find_target_sum_ways_by_2dim_dp() {
        TargetSum targetSum = new TargetSum();

        assertThat(targetSum.findTargetSumWaysBy2DimDP(new int[]{1, 1, 1, 1, 1}, 3)).isEqualTo(5);
        assertThat(targetSum.findTargetSumWaysBy2DimDP(new int[]{1}, 1)).isEqualTo(1);
        assertThat(targetSum.findTargetSumWaysBy2DimDP(new int[]{1, 0}, 1)).isEqualTo(2);
        assertThat(targetSum.findTargetSumWaysBy2DimDP(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1)).isEqualTo(256);
        assertThat(targetSum.findTargetSumWaysBy2DimDP(new int[]{9, 7, 0, 3, 9, 8, 6, 5, 7, 6}, 2)).isEqualTo(40);
    }

    @Test
    public void should_find_target_sum_ways_by_1dim_dp() {
        TargetSum targetSum = new TargetSum();

        assertThat(targetSum.findTargetSumWaysBy1DimDP(new int[]{1, 1, 1, 1, 1}, 3)).isEqualTo(5);
        assertThat(targetSum.findTargetSumWaysBy1DimDP(new int[]{1}, 1)).isEqualTo(1);
        assertThat(targetSum.findTargetSumWaysBy1DimDP(new int[]{1, 0}, 1)).isEqualTo(2);
        assertThat(targetSum.findTargetSumWaysBy1DimDP(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1)).isEqualTo(256);
        assertThat(targetSum.findTargetSumWaysBy1DimDP(new int[]{9, 7, 0, 3, 9, 8, 6, 5, 7, 6}, 2)).isEqualTo(40);
    }
}