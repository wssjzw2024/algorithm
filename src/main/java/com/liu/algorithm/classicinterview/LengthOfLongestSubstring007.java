package com.liu.algorithm.classicinterview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu
 */
public class LengthOfLongestSubstring007 {

    public int lengOfLongestSubstring(String s){
        Map<Character ,Integer> position = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if(position.containsKey(s.charAt(i))){
                left  = Math.max(left,position.get(s.charAt(i))+1);
            }
            position.put(s.charAt(i),i);
            max = Math.max(max,i - left + 1);
        }
        return max;
    }
}
