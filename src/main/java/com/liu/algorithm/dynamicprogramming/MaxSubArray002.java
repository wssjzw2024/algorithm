package com.liu.algorithm.dynamicprogramming;

/**
 * @author liu
 */
public class MaxSubArray002 {
    /**
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums){
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < length; i++){
            dp[i] = nums[i] + Math.max(dp[i - 1],0);
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
