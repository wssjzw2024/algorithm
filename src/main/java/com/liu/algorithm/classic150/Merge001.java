package com.liu.algorithm.classic150;

import java.util.Arrays;

public class Merge001 {
    /**
     * 正向双指针
     * 步骤
     * 1.初始化指针p1，指针p2 为0
     * 2.初始化下标index为 0
     * 3.新建数组temp，长度为m+n
     * 4.循环，条件p1小于m，且
     * 5.循环体
     *   当nums1[p1] 小于 nums2[p2]
     *   将nums1[p1]赋值temp[index]
     *   p1,index 自加加
     *   否则
     *   将nums2[p2]赋值temp[index]
     *   p2,index 自加加
     * 6.循环 条件p1小于m
     *   循环体
     *   将nums1[p1]赋值temp[index],
     *   p1,index 自加加
     * 7.循环 条件p2小于n
     *   循环体
     *   将nums2[p2]赋值temp[index]
     *   p1,index 自加加
     * 8.循环，将temp数组赋值nums1.
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public  void merge(int[] nums1,int m,int[] nums2,int n){
        int p1 = 0,p2 = 0,index = 0;
        int[] temp = new int[m+n];
        while (p1 < m && p2 < n){
            if(nums1[p1]< nums2[p2]){
                temp[index++] = nums1[p1++];
            }else {
                temp[index++] = nums2[p2++];
            }
        }
        while (p1 < m){
            temp[index++] = nums1[p1++];
        }
        while (p2 < n){
            temp[index++] = nums2[p2++];
        }
        for (int l = 0; l < temp.length; l++) {
            nums1[p1] = temp[p1];
        }
    }

    /**
     * 合并再排序
     * 步骤
     * 1.将nums2依次复制nums2的结尾
     * 2.将nums1排序
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

    /**
     * 逆向双指针
     * 步骤
     * 1.初始化指针p1为m-1,指针p2为n-1
     * 2，初始化下标index为m+n-1
     * 3.循环，条件 p1大于等于0且p2大于等于0
     *   循环体
     *   当nums[p1] 大于nums2[p2]
     *   将nums1[p1]赋值nums[index]
     *   p1,index 减减
     *   否则
     *   将nums2[p2]赋值nums[index]
     *   p2,index 减减
     * 4.循环，条件 p1大于等于0
     *   循环体
     *   将nums1[p1]赋值nums[index]
     *   p1,index 减减
     * 5.循环，条件 p2大于等于0
     *   循环体
     *   将nums2[p2]赋值nums[index]
     *   p2,index 减减
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
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
