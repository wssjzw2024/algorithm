package com.liu.algorithm.system.sort;

/**
 * @author liu
 */
public class BubbleSort implements Sort{

    public void sort(int[] arr){
        if(arr == null || arr.length < 2)
            return;
        int len = arr.length;
        /*
         *
         * 从1到 n 范围
         * 从1到n - 1范围
         */
        for(int i = len - 1; i > 0; i--){
            /*
             * 两两比较，前边比后边大 交换
             */
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
