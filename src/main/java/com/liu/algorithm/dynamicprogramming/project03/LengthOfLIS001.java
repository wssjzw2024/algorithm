package com.liu.algorithm.dynamicprogramming.project03;

/**
 * @author liu
 */
public class LengthOfLIS001 {

    /**
     * 动态规划
     * 思路
     *  dp[i],i个数字结尾的最长上升的长度
     *  dp[i] = max(dp[j]) + 1,nums[j] < nums[i]
     * 步骤
     * 1.获取数组长度
     * 2.初始化max dp[]
     * 3.循环dp[i]默认1
     * 4.循环i到j
     * 5.dp[i] = Math.max(dp[i],dp[j] + 1);nums[j] < nums[i]
     * 6.返回dp[len - 1]
     * @param nums
     * @return
     */
    public int lengthLIS(int[] nums){
        int len = nums.length;
        int max = 1;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }
        return dp[len - 1];
    }

}
