package com.liu.algorithm.array.project02;

/**
 * @author liu
 */
public class InsertionSort {
    /**
     * 插入拍讯
     * 思路
     *  插入排序区，
     * @param nums
     */
    public void sort(int[] nums){
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                swap(nums,j,j - 1);
            }
        }
    }


    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
