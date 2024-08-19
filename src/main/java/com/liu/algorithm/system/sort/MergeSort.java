package com.liu.algorithm.system.sort;

public class MergeSort {

    public void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public void merge(int[] arr, int left, int mid, int right) {

    }
}
