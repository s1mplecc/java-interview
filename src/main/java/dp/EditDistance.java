package dp;

/**
 * 编辑距离
 */
public class EditDistance {
    /**
     * 题目链接：https://leetcode.cn/problems/edit-distance/submissions/
     * <p>
     * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
     * 你可以对一个单词进行如下三种操作：插入一个字符、删除一个字符、替换一个字符。
     * <p>
     * 输入：word1 = "horse", word2 = "ros"
     * 输出：3
     * 解释：horse -> rorse (将 'h' 替换为 'r') rorse -> rose (删除 'r') rose -> ros (删除 'e')
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(Math.min(
                            dp[i - 1][j],  // word1 删除一个字符
                            dp[i][j - 1]),  // word2 删除一个字符 == word1 插入一个字符
                            dp[i - 1][j - 1]  // 替换字符
                    );
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
