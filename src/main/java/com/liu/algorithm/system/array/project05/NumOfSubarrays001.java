package com.liu.algorithm.system.array.project05;

/**
 * @author liu
 */
public class NumOfSubarrays001 {

    /**
     * 滑动窗口
     * 思路
     *  left right控制窗口大小
     * 步骤
     * 1.初始记录数，left，right
     * 2.循环right < arr.length
     * 3.right - left 控制窗口大小 ，right++
     * 4.判断窗口内的数据，记录数增加
     * 5.left ++
     * 6.返回记录数
     * @param arr
     * @param k
     * @param threshold
     * @return
     */
    public   int numOfSubarrays(int[] arr,int k,int threshold){
        int count = 0;
        int left = 0,right = 0;
        while (right < arr.length){
            while (right - left < k - 1 && right < arr.length){
                right++;
            }
            int sum = 0;
            if(right != arr.length){
                for (int i = left; i <= right ; i++) {
                    sum += arr[i];
                }
                if(sum >= k * threshold){
                    count++;
                }
                left++;
            }
        }
        return count;
    }
}
