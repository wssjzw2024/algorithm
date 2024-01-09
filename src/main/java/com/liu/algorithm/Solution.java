package com.liu.algorithm;

/**
 * @author liu
 */
public class Solution {

    public static int count = 0;

    public int findTargetSumWay(int[] nums,int target) {
        backtrack(nums,target,0,0);
        return count;
    }

    public void backtrack(int[] nums,int target,int index,int sum){
        if(index == nums.length){
            if(target == sum){
                count++;
            }
        }
        backtrack(nums,target,index + 1,sum + nums[index]);
        backtrack(nums,target,index + 1,sum - nums[index]);
    }

    public int findTargetSumWay1(int[] nums,int target) {
        int len = nums.length;
        int sum = 0;
        for(int num:nums){
            sum += num;
        }
        int diff = sum - target;
        if(diff < 0 || diff % 2 != 0){
            return 0;
        }
        int neg = diff / 2;
        int[][] dp = new int[len + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg ; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j > num){
                    dp[i][j] += dp[i][j - num];
                }
            }
        }
        return dp[len][neg];
    }
}
