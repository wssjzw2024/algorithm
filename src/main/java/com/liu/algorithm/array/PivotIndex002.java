package com.liu.algorithm.array;

/**
 * @author liu
 */
public class PivotIndex002 {
    /**
     * 前缀和
     * 思路
     * 记数组之和sum，当遍历到i个元素
     * 左侧之和leftsum。右侧之和sum - leftsum - nums[i]
     * 左右相等 leftsum = sum - leftsum - nums[i]
     * 2 * leftsum + nums[i] = sum;
     * 步骤
     * 1.循环累加数组 等于sum
     * 2.设置左侧等于leftSum
     * 3.循环 判断2 * leftsum + nums[i] = sum 是否成立
     * 4.成立返回 i;
     * 5.leftSum 累计nums[i]
     * 6.循环结束，没结束，返回 -1
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums){
        int sum = 0;
        for(int num:nums){
            sum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(2 * leftSum + nums[i] == sum){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
