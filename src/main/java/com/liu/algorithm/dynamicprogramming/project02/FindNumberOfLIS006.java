package com.liu.algorithm.dynamicprogramming.project02;

/**
 * @author liu
 */
public class FindNumberOfLIS006 {

    public int findNumberOfLIS(int[] nums){
        int len = nums.length,maxlen = 0,ans = 0;
        int[] dp = new int[len];
        int[] cnt = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[i] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if(dp[i] > maxlen){
                maxlen = dp[i];
                ans = cnt[i];
            } else if (dp[i] == maxlen) {
                ans += cnt[i];
            }
        }

        return ans;
    }
}
