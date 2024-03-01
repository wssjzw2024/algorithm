package com.liu.algorithm.array.project02;

/**
 * @author liu
 */
public class QuickSort {
    /**
     * 快速排序
     * 思路
     *  采用经典的分治策略
     * 步骤
     * 1.划分
     * 2.递归分解
     * @param nums
     */
    public void sort(int[] nums){
        int len = nums.length;
        quickSort(nums,0,len -1);
    }

    public void quickSort(int[] nums,int low,int high){
        if(low < high){
            int pivot = partition(nums,low,high);
            quickSort(nums,low,pivot - 1);
            quickSort(nums,pivot + 1,high);
        }
    }

    public int partition(int[] nums,int low,int high){
        int pivot = nums[low];
        int i = low,j = high;
        while (i < j){
            while (i < j && nums[i] < pivot){
                i++;
            }
            while (i < j && nums[j] >= pivot){
                j--;
            }
            swap(nums,i,j);
        }
        swap(nums,low,i);
        return i;
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
