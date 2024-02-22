package com.liu.algorithm.dynamicprogramming.project02;

/**
 * @author liu
 */
public class Tribonacci002 {
    /**
     * 动态规划
     * 思路
     *      dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
     * 步骤
     *  1.判断边界
     *  2.初始化数组
     *  3.初始化值
     *  4.循环 获取值
     *  5.返回 dp[n];
     * @param n
     * @return
     */
    public int tribonacci(int n){
        if(n < 1){
            return 0;
        }
        if(n < 3){
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

    int N = 3;
    int[][] mul(int[][]a,int[][] b){
        int[][] c = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j] + a[i][2] * b[2][j];
            }
        }
        return c;
    }

    /**
     * 矩阵快速幂
     * 思路
     *  快速幂和矩阵乘法
     * 步奏
     *  1.矩阵乘法
     *  2.初始矩阵
     *  3.幂矩阵
     *  4.循环
     *  5.返回
     * @param n
     * @return
     */
    public int tribonacci1(int n){
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[][] ans = new int[][]{
            {1,0,0},
            {0,1,0},
            {0,0,1}
        };
        int[][] mat = new int[][]{
            {1,1,1},
            {1,0,0},
            {0,1,0}
        };
        int k = n - 2;
        while (k != 0){
            if((k & 1) != 0){
                ans = mul(ans,mat);
            }
            mat = mul(mat,mat);
            k >>= 1;
        }
        return ans[0][0] + ans[0][1];
    }
}
