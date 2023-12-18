package com.liu.algorithm.dynamicprogramming.project01;

/**
 * @author liu
 */
public class Tribonacci002 {
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

    /**
     * 矩阵快速幂
     * 思路
     * 矩阵快速幂用于求解一般性问题：给定大小为 n∗n的矩阵 M，求答案矩阵 M的
     * k次方，并对答案矩阵中的每位元素对 P取模。
     * 步骤
     * 1。0，1,2 默认值
     * 2.
     *
     * @param n
     * @return
     */
    public int tribonacci1(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2) {
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
        while(k != 0){
            if((k & 1)!= 0){
                ans = mul(ans,mat);
            }
            mat = mul(mat,mat);
            k >>= 1;
        }
        return ans[0][0] + ans[0][1];
    }

    int N = 3;
    public int[][] mul(int[][] a,int[][] b){
        int[][] c = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j] + a[i][2] * b[2][j];
            }
        }
        return c;
    }
}
