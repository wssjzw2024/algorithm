package com.liu.algorithm.system.dynamicprogramming.project03;

/**
 * @author liu
 */
public class MaxSubArray002 {
    /**
     * 动态规划
     * 思路
     *  dp[i]表示以num[i]结尾的最大连续数组的值
     * 步骤
     *  1.获取数组长度
     *  2.初始化数组,max、dp[0]
     *  3.循环
     *  4.当 dp[i - 1] 大于 0 dp[i] = dp[i - 1] + nums[i];
     *  5.当 dp[i - 1] 小于0 dp[i] = nums[i];
     *  6.比较 max与 dp[i];
     *  7.返回max
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums){
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            if(dp[i - 1] > 0){
                dp[i] = dp[i - 1] + nums[i];
            }else {
                dp[i] = nums[i];
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
