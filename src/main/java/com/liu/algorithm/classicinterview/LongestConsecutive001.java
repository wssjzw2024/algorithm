package com.liu.algorithm.classicinterview;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liu
 */
public class LongestConsecutive001 {

    public int longestConsecutive(int[] nums){
        Set<Integer> num_set = new HashSet<>();
        for (int num:nums){
            num_set.add(num);
        }
        int longestStreak  = 1;
        for (int num:nums){
            if(!num_set.contains(num - 1)){
                int curNum = num;
                int curStreak = 1;
                while (num_set.contains(curNum + 1)){
                    curNum++;
                    curStreak++;
                }
                longestStreak   = Math.max(longestStreak ,curStreak);
            }
        }
        return longestStreak ;
    }

}
