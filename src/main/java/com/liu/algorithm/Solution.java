package com.liu.algorithm;

/**
 * @author liu
 */
public class Solution {

    public int countDigits(int num) {
        int total = num;
        int count = 0;
        while (num != 0){
            int div =num % 10;
            if(total%div == 0){
                count++;
            }
            num = num/10;
        }
        return count;
    }
}
