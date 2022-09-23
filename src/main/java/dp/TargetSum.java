package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TargetSum {
    /**
     * 题目链接：https://leetcode.cn/problems/target-sum/submissions/
     * <p>
     * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
     * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
     * <p>
     * 输入：nums: [1, 1, 1, 1, 1], S: 3
     * 输出：5
     */
    public int findTargetSumWaysBy1DimDP(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if ((sum + target) % 2 == 1 || Math.abs(target) > sum)
            return 0;

        int bagSize = (sum + target) >> 1;
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;  // 填满容量0的包有1种方法，即都不放入

        for (int num : nums) {
            for (int i = bagSize; i >= 0; i--) {  // 判断条件取>=，num可以为0
                if (i >= num)
                    dp[i] = dp[i] + dp[i - num];
            }
        }

        return dp[bagSize];
    }

    public int findTargetSumWaysBy2DimDP(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if ((sum + target) % 2 == 1 || Math.abs(target) > sum)
            return 0;

        long count0 = Arrays.stream(nums).filter(x -> x == 0).count();
        nums = Arrays.stream(nums).filter(x -> x != 0).toArray();
        if (nums.length == 0)
            return target == 0 ? 1 << count0 : 0;

        int bagSize = (sum + target) >> 1;
        int[][] dp = initDP(nums, bagSize);  // dp[i][j] 表示：加入物品i后填满容量j的包，有dp[i][j]种方法

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < bagSize + 1; j++) {
                if (j >= nums[i])
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];  // 物品i放入或不放入
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[nums.length - 1][bagSize] << count0;
    }

    private int[][] initDP(int[] nums, int bagSize) {
        int[][] dp = new int[nums.length][bagSize + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
        }
        if (nums[0] <= bagSize)
            dp[0][nums[0]] = 1;
        return dp;
    }

    /**
     * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
     * 请注意，顺序不同的序列被视作不同的组合。
     * <p>
     * nums = [1, 2, 3] target = 4
     * 所有可能的组合为： (1, 1, 1, 1) (1, 1, 2) (1, 2, 1) (1, 3) (2, 1, 1) (2, 2) (3, 1)
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 0; i < target + 1; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j])
                    dp[i] += dp[i - nums[j]];
            }
        }

        return dp[target];
    }

    /**
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
     * 你可以认为每种硬币的数量是无限的。
     * <p>
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    /**
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
     * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
     * <p>
     * 示例 1： 输入：n = 12 输出：3 解释：12 = 4 + 4 + 4
     * 示例 2： 输入：n = 13 输出：2 解释：13 = 4 + 9
     */
    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            squares.add(i * i);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < squares.size() && squares.get(j) <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - squares.get(j)]);
            }
        }

        return dp[n];
    }
}
