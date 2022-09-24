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
}