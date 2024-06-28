package com.liu.algorithm.system.sort;

/**
 * @author liu
 */
public class SelectionSort {

    public void sort(int[] arr) {
        if(arr == null || arr.length < 2)
            return;
        int len = arr.length;
        /*
         * 从 1到n选择
         * 从2到n选择
         */
        for(int i = 0; i < len; i++) {
            int min = i;
            /*
             * 选出最小值
             * 默认当前最小，后面位置和最小位置比较，小于，将位置值赋值最小值
             */
            for(int j = i + 1; j < len; j++) {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
