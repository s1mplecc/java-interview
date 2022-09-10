package datastructure;

import java.util.ArrayList;
import java.util.List;

public class Checkerboard {
    private final List<Scope> scopes;

    public Checkerboard(int n) {
        scopes = new ArrayList<>();
        scopes.add(new Scope(1, n));
    }

    public List<Scope> turnoverPawn(int left, int right) {
        assert left <= right;

        if (allNotOverlap(left, right)) {
            for (int i = 0; i < scopes.size(); i++) {
                if (scopes.get(i).left >= right) {
                    scopes.add(i, new Scope(left, right));
                    break;
                }
            }
            squashAndSort();
            return scopes;
        }

        for (int i = 0; i < scopes.size(); i++) {
            if (scopes.get(i).inclusive(left, right)) {
                Scope remove = scopes.remove(i);
                if (remove.right != right)
                    scopes.add(i, new Scope(right, remove.right - 1));
                if (remove.left != left) {
                    scopes.add(i, new Scope(remove.left + 1, left));
                }
                return scopes;
            }
        }


        return scopes;
    }

    private void squashAndSort() {

    }

    private boolean allNotOverlap(int left, int right) {
        for (Scope scope : scopes) {
            if (scope.right > left && scope.left < right)
                return false;
        }
        return true;
    }

    static class Scope {
        int left;
        int right;

        public Scope(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public boolean inclusive(int left, int right) {
            return left >= this.left && right <= this.right;
        }
    }
}