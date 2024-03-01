package com.liu.algorithm.array.project02;

/**
 * @author liu
 */
public class MergeSort {


    /**
     * 归并排序
     * 思路
     *  分解、合并
     * 步骤
     *  1.递归将数组分解
     *  2.两两合并
     * @param nums
     */
    public void sort(int[] nums){
        int len = nums.length;
        int[] temp = new int[len];
        mergeSort(nums,temp,0,len - 1);
    }

    public void mergeSort(int[] arr,int[] temp,int left,int right){
        if(left < right){
            int mid = (left +right) / 2;
            mergeSort(arr, temp, left, mid);
            mergeSort(arr,temp,mid + 1,right);
            merge(arr,temp,left,mid,right);
        }
    }

    public void merge(int[] arr,int[] temp,int left,int right,int mid){
        int i = 0;
        int m = left;
        int n = mid + 1;

        while (m <= mid && n <= right){
            if(arr[m] < arr[n]){
                temp[i++] = arr[m++];
            }else {
                temp[i++] = arr[n++];
            }
        }
        while (m <= mid){
            temp[i++] = arr[m++];
        }
        while (n <= right){
            temp[i++] = arr[n++];
        }
        for (int j = 0; j < i; j++) {
            arr[left + j] = temp[j];
        }
    }


}
