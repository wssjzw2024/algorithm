package com.liu.algorithm.dynamicprogramming;

/**
 * @author liu
 */
public class FindTargetSumWayS001 {


    /**
     * 递归
     * 思路
     * 当最后一个位置，和等于target，返回1，不是返回0
     * 不是最后一个，可以添加 + 和 - 两种情况
     * 步骤
     * 1、递归方法
     * 2.当最后一个位置，和等于target，返回1，不是返回0
     * 3.不是最后。添加+的情况 加上 添加 - 的情况
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums,int target){
        return process(nums,0,target,0);
    }

    private int process(int[] nums,int index,int target,int sum){
        if(index == nums.length){
            if(target == sum){
                return 1;
            }else {
                return 0;
            }
        }
        return process(nums,index + 1,target,sum + nums[index])
            +process(nums,index + 1,target,sum - nums[index]);
    }

    public int findTargetSumWays1(int[] nums,int target){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int diff = sum - target;
        if(diff < 0 || diff % 2 != 0){
            return 0;
        }
        int n = nums.length,neg = diff/2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j < neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j >= num){
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][neg];
    }
}
