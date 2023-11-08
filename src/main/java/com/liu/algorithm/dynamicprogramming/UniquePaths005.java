package com.liu.algorithm.dynamicprogramming;

/**
 * @author liu
 */
public class UniquePaths005 {
    /**
     * 动态规划
     * 思路
     * 空间顺序 、状态转移、初始条件和边界条件
     * 步骤
     * 1. 新建数组
     * 2. 确定初始条件，
     * 3.确定状态转移方程
     * 4.返回结果
     * @param m
     * @param n
     * @return
     */
    public int uniquepaths(int m,int n){
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j-1];
            }
        }
        return dp[m - 1][n - 1];
    }

}
