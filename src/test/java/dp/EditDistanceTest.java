package dp;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EditDistanceTest {
    @Test
    public void should_compute_edit_distance_by_dp() {
        EditDistance editDistance = new EditDistance();
        assertThat(editDistance.minDistance("horse", "ros")).isEqualTo(3);
    }
}