package backtrack;

import java.util.ArrayList;
import java.util.List;

public class RouteSelector {
    private final int[][] weights;
    private final ArrayList<String> routes;

    public RouteSelector(int[][] weights) {
        this.weights = weights;
        this.routes = new ArrayList<>();
    }

    public List<String> validRoutes() {
        for (int weight : weights[0]) {
            // begin with 2nd layer
            backTracing(1, weight, String.valueOf(weight));
        }
        return routes;
    }

    private void backTracing(int layer, int lastChoice, String currentRoute) {
        if (layer == weights.length) {
            routes.add(currentRoute);
            return;
        }
        for (int weight : weights[layer]) {
            if (weight <= 2 * lastChoice && lastChoice < weight) {
                backTracing(layer + 1, weight, currentRoute + " -> " + weight);
            }
        }
    }
}
