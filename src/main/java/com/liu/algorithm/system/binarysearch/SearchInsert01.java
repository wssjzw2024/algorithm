package com.liu.algorithm.system.binarysearch;

public class SearchInsert01 {

    /**
     * 闭区间
     * 步骤
     * 1.初始化左边界left为0，右边界为nums.length - 1;
     * 2.循环 条件 left<=right
     *   循环体
     *   获取中点 middle = left + (right - left)/2;
     *   当nums[middle]小于target，left赋值middle + 1
     *   否则 left赋值middle - 1
     * 3.返回left
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0,right = nums.length - 1;
        while (left <= right){
            int middle = left + (right - left)/2;
            if (nums[middle] < target) {
                left = middle + 1;
            }else {
                right = middle - 1;
            }
        }
        return left;
    }

    /**
     * 左闭右开
     * 步骤
     * 1.初始化左边界left为0，右边界为nums.length;
     * 2.循环 条件 left<right
     *   循环体
     *   获取中点 middle = left + (right - left)/2;
     *   当nums[middle]小于target，left赋值middle + 1
     *   否则 left赋值middle
     * 3.返回left
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert1(int[] nums,int target){
        int left = 0,right = nums.length;
        while (left < right){
            int middle = left + (right - left)/2;
            if(nums[middle] < left){
                left = middle + 1;
            }else {
                right = middle;
            }
        }
        return left;
    }

    /**
     * 左开右开
     * 步骤
     * 1.初始化左边界left为-1，右边界为nums.length;
     * 2.循环 条件 left+ 1<right
     *   循环体
     *   获取中点 middle = left + (right - left)/2;
     *   当nums[middle]小于target，left赋值middle
     *   否则 left赋值middle
     * 3.返回left
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert2(int[] nums,int target){
        int left = -1,right = nums.length;
        while (left + 1 < right){
            int middle = left + (right - left)/2;
            if(nums[middle] < target){
                left = middle;
            }else {
                right = middle;
            }
        }
        return left;
    }
}
