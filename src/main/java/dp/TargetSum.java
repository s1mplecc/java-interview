package dp;

import java.util.Arrays;

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
    public int findTargetSumWaysBy2DimDP(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if ((sum + target) % 2 == 1 || Math.abs(target) > sum)
            return 0;

        long count0 = Arrays.stream(nums).filter(x -> x == 0).count();
        nums = Arrays.stream(nums).filter(x -> x != 0).toArray();
        if (nums.length == 0)
            return target == 0 ? 1 << count0 : 0;

        int bagSize = (sum + target) >> 1;
        int[][] dp = initDP(nums, bagSize);  // dp[i][j] 表示：加入物品i后填满j这么大容积的包，有dp[i][j]种方法

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
}
