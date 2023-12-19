package com.liu.algorithm.dynamicprogramming.project01;

/**
 * @author liu
 */
public class GetMoneyAmount003 {
    /**
     * 区间dp
     * 思路
     * 用 f(i,j)表示在范围 [i,j]内确保胜利的最少金额，目标是计算 f(1,n)
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

    /**
     * 记忆化搜索
     * 思路
     * 比较容易想到的做法为使用「递归」进行求解。
     * 设计递归函数为 int dfs(int l, int r) 传入参数 l 和 r 代表在范围 [l,r][l, r][l,r] 内进行猜数，返回值为在 [l,r][l, r][l,r] 内猜中数字至少需要多少钱。
     * 步骤
     * 1.判断边界
     * 2.查看缓存是否存在
     * 3.ans最大值
     * 4.i从l到r
     * 5.当前值 去l到i - 1 与 i + 1到r中最大值与i的和
     * 6.ans 等于 ans与cur的最小值
     * @param n
     * @return
     */
    public int getMoneyAmount1(int n){
        int[][] cache = new int[n + 1][n + 1];
        return dfs(1,n,cache);
    }

    private int dfs(int l,int r,int[][] cache){
        if(l >= r){
            return 0;
        }
        if(cache[l][r] != 0){
            return cache[l][r];
        }
        int ans = Integer.MAX_VALUE;
        for(int i = l; i <= r; i++){
            int cur = Math.max(dfs(l,i - 1,cache),dfs(i + 1,r,cache)) + i;
            ans = Math.min(ans,cur);
        }
        cache[l][r] = ans;
        return ans;
    }
}
