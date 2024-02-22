package com.liu.algorithm.dynamicprogramming.project01;

/**
 * @author liu
 */
public class Fib001 {
    /**
     * 动态规划
     * 思路
     *  f(n) = f(n - 1) + f(n - 2)
     * 步骤
     *  1.判断边界
     *  2.初始边界值
     *  3.循环求值
     *  4.返回结果
     * @param n
     * @return
     */
    public int fib(int n){
        if(n <= 1){
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <=n ; i++) {
            dp[i] = dp[i - 1] + dp[i -2];
        }
        return dp[n];
    }
}
