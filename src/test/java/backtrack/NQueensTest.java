package backtrack;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NQueensTest {
    @Test
    public void should_cannot_place_n_queen_when_n_equals_2or3() {
        NQueens queens1 = new NQueens(2);
        assertThat(queens1.solutions().size()).isEqualTo(0);
        NQueens queens2 = new NQueens(3);
        assertThat(queens2.solutions().size()).isEqualTo(0);
    }

    @Test
    public void should_can_place_n_queen_when_n_equals_1() {
        NQueens queens = new NQueens(1);
        assertThat(queens.solutions().size()).isEqualTo(1);
        NQueens.Coordinate coordinate = new NQueens.Coordinate(0, 0);
        assertThat(queens.solutions().get(0)).contains(coordinate);
    }

    @Test
    public void should_can_place_n_queen_when_n_equals_4() {
        NQueens queens = new NQueens(4);
        List<List<NQueens.Coordinate>> solutions = queens.solutions();

        assertThat(solutions.size()).isEqualTo(2);
        assertThat(solutions.get(0)).containsExactly(
                new NQueens.Coordinate(0, 1),
                new NQueens.Coordinate(1, 3),
                new NQueens.Coordinate(2, 0),
                new NQueens.Coordinate(3, 2)
                );
        assertThat(solutions.get(1)).containsExactly(
                new NQueens.Coordinate(0, 2),
                new NQueens.Coordinate(1, 0),
                new NQueens.Coordinate(2, 3),
                new NQueens.Coordinate(3, 1)
                );
    }

    @Test
    public void should_can_place_n_queen_when_n_equals_8() {
        NQueens queens = new NQueens(8);
        List<List<NQueens.Coordinate>> solutions = queens.solutions();

        assertThat(solutions.size()).isEqualTo(92);
    }
}