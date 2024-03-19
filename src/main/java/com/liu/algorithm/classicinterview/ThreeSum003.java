package com.liu.algorithm.classicinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liu
 */
public class ThreeSum003 {
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if(nums[i] == nums[i+1]){
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right){
                if(nums[i] + nums[left] + nums[right] > 0){
                    right--;
                }else if(nums[i] + nums[left] + nums[right] < 0){
                    left++;
                }else {
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}
