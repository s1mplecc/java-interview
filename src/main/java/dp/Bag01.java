package dp;

import java.util.Arrays;

public class Bag01 {

    public int maxValue(int capacity, Product[] products) {
        int[][] dp = new int[products.length][capacity + 1];
        for (int i = 0; i < products.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < capacity + 1; i++) {
            if (i >= products[0].weight) {
                dp[0][i] = products[0].value;
            } else {
                dp[0][i] = 0;
            }
        }

        for (int i = 1; i < products.length; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                if (j < products[i].weight) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - products[i].weight] + products[i].value);
                }
            }
        }

        printDp(dp);
        return dp[products.length - 1][capacity];
    }

    private void printDp(int[][] dp) {
        Arrays.stream(dp).forEach((each) -> {
            for (int i : each) {
                System.out.print(i + " ");
            }
            System.out.println();
        });
    }

    public static class Product {
        int weight;
        int value;

        public Product(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
