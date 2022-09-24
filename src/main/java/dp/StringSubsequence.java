package dp;

import java.util.Arrays;

public class StringSubsequence {

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

    /**
     * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
     * <p>
     * 输入: "sea", "eat"
     * 输出: 2
     * 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i < word1.length() + 1; i++) {
            dp[i][0] = i;  // word1到i结尾删为""需要i步
        }
        for (int j = 1; j < word2.length() + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(
                                    dp[i - 1][j] + 1,  // 删word1[i - 1]
                                    dp[i][j - 1] + 1),  // 删word2[j - 1]
                            dp[i - 1][j - 1] + 2);  // 同时删word1[i - 1]和word2[j - 1]
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
