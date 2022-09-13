package dp;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UniquePathTest {
    @Test
    public void should_calculate_how_many_unique_paths() {
        UniquePath path = new UniquePath();
        assertThat(path.uniquePaths(3, 7)).isEqualTo(28);
        assertThat(path.uniquePaths(2, 3)).isEqualTo(3);
        assertThat(path.uniquePaths(7, 3)).isEqualTo(28);
        assertThat(path.uniquePaths(3, 3)).isEqualTo(6);
    }

    @Test
    public void should_calculate_how_many_unique_paths_with_obstacles() {
        UniquePath path = new UniquePath();
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        assertThat(path.uniquePathsWithObstacles(obstacleGrid)).isEqualTo(2);
        int[][] obstacleGrid1 = {{0, 0, 0}, {0, 1, 1}, {0, 0, 0}};
        assertThat(path.uniquePathsWithObstacles(obstacleGrid1)).isEqualTo(1);
        int[][] obstacleGrid2 = {{0, 0, 0}, {0, 1, 1}, {1, 0, 0}};
        assertThat(path.uniquePathsWithObstacles(obstacleGrid2)).isEqualTo(0);
    }
}