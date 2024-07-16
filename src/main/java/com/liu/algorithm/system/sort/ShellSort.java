package com.liu.algorithm.system.sort;

public class ShellSort {

    public  void sort(int[] arr) {
        int len = arr.length;
        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < len; i++) {
                for (int j = i - gap; j >= 0 && arr[j] < arr[j -gap]; j -= gap) {
                        swap(arr, j, j - gap);
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
