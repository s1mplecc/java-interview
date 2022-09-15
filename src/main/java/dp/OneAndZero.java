package dp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OneAndZero {
    /**
     * 题目链接：https://leetcode.cn/problems/ones-and-zeroes/
     * <p>
     * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
     * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
     * <p>
     * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
     * 输出：4
     * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"}
     * <p>
     * 输入：strs = ["10", "0", "1"], m = 1, n = 1
     * 输出：2
     * 解释：最大的子集是 {"0", "1"}
     */
    public int findMaxForm(String[] strs, int m, int n) {
        List<int[]> countPairs = extract(strs);
        int[][] dp = new int[m + 1][n + 1];  // 最多有i个0和j个1的strs的最大子集的大小为dp[i][j]。

        for (int[] pair : countPairs) {
            int x = pair[0];
            int y = pair[1];
            for (int i = m; i >= 0; i--) {
                for (int j = n; j >= 0; j--) {
                    if (i >= x && j >= y)
                        dp[i][j] = Math.max(dp[i][j], dp[i - x][j - y] + 1);  // 不装入(i, j)和装入(i, j)
                }
            }
        }

        return dp[m][n];
    }

    private List<int[]> extract(String[] strs) {
        return Arrays.stream(strs).map(str -> {
            int count = 0;
            for (char s : str.toCharArray()) {
                if (s == '0')
                    count++;
            }
            int[] pairs = new int[2];
            pairs[0] = count;
            pairs[1] = str.length() - count;
            return pairs;
        }).collect(Collectors.toList());
    }
}
