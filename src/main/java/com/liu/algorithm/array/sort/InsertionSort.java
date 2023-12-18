package com.liu.algorithm.array.sort;

/**
 * @author liu
 */
public class InsertionSort {

    public void sort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j >= 1 && nums[j] < nums[j - 1]; j--) {
                swap(nums,j,j - 1);
            }
        }
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
