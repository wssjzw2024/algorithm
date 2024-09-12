package com.liu.algorithm.classic150;

public class RemoveElement002 {
    /**
     * 双指针
     * 步骤
     * 1.左指针left为0，右指针right为长度
     * 2.循环 条件 left < right
     *   循环体
     *   当左指针下标的数等于val，将右指针减1的数赋值左指针下标的数，右指针减减
     *   否则 左指针加加
     * 3.返回 指针
     *
     * @param nums
     * @param val
     * @return
     */
    public  int remoceElement(int[] nums,int val){
        int left = 0,right = nums.length;
        while (left < right){
            if(nums[left]==val){
                nums[left] = nums[right - 1];
                right--;
            }else {
                left++;
            }
        }
        return left;
    }

    /**
     * 拷贝覆盖
     * 步骤
     * 1.初始化下标为0
     * 2.循环数组
     *   循环体
     *   判断当前值是否等于val，不等于，将当前值赋值，下标自增
     *  3.返回下标
     * @param nums
     * @param val
     * @return
     */
    public  int remoceElement1(int[] nums,int val){
        int index = 0;
        for(int num:nums){
            if(num != val){
                nums[index++] = num;
            }
        }
        return index;
    }
}
