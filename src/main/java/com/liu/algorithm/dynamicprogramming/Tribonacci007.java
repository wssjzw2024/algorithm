package com.liu.algorithm.dynamicprogramming;

/**
 * @author liu
 */
public class Tribonacci007 {
    /**
     * 动态规划
     * 思路
     * 状态转移方程 dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
     * 步骤
     * 1.判断边界
     * 2.初始值
     * 3.循环，状态转移
     * 4.返回结果
     * @param n
     * @return
     */
    public int tribonacci(int n){
        if(n < 1){
            return 0;
        }
        if(n <3){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    public int tribonacci1(int n){
        return 0;
    }
}
