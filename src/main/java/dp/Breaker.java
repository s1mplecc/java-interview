package dp;

import java.util.List;

public class Breaker {
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

    /**
     * 题目链接：https://leetcode.cn/problems/word-break/
     * <p>
     * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
     * 拆分时可以重复使用字典中的单词。你可以假设字典中没有重复的单词。
     * <p>
     * 输入: s = "leetcode", wordDict = ["leet", "code"] 输出: true 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
     * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"] 输出: false
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;  // ""

        for (int i = 1; i < s.length() + 1; i++) {
            for (String word : wordDict) {
                int length = word.length();
                if (i >= length && dp[i - length] == 1 && word.equals(s.substring(i - length, i))) {
                    dp[i] = 1;
                    break;
                }
            }
        }

        return dp[s.length()] == 1;
    }
}
