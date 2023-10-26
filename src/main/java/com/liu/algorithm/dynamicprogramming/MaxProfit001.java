package com.liu.algorithm.dynamicprogramming;

/**
 * @author liu
 */
public class MaxProfit001 {

    public int maxprofit1(int[] prices){
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i -1 ]< prices[i]){
                max += prices[i] = prices[i - 1];
            }
        }
        return max;
    }

    /**
     * 胴体规划
     * 1.确定状态
     * 2.找到转移公式
     * 3.确定初始条件以及边界条件
     * 4.计算结果
     * 步骤
     * 1.定义一个二维数据 dp[length][2]
     * 2.dp[i][0] 表示 i+1（i从0开始）天结束时没有持有股票的最大利润
     * 3.dp[i][1]表示 i+1（i从0开始）天结束时持有股票的最大利润
     * 4.i+1天结束时没有持有。i天结束时没有，或者i天结束持有，i+1天卖出
     * dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i])
     * 5.i+1天结束式持有，i天结束时没有，i + 1 天买入，i天结束持有
     * 6、dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] - prices[i])
     * 7.dp[0][0] = 0;
     * 8.dp[0][1] = -prices[0];
     * 9最后结果 dp[length - 1][0]
     * @param prices
     * @return
     */
    public int maxprofit2(int[] prices){
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(- prices[i],dp[i - 1][1]);
        }
        return dp[length - 1][0];
    }
}
