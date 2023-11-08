package com.liu.algorithm.dynamicprogramming;

/**
 * @author liu
 */
public class ClimbStairs004 {

    public int climbStairs(int n){
        if(n <2){
            return n;
        }
        int p = 1,q = 1,sum;
        for (int i = 2; i <=n; i++) {
                sum = p + q;
                p = q;
                q = sum;
        }
        return q;
    }
}
