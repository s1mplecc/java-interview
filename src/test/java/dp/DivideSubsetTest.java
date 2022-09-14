package dp;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DivideSubsetTest {
    @Test
    public void should_divide_subset_by_back_tracing() {
        DivideSubset divide = new DivideSubset();

        assertThat(divide.canPartitionByBackTracing(new int[]{1, 5, 11, 5})).isTrue();
        assertThat(divide.canPartitionByBackTracing(new int[]{1, 5, 11, 5, 1, 3})).isTrue();
        assertThat(divide.canPartitionByBackTracing(new int[]{1, 5, 11, 5, 2, 2})).isTrue();
        assertThat(divide.canPartitionByBackTracing(new int[]{1, 2, 3, 5})).isFalse();
    }

    @Test
    public void should_divide_subset_by_dp() {
        DivideSubset divide = new DivideSubset();

        assertThat(divide.canPartition(new int[]{1, 5, 11, 5})).isTrue();
        assertThat(divide.canPartition(new int[]{1, 5, 11, 5, 1, 3})).isTrue();
        assertThat(divide.canPartition(new int[]{1, 5, 11, 5, 2, 2})).isTrue();
        assertThat(divide.canPartition(new int[]{1, 2, 3, 5})).isFalse();
    }
}