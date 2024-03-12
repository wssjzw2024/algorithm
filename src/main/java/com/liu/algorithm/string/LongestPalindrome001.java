package com.liu.algorithm.string;

/**
 * @author liu
 */
public class LongestPalindrome001 {

    public String longestPalindeome(String s){
        if(s == null || s.length()==0){
            return s;
        }
        int len = s.length();
        int left = 0;
        int right = 0;
        int max = 1;
        int start = 0;

        char[] chars = s.toCharArray();
        for (int i = 0; i < len-(max/2); i++) {
            left = i - 1;
            right = i + 1;
            int nowlen = 1;
            while (left >= 0 && chars[left] == chars[right]){
                left--;
                nowlen++;
            }
            while (right < len && chars[left] == chars[right]){
                right++;
                nowlen++;
            }
            while (left >= 0 && right < len && chars[left] == chars[right]){
                left--;
                right++;
                nowlen+=2;
            }
            if(nowlen > max){
                max = nowlen;
                start = left;
            }
        }
        return s.substring(start + 1,start + max + 1);
    }
}
