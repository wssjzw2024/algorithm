package com.liu.algorithm.dynamicprogramming;

/**
 * @author liu
 */
public class MaxSubArray002 {
    /**
     * 动态规划
     * 思路
     * 设置数组，dp[i]表示以num[i]结尾的最大值
     * 步骤
     * 1.获取数组长度
     * 2.新建数组
     * 3.dp[0] = nums[0]
     * 4.设置最大值num[0]
     * 5.循环，dp[i]等于num[i],加上dp[i - 1]与0的最大值
     * 6 max等于 max与dp[i]的最大值
     * 7.返回最大值
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

    /**
     * 分治法
     * 思路
     * 分类讨论，[left,mid],[mid + 1,right],包含子区间[mid ，mid + 1]
     * 步骤
     * 1。maxSubArraySum,当left==right，返回nums[left],
     * 2.不然，返回 [left,mid],[mid + 1,right],包含子区间[mid ，mid + 1]
     * 3.这三部分的最大值，
     * 4.[left,mid],[mid + 1,right] 这两部分继续递归
     * 5.maxCrossingSum计算包含子区间[mid ，mid + 1]的最值
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums){
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        return maxSubArraySum(nums,0,len -1);
    }

    private int maxCrossingSum(int[] nums,int left,int mid,int right){
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        for (int i = mid; i >=left; i--) {
            sum += nums[i];
            if(sum > leftSum){
                leftSum = sum;
            }
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right ; i++) {
            sum +=nums[i];
            if(sum > rightSum){
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }

    private int maxSubArraySum(int[] nums,int left,int right){
        if(left == right){
            return nums[left];
        }
        int mid = left + (right - left)/2;
        return max3(maxSubArraySum(nums,left,mid),
            maxSubArraySum(nums,mid + 1,right),
            maxCrossingSum(nums,left,mid,right));
    }

    private int max3(int num1,int num2,int num3){
        return Math.max(num1,Math.max(num2,num3));
    }

}
