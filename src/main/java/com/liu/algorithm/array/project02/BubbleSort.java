package com.liu.algorithm.array.project02;

/**
 * @author liu
 */
public class BubbleSort {

    /**
     * 冒泡排序
     * 思路
     *  相互比较
     * 步骤
     *  1.从len个数拍讯
     *  2.从前向后，两两比较
     *  3.将最大值排到最后
     *  4.循环直到所有的有序
     * @param nums
     */
    public void sort(int[] nums){
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if(nums[j - 1]>nums[j]){
                    swap(nums, j - 1,j);
                }
            }
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
