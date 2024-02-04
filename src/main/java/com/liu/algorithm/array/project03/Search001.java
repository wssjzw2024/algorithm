package com.liu.algorithm.array.project03;

/**
 * @author liu
 */
public class Search001 {
    public int search(int[] nums,int target){
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid = 0;
        while (left <= right){
            mid = (left + right) / 2;
            if(target == nums[mid]){
                return mid;
            }else if(target < nums[mid]){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
