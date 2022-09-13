package dp;

public class IntegerBreak {
    /**
     * 题目链接：https://leetcode.cn/problems/integer-break/
     * <p>
     * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。2 <= n <= 58。
     * <p>
     * 输入: 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
     */
    public int integerBreak(int n) {
        assert n >= 2;
        int[] dp = new int[n + 1];
        dp[2] = 1;

        for (int i = 3; i < n + 1; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(max, Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
