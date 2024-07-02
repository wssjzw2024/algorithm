package com.liu.algorithm.system.sort;

/**
 * @author liu
 */
public class InsertionSort {
    public void sort(int[] arr) {
        /*
         * 2-n
         * 3-n
         */
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j-1]; j--) {
                swap(arr, j, j-1);
            }
        }
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
