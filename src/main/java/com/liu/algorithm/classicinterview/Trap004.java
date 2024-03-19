package com.liu.algorithm.classicinterview;

/**
 * @author liu
 */
public class Trap004 {
    public int trap(int[] height){
        int ans = 0;
        int len = height.length;
        if(len < 3){
            return 0;
        }
        int left_max_arr[] = new int[len - 1];
        int right_max_arr[] = new int[len - 1];
         left_max_arr[0] = height[0];
         right_max_arr[0] = height[len - 1];
        for (int i = 1; i < len; i++) {
            left_max_arr[i] = Math.max(left_max_arr[i - 1],height[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            right_max_arr[i] = Math.max(right_max_arr[i + 1],height[i]);
        }
        for (int i = 0; i < len; i++) {
            ans += Math.min(left_max_arr[i],right_max_arr[i]) - height[i];
        }
        return ans;
    }
}
