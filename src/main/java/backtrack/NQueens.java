package backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 任何两个皇后都不能在同一行、同一列以及同一条斜线上。
 * <p>
 * 输入：n = 4
 * 输出：2
 */
public class NQueens {
    private final int n;
    private final List<List<Coordinate>> solutions;

    public NQueens(int n) {
        this.n = n;
        solutions = new ArrayList<>();
    }

    public List<List<Coordinate>> solutions() {
        for (int i = 0; i < n; i++) {
            List<Coordinate> coordinates = new ArrayList<>();
            coordinates.add(new Coordinate(0, i));
            backTracing(1, coordinates);
        }
        return solutions;
    }

    private void backTracing(int X, List<Coordinate> placedCoordinates) {
        if (X == n)
            solutions.add(placedCoordinates);
        for (int Y = 0; Y < n; Y++) {
            boolean canPlaced = true;
            for (Coordinate coordinate : placedCoordinates) {
                if (coordinate.Y == Y || Math.abs(coordinate.X - X) == Math.abs(coordinate.Y - Y)) {
                    canPlaced = false;
                    break;
                }
            }
            if (canPlaced) {
                List<Coordinate> fork = new ArrayList<>(placedCoordinates);
                fork.add(new Coordinate(X, Y));
                backTracing(X + 1, fork);
            }
        }
    }

    public static class Coordinate {
        public final Integer X;
        public final Integer Y;

        public Coordinate(Integer x, Integer y) {
            X = x;
            Y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return Objects.equals(X, that.X) && Objects.equals(Y, that.Y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(X, Y);
        }

        @Override
        public String toString() {
            return String.format("(%s, %s)", X, Y);
        }
    }
}
