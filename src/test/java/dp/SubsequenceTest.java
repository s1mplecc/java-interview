package dp;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubsequenceTest {
    @Test
    public void should_return_length_of_lis() {
        Subsequence sequence = new Subsequence();

        assertThat(sequence.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18})).isEqualTo(4);
        assertThat(sequence.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6})).isEqualTo(6);
    }

    @Test
    public void should_find_length_of_lccs() {
        Subsequence sequence = new Subsequence();

        assertThat(sequence.findLengthOfLCCS(
                new int[]{0, 1, 1, 1, 1},
                new int[]{1, 0, 1, 0, 1})).isEqualTo(2);

        assertThat(sequence.findLengthOfLCCS(
                new int[]{1, 2, 3, 2, 1},
                new int[]{3, 2, 1, 4, 7})).isEqualTo(3);
    }
}