package com.liu.algorithm.classic150;

import java.util.Arrays;

public class MajorElement005 {
    /**
     * 排序
     * 步骤
     * 1.数组排序
     * 2.获取中间下标的值
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
