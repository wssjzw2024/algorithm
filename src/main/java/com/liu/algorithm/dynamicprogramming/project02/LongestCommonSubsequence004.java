package com.liu.algorithm.dynamicprogramming.project02;

/**
 * @author liu
 */
public class LongestCommonSubsequence004 {

    /**
     * 动态规划
     * 思路
     * dp[i][j] 表示以i结尾test1 和以j结尾test2的最长公共子序列长度
     * 步骤
     * 1.获取text1长度 m和text2的长度n
     * 2.新建dp
     * 3.循环从1，m
     * 4.循环从1.n
     * 5.判断i位置 字符串的i - 1 和j位置 字符串的j - 1是否相等
     * 6.相等 dp[i][j] = dp[i - 1][j - 1] + 1
     * 7.不等 dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
     * 8.最后得到dp[m][n];
     * @param text1
     * @param text2
     * @return
     */
    public int longCommonSubsequence(String text1,String text2){
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n ; j++) {
                if(text1.charAt(i - 1)==text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

}
