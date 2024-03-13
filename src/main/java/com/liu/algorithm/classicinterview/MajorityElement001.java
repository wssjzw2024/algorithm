package com.liu.algorithm.classicinterview;

/**
 * @author liu
 */
public class MajorityElement001 {

    public int majorityElement(int[] nums){
        int x = 0,votes = 0;
        for(int num:nums){
            if(votes == 0){
                x = num;
            }
            votes += num == x ? 1:-1;
        }
        return x;
    }
}
