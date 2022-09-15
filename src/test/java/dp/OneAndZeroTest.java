package dp;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OneAndZeroTest {
    @Test
    public void should_find_max_form() {
        OneAndZero oneAndZero = new OneAndZero();

        assertThat(oneAndZero.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3)).isEqualTo(4);
    }
}