package com.liu.algorithm.system.sort;

/**
 * @author liu
 */
public class BubbleSort {

    public void sort(int[] arr){
        if(arr == null || arr.length < 2)
            return;
        int len = arr.length;
        /*
         * 外层
         * 从1到 你-1
         */
        for(int i = len - 1; i > 0; i--){
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
