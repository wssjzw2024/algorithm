package com.liu.algorithm.dynamicprogramming.project02;

/**
 * @author liu
 */
public class MinDistance005 {
    /**
     * 动态规划
     * 思路
     * 定义状态 dp[i][j] 表示为：「以 word1 中前 i 个字符组成的子字符串 str1」变为「以 word2 中前 j个字符组成的子字符串 str2，所需要的最少操作次数。
     * 步骤
     * 1.获取长度
     * 2.初始化数组
     * 3.dp[i][0] = i dp[0][j] = j
     * 4.循环
     * 5.i位置和j位置的字符相等 dp[i][j] = dp[i - 1][j - 1];
     * 6.不相等 dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
     * 返回 dp[n][m]
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1,String word2){
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[n][m];
    }
}
