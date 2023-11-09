package com.liu.algorithm.dynamicprogramming;

/**
 * @author liu
 */
public class MaxProfit001 {
    /**
     * 贪心
     * 思路
     * i天买入，若想达到最大利润，一定选择价格最低的交易日买入
     * 步骤
     * 1.cost为最小成本，初始为Integer.MAX_VALUE
     * 2.profit为最大利润，初始为0;
     * 3.循环数组
     * 4.price小于cost，跟新cost
     * 5.计算propfit 与 price -cost，大于profit，跟新pfofit
     * 6.返回 profit
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices){
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int cost = Integer.MAX_VALUE,profit = 0;
        for(int price:prices) {
            cost = Math.min(cost,price);
            profit = Math.max(profit,price - cost);
        }
        return profit;
    }

    /**
     * 动态规划
     * 思路
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
     * 6、dp[i][1] = Math.max(dp[i - 1][1],- prices[i])
     * 7.dp[0][0] = 0;
     * 8.dp[0][1] = -prices[0];
     * 9最后结果 dp[length - 1][0]
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices){
        int length = prices.length;
        if (length < 2) {
            return 0;
        }

        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(- prices[i],dp[i - 1][1]);
        }
        return dp[length - 1][0];
    }

    /**
     * 动态规划(空间优化)
     * 思路
     * 空间优化只看状态转移方程
     *  步骤
     *  1. 设置一维数组
     *  2. dp[0] 表示 卖出，最大利润，初始值为0
     *  3. dp[1] 表示 买入，最大利润，初始值为-prices[0]
     *  4.循环，
     *  5.卖出的最大利润，在于前1天买入利润+当天价格与卖出最大利润的最大值
     *  6.买入的最大利润，在于前1天买人利润与当天价格负值
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices){
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = -prices[0];
        for (int i = 0; i < len; i++) {
            dp[0] = Math.max(dp[0],dp[1] + prices[i]);
            dp[1] = Math.max(dp[1],- prices[i]);
        }
        return dp[0];
    }
}
