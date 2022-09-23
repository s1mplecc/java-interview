package dp;

import java.util.Arrays;


/**
 * 背包递推公式
 * <p>
 * 问能否能装满背包（或者最多装多少）：dp[j] = max(dp[j], dp[j - nums[i]] + nums[i]); ，对应题目如下：
 * 动态规划：416.分割等和子集(opens new window)
 * 动态规划：1049.最后一块石头的重量 II(opens new window)
 * <p>
 * 问装满背包有几种方法：dp[j] += dp[j - nums[i]] ，对应题目如下：
 * 动态规划：494.目标和(opens new window)
 * 动态规划：518. 零钱兑换 II(opens new window)
 * 动态规划：377.组合总和Ⅳ(opens new window)
 * 动态规划：70. 爬楼梯进阶版（完全背包）(opens new window)
 * <p>
 * 问背包装满最大价值：dp[j] = max(dp[j], dp[j - weight[i]] + value[i]); ，对应题目如下：
 * 动态规划：474.一和零(opens new window)
 * <p>
 * 问装满背包所有物品的最小个数：dp[j] = min(dp[j - coins[i]] + 1, dp[j]); ，对应题目如下：
 * 动态规划：322.零钱兑换(opens new window)
 * 动态规划：279.完全平方数(opens new window)
 */
public class Bag01 {

    /**
     * 有n件物品和一个最多能背重量为w的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。
     * 每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大。
     */
    public int maxValueBy2DimDP(int capacity, Product[] products) {
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

        print2DimDP(dp);
        return dp[products.length - 1][capacity];
    }

    public int maxValueBy1DimDP(int capacity, Product[] products) {
        int[] dp = new int[capacity + 1];

        for (Product product : products) {
            for (int j = capacity; j > 0; j--) {  // 从后往前，防止重复放入
                if (j >= product.weight) {
                    // 不放入：dp[j]，相当于 dp[i - 1][j]；放入：dp[j - product.weight] + product.value
                    dp[j] = Math.max(dp[j], dp[j - product.weight] + product.value);
                }
            }
        }

        print1DimDP(dp);
        return dp[capacity];
    }

    private void print1DimDP(int[] dp) {
        System.out.println(String.join(" ", Arrays.stream(dp).mapToObj(String::valueOf).toArray(CharSequence[]::new)));
    }

    private void print2DimDP(int[][] dp) {
        Arrays.stream(dp).forEach((each) -> {
            for (int i : each) {
                System.out.print(i + " ");
            }
            System.out.println();
        });
        System.out.println();
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
