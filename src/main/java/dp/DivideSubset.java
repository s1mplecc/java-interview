package dp;

import java.util.Arrays;

/**
 * 划分等和子集（变种背包问题）
 */
public class DivideSubset {

    /**
     * 题目链接：https://leetcode.cn/problems/partition-equal-subset-sum/comments/
     * <p>
     * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     * 注意: 每个数组中的元素不会超过 100 数组的大小不会超过 200
     * <p>
     * 示例 1: 输入: [1, 5, 11, 5] 输出: true 解释: 数组可以分割成 [1, 5, 5] 和 [11].
     * 示例 2: 输入: [1, 2, 3, 5] 输出: false 解释: 数组不能分割成两个元素和相等的子集.
     */
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1)
            return false;
        int except = sum >> 1;
        int[] dp = new int[except + 1];
        for (int weight : nums) {
            for (int i = except; i > 0; i--) {
                if (i >= weight)
                    dp[i] = Math.max(dp[i], dp[i - weight] + weight);
                if (dp[i] == except)
                    return true;
            }
        }
        return false;
    }

    // 回溯法会超时
    public boolean canPartitionByBackTracing(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1)
            return false;
        return backTracing(0, sum >>> 1, Arrays.stream(nums).sorted().toArray(), 0);
    }

    public boolean backTracing(int curSum, int except, int[] nums, int i) {
        if (curSum == except)
            return true;
        if (i >= nums.length || curSum + nums[i] > except)
            return false;
        boolean addI = backTracing(curSum + nums[i], except, nums, i + 1);
        boolean notAddI = backTracing(curSum, except, nums, i + 1);
        return addI || notAddI;
    }
}
