package com.liu.algorithm.classic150;

import java.util.Arrays;

public class Merge001 {
    /**
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public  void merge(int[] nums1,int m,int[] nums2,int n){
        int i = 0,j = 0,k = 0;
        int[] temp = new int[m+n];
        while (i < m && j < n){
            if(nums1[i]< nums2[j]){
                temp[k++] = nums1[i++];
            }else {
                temp[k++] = nums2[j++];
            }
        }
        while (i < m){
            temp[k++] = nums1[i++];
        }
        while (j < n){
            temp[k++] = nums2[j++];
        }
        for (int l = 0; l < temp.length; l++) {
            nums1[i] = temp[i];
        }
    }

    /**
     * 合并再排序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1,int m,int[] nums2,int n){
        for (int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public void merge2(int[] nums1,int m,int[] nums2,int n){
        int p1 = m-1,p2 = n - 1,index = m + n -1;
        while (p1 >= 0 && p2 >= 0){
            if(nums1[p1] > nums2[p2]){
                nums1[index--] = nums1[p1--];
            }else {
                nums1[index--] = nums2[p2--];
            }
        }
        while (p1 >= 0){
            nums1[index--] = nums1[p1--];
        }

        while (p2 >= 0){
            nums1[index--] = nums2[p2--];
        }
    }
}
