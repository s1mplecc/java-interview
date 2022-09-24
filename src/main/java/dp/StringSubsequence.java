package dp;

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
}
