package backtrack;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RouteSelectorTest {
    @Test
    public void should_choice_all_valid_routes_case_one() {
        int[][] weights = {{2, 7, 2}, {1, 5, 3}, {4, 6, 3}};
        RouteSelector selector = new RouteSelector(weights);

        List<String> routes = selector.validRoutes();
        assertThat(routes.size()).isEqualTo(4);
        assertThat(routes).containsExactlyInAnyOrder("2 -> 3 -> 4", "2 -> 3 -> 4", "2 -> 3 -> 6", "2 -> 3 -> 6");
    }

    @Test
    public void should_choice_all_valid_routes_case_two() {
        int[][] weights = {{2, 7, 3, 4}, {1, 5, 3, 8}, {4, 6, 3, 10}};
        RouteSelector selector = new RouteSelector(weights);

        List<String> routes = selector.validRoutes();
        assertThat(routes.size()).isEqualTo(8);
        assertThat(routes).contains("2 -> 3 -> 4");
        assertThat(routes).contains("2 -> 3 -> 6");
        assertThat(routes).contains("3 -> 5 -> 6");
        assertThat(routes).contains("3 -> 5 -> 10");
        assertThat(routes).contains("4 -> 5 -> 6");
        assertThat(routes).contains("4 -> 5 -> 10");
        assertThat(routes).contains("4 -> 8 -> 10");
        assertThat(routes).contains("7 -> 8 -> 10");
    }
}