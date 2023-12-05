package com.liu.algorithm.dynamicprogramming.project02;

/**
 * @author liu
 */
public class LengthOfLIS001 {

    /**
     * 动态规划
     * 思路
     * 定义 dp[i] 为考虑前 i 个元素，以第 i 个数字结尾的最长上升子序列的长度，注意 nums[i] 必须被选取。
     * dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]
     * 步骤
     * 1.获取数组长度
     * 2.新建dp数组
     * 3.循环，dp[i] 初始值 1
     * 4.循环 0到i
     * 5.判断nums[i] > nums[j];
     * 6. dp[i] = Math.max(dp[i],dp[j] + 1);
     * 7.max = Math.max(max,dp[i]);
     * @param nums
     * @return
     */
    public  int lengthOfLIS(int[] nums){
        int len = nums.length;
        int max = 1;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
