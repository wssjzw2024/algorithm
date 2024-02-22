package com.liu.algorithm.dynamicprogramming.project02;

/**
 * @author liu
 */
public class GetMoneyAmount003 {

    /**
     * 动态规划
     *  思路
     *      1.f(i,j) 表示在范围 [i,j]内确保胜利的最少金额
     *      2.f(1,n) = min(x + max(f(1,x-1),f(x + 1,n))) 1<=x<=n
     *      3. i≥j时，f(i,j)=0
     *  步骤
     *      1.初始化 数组
     *      2.循环 i从 n-1开始，到大于0
     *      3.循环 j从 i+ 1开始，到等于n
     *      4.dp[i][j] = j + dp[i][j - 1]
     *      5.循环 从 i到j
     *      6.dp[i][j] = Math.min(dp[i][j],k + Math.max(dp[i][k - 1],dp[k + 1][j]));
     *      7.返回 dp[1][n]
     * @param n
     * @return
     */
    public int getMoneyAmount(int n){
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i > 0 ; i--) {
            for (int j = i + 1; j <=n ; j++) {
                dp[i][j] = j + dp[i][j - 1];
                for (int k = i; k < j ; k++) {
                    dp[i][j] = Math.min(dp[i][j],k + Math.max(dp[i][k - 1],dp[k + 1][j]));
                }
            }
        }
        return dp[1][n];
    }

    static int N = 210;
    static int[][] cache = new int[N][N];

    public int getMoneyAmount1(int n){
        return dfs(1,n);
    }

    /**
     * 记忆化搜索
     *   思路
     *      int dfs(int l, int r) 传入参数 l 和 r 代表在范围 [l,r][l, r][l,r] 内进行猜数
     *   步骤
     *      1.初始化数组
     *      2.计算dfs(l,r)
     *      3.判断边界
     *      4.是否存在cache
     *      5.循环从l到r
     *      6.当前值 cur = Math.max(dfs(l,i - 1),dfs(i + 1,r)) + i;
     *      7.判断值小值 ans，cur
     *      8.存储cache
     *      9.返回 ans
     * @param l
     * @param r
     * @return
     */
    int dfs(int l,int r){
        if(l >= r){
            return 0;
        }
        if(cache[l][r] != 0){
            return cache[l][r];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = l; i <= r ; i++) {
            int cur = Math.max(dfs(l,i - 1),dfs(i + 1,r)) + i;
            ans = Math.max(ans,cur);
        }
        cache[l][r] = ans;
        return ans;
    }
}
