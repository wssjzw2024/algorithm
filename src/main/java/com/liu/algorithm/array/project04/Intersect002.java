package com.liu.algorithm.array.project04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liu
 */
public class Intersect002 {
    /**
     * 分离指针+排序
     * 思路
     *  排序，然后通过指针比较
     * 步骤
     * 1.初始化list
     * 2.排序数组
     * 3.设置指针left1，left2
     * 4.指针小于数组长度
     * 5.比较数据，相等记录 然后自增
     * 6.将list转为数组
     * @param nums1
     * @param nums2
     * @return
     */
    public  int[] intersect(int[] nums1,int[] nums2){
        List<Integer> list = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int left1 = 0;
        int left2 = 0;
        while (left1 < len1 && left2 < len2){
            if(nums1[left1] < nums2[left2]){
                left1++;
            }else if(nums1[left1] > nums2[left2]){
                left2++;
            }else {
                list.add(nums1[left1]);
                left1++;
                left2++;
            }
        }
        int[] arrray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arrray[i] = list.get(i);
        }
        return arrray;
    }

    public  int[] intersect1(int[] nums1,int[] nums2){
        return null;
    }
}
