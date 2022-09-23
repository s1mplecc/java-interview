package dp;

import org.assertj.core.util.Lists;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BreakerTest {
    @Test
    public void should_return_max_integer_break_mul() {
        Breaker breaker = new Breaker();
        assertThat(breaker.integerBreak(10)).isEqualTo(36);
        assertThat(breaker.integerBreak(30)).isEqualTo(59049);
    }

    @Test
    public void should_return_whether_string_can_break_by_words() {
        Breaker breaker = new Breaker();

        assertThat(breaker.wordBreak("leetcode", Lists.newArrayList("leet", "code"))).isTrue();
        assertThat(breaker.wordBreak("catsandog", Lists.newArrayList("cats", "dog", "sand", "and", "cat"))).isFalse();
    }
}