package dp;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubSequenceTest {
    @Test
    public void should_return_length_of_lis() {
        SubSequence sequence = new SubSequence();

        assertThat(sequence.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18})).isEqualTo(4);
        assertThat(sequence.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6})).isEqualTo(6);
    }
}