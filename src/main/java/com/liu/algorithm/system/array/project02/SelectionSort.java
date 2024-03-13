package com.liu.algorithm.system.array.project02;

/**
 * @author liu
 */
public class SelectionSort {
    /**
     * 选择排序
     * 思路
     *  每次从中选小值
     * 步骤
     *  1.从前往后选出最小
     *  2.将最小值放到首位
     *  3.循环将再选到的最小值放到合适位置
     * @param nums
     */
    public void sort(int[] nums){
        int len = nums.length;
        for(int i = 0; i < len; i++){
            int minIndex = i;
            for (int j = i; j < len; j++) {
                if(nums[j] > nums[minIndex]){
                    minIndex = j;
                }
            }
            swap(nums,i,minIndex);
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
