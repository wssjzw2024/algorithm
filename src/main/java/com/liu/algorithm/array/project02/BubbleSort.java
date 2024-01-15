package com.liu.algorithm.array.project02;

/**
 * @author liu
 */
public class BubbleSort {

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
