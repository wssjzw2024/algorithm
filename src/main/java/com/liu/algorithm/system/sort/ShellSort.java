package com.liu.algorithm.system.sort;

public class ShellSort {

    public  void sort(int[] arr) {
        int len = arr.length;
        // 分组 最初是长度一半，到最后为1
        for (int gap = len / 2; gap > 0; gap /= 2) {
            // 从gap开始，到len
            for (int i = gap; i < len; i++) {
                //组中，和前面一个比较
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
