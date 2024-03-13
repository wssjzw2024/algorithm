package com.liu.algorithm.system.array.project02;

/**
 * @author liu
 */
public class ShellSort {

    /**
     * 希尔排序
     * 思路
     *  分组然后使用插入排序
     * 步骤
     *  1.以长度分组，每次减半
     *  2.外层控制分组
     *  3.内层插入排序
     * @param nums
     */
    public void sort(int[] nums){
        int len = nums.length;
        int gap = len / 2;

        while (gap >0){
            for (int i = gap; i < len; i++) {
                for (int j = i; j >= gap&& nums[j - gap] >nums[j] ; j-=gap) {
                    swap(nums,j - gap,j);
                }
            }
            gap /= 2;
        }

    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
