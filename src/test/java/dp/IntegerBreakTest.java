package dp;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegerBreakTest {
    @Test
    public void should_return_max_integer_break_mul() {
        IntegerBreak integerBreak = new IntegerBreak();
        assertThat(integerBreak.integerBreak(10)).isEqualTo(36);
        assertThat(integerBreak.integerBreak(30)).isEqualTo(59049);
    }
}