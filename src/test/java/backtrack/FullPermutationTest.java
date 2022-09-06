package backtrack;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FullPermutationTest {
    @Test
    public void should_construct_full_permutation_sequences_when_case_one() {
        int[] nums = {1, 2, 3};
        FullPermutation fullPermutation = new FullPermutation(nums);
        List<List<Integer>> sequences = fullPermutation.sequences();

        assertThat(sequences.size()).isEqualTo(6);
        assertThat(sequences.get(0)).containsExactly(1, 2, 3);
        assertThat(sequences.get(1)).containsExactly(1, 3, 2);
        assertThat(sequences.get(2)).containsExactly(2, 1, 3);
        assertThat(sequences.get(3)).containsExactly(2, 3, 1);
        assertThat(sequences.get(4)).containsExactly(3, 1, 2);
        assertThat(sequences.get(5)).containsExactly(3, 2, 1);
    }

    @Test
    public void should_construct_full_permutation_sequences_when_case_two() {
        int[] nums = {0, 1, 2, 3};
        FullPermutation fullPermutation = new FullPermutation(nums);
        List<List<Integer>> sequences = fullPermutation.sequences();

        assertThat(sequences.size()).isEqualTo(24);
        assertThat(sequences).contains(Arrays.asList(1, 2, 3, 0));
        assertThat(sequences).contains(Arrays.asList(1, 2, 0, 3));
        assertThat(sequences).contains(Arrays.asList(1, 3, 2, 0));
    }

    @Test
    public void should_construct_full_permutation_sequences_when_case_three() {
        int[] nums = {2, 1};
        FullPermutation fullPermutation = new FullPermutation(nums);
        List<List<Integer>> sequences = fullPermutation.sequences();

        assertThat(sequences.size()).isEqualTo(2);
        assertThat(sequences).containsExactlyInAnyOrder(Arrays.asList(1, 2), Arrays.asList(2, 1));
    }
}