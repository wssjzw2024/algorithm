package com.liu.algorithm.dynamicprogramming;

/**
 * @author liu
 */
public class GetMoneyAmount007 {
    /**
     * 动态规划
     * 思路
     * 用 f(i,j)f(i, j)f(i,j) 表示在范围 [i,j][i, j][i,j] 内确保胜利的最少金额，目标是计算 f(1,n)f(1, n)f(1,n)
     * f(1,n)=x+max(f(1,x−1),f(x+1,n))。
     * 步骤
     * 1. i位置从 n-1开始 ，到等于1结束
     * 2. j位置 从 i + 1开始，到等于n结束
     * 3.为了不过解 f[i][j] = j + f[i][j -1];
     * 4.k从 i开始，小于j结束
     * 5.f[i][j] = Math.min(f[i][j],k + Math.max(f[i][k - 1],f[i][k + 1]));
     * @param n
     * @return
     */
    public int getMoneyAmount(int n){
        int[][] f = new int[n + 1][n + 1];
        for (int i = n - 1; i > 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                f[i][j] = j + f[i][j - 1];
                for (int k = i; k < j; k++) {
                    f[i][j] = Math.min(f[i][j],k + Math.max(f[i][k - 1],f[i][k + 1]));
                }
            }
        }
        return f[1][n];
    }
}
