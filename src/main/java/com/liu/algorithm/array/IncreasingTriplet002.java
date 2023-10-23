package com.liu.algorithm.array;

/**
 * @author liu
 */
public class IncreasingTriplet002 {

    public boolean increasingTriplet1(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= min){
                min = nums[i];
            }else if(nums[i] <= secondMin){
                secondMin = nums[i];
            }else {
                return true;
            }
        }
        return false;
    }

}
