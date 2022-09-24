package dp;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSubsequenceTest {

    @Test
    public void should_return_is_subsequence_by_double_pointer() {
        StringSubsequence subsequence = new StringSubsequence();
        assertThat(subsequence.isSubsequenceByDoublePointer("abc", "ahbgdc")).isTrue();
        assertThat(subsequence.isSubsequenceByDoublePointer("axc", "ahbgdc")).isFalse();
        assertThat(subsequence.isSubsequenceByDoublePointer("aaaaaa", "bbaaaa")).isFalse();
    }

    @Test
    public void should_return_is_subsequence_by_dp() {
        StringSubsequence subsequence = new StringSubsequence();
        assertThat(subsequence.isSubsequence("abc", "ahbgdc")).isTrue();
        assertThat(subsequence.isSubsequence("axc", "ahbgdc")).isFalse();
        assertThat(subsequence.isSubsequence("aaaaaa", "bbaaaa")).isFalse();
    }

    @Test
    public void should_return_num_distinct() {
        StringSubsequence subsequence = new StringSubsequence();
        assertThat(subsequence.numDistinct("rabbbit", "rabbit")).isEqualTo(3);
    }

    @Test
    public void should_return_min_distance() {
        StringSubsequence subsequence = new StringSubsequence();
        assertThat(subsequence.minDistance("sea", "eat")).isEqualTo(2);
    }

    @Test
    public void should_compute_edit_distance_by_dp() {
        StringSubsequence subsequence = new StringSubsequence();
        assertThat(subsequence.editDistance("horse", "ros")).isEqualTo(3);
    }
}