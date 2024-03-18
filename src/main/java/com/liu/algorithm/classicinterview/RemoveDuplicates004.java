package com.liu.algorithm.classicinterview;

/**
 * @author liu
 */
public class RemoveDuplicates004 {
    public int removeDuplicates(int[] nums){
        int len = nums.length;
        if(len < 3){
            return len;
        }
        int fast = 2,slow = 2;
        while (fast < len){
            if(nums[slow - 2] != nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
