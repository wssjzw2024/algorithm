package com.liu.algorithm.array.project03;

/**
 * @author liu
 */
public class GuessNUmber002 {
    public int guessNumber(int n){
        int left = 1,right = n;
        while (left < right){
            int mid = left + (right - left)/2;
            if(guess(mid) <=0){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int guess(int nums){
        int pick = 0;
        if(pick < nums){
            return -1;
        }else if(pick > nums){
            return 1;
        }else {
            return 0;
        }
    }
}
