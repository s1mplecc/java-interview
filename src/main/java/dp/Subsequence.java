package dp;

import java.util.Arrays;

public class Subsequence {
    /**
     * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
     * 若这两个字符串没有公共子序列，则返回 0。
     * <p>
     * 输入：text1 = "abcde", text2 = "ace" 输出：3 解释：最长公共子序列是 "ace"，它的长度为 3。
     * 输入：text1 = "abc", text2 = "abc" 输出：3 解释：最长公共子序列是 "abc"，它的长度为 3。
     * 输入：text1 = "abc", text2 = "def" 输出：0 解释：两个字符串没有公共子序列，返回 0。
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[text1.length()][text2.length()];
    }

    /**
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     * <p>
     * 输入：nums = [10,9,2,5,3,7,101,18] 输出：4 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     * 输入：nums = [0,1,0,3,2,3] 输出：4
     * 输入：nums = [7,7,7,7,7,7,7] 输出：1
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];  // dp[i]表示以第i个元素结尾的最长递增子序列长度
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            max = Math.max(max, dp[i]);  // 一次遍历统计max
        }

        return max;
    }

    /**
     * 给定一个未经排序的整数数组，找到最长且连续递增的子序列，并返回该序列的长度。
     * <p>
     * 输入：nums = [1,3,5,4,7] 输出：3 解释：最长连续递增序列是 [1,3,5], 长度为3。 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
     * 输入：nums = [2,2,2,2,2] 输出：1 解释：最长连续递增序列是 [2], 长度为1。
     */
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                dp[i] = dp[i - 1] + 1;
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    /**
     * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组（连续子序列）的长度。
     * <p>
     * 输入：A: [1,2,3,2,1] B: [3,2,1,4,7]
     * 输出：3
     * 解释：长度最长的公共子数组是 [3, 2, 1] 。
     */
    public int findLengthOfLCCS(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int max = 0;

        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max;
    }

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 输入: [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];  // dp[i]表示以nums[i]结尾最大连续子数组和
        dp[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] <= 0)
                dp[i] = nums[i];
            else
                dp[i] = dp[i - 1] + nums[i];
            max = Math.max(dp[i], max);
        }

        return max;
    }
}
