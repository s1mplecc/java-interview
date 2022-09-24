package dp;

import java.util.Arrays;

public class StringSubsequence {

    /**
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * <p>
     * 输入：s = "abc", t = "ahbgdc" 输出：true
     * 输入：s = "axc", t = "ahbgdc" 输出：false
     */
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];  // dp[i][j]表示s的i-1位与t的前j-1位的公共子序列长度

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = i; j < t.length() + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = dp[i][j - 1];
            }
        }

        return dp[s.length()][t.length()] == s.length();
    }

    /**
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * <p>
     * 输入：s = "abc", t = "ahbgdc" 输出：true
     * 输入：s = "axc", t = "ahbgdc" 输出：false
     */
    public boolean isSubsequenceByDoublePointer(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j))
                i++;
            j++;
        }
        return i == s.length();
    }

    /**
     * 题目链接：https://leetcode.cn/problems/distinct-subsequences
     * <p>
     * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
     * <p>
     * 输入：s = "rabbbit", t = "rabbit"
     * 输出：3
     * 解释：有 3 种可以从 s 中得到 "rabbit" 的方案。
     */
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];  // dp[i][j]表示以i-1为结尾的t出现在以j-1为结尾的s子序列中的个数
        Arrays.fill(dp[0], 1);

        for (int i = 1; i < t.length() + 1; i++) {
            for (int j = i; j < s.length() + 1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1))
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];  // dp[i][j - 1]不使用s[j-1]结尾，dp[i - 1][j - 1]使用s[j-1]结尾
                else
                    dp[i][j] = dp[i][j - 1];
            }
        }

        return dp[t.length()][s.length()];
    }
}
