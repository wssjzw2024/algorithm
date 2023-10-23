package com.liu.algorithm.String;

/**
 * @author liu
 */
public class LongestPalindrome001 {
    /**
     * 暴力求解
     * 思路
     * 截取所有的字符串，判断是否是回文串，返回最长字符串
     * 步奏
     * 1.判断s的长度是否等于1
     * 2.设置开始位置，最大长度的初始值，
     * 循环初始 开始位置，最大长度
     * 3.外层循环，从那个位置开始
     * 4.内层循环，那个位置结束
     * 5.判断长度是否小于最大长度，小于跳过循环
     * 6.判断字符串是否回文串，
     * 7.是回文串，长度大于最大长度，赋值开始位置，最大长度，不是跳过
     * 8.循环结束
     * 9.截取回文串
     * @param s
     * @return
     */
    public String LongestPalindrome1(String s){
        if(s.length() < 2){
            return s;
        }
        int start = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if(j - i + 1 < maxLength){
                    continue;
                }
                if(isPalindrome(s,i,j)){
                    if(maxLength < j - i + 1) {
                        start = i;
                        maxLength = j - i + 1;
                    }
                }
            }
        }
        return s.substring(start,start+maxLength);
    }

    public boolean isPalindrome(String str,int i,int j){
        while (i < j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 中心扩散法
     * 思路 每个位置作为回文串的中心位置，向两边扩展（遇到相同，自动增加一位）
     * 步奏
     * 1.判断s的长度是否等于1
     * 2.设置开始位置，最大长度的初始值，
     * 循环开始位置i，循环结束条件
     * 3.判断当前位置到结尾长度小于最大长度的二分之一，结束循环
     * 4.当前位置，判断右边相邻，是否相等，相等则加1
     * 5.从上面位置，继续向两边扩，直到最大
     * 6.比较长度是否比先前的大
     * 7.大则，记录开始位置，最大长度
     * 8.继续循环
     * 9.获取回文串
     * @param s
     * @return
     */
    public String LongestPalindrome2(String s){
        if(s.length() < 2){
            return s;
        }
        int start = 0;
        int maxLength = 0;
        int i = 0;
        int length = s.length();
        while (i < length){
            if(length - i < maxLength/2){
                break;
            }
            int left = i,right = i;
            while (left < length - 1 && s.charAt(right + 1) == s.charAt(right)){
                ++right;
            }
            i = right + 1;
            while (right < length - 1 && left > 0 && s.charAt(right + 1)==s.charAt(left - 1)){
                ++right;
                --left;
            }
            if(right - left + 1 > maxLength){
                start = left;
                maxLength = right - left + 1;
            }
        }
        return s.substring(start,start + maxLength);
    }

    public String LongestPalindrome3(String s){
        return null;
    }
}
