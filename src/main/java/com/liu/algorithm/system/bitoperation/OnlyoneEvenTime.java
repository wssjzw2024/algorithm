package com.liu.algorithm.system.bitoperation;

public class OnlyoneEvenTime {

    public int getNumber(int[] arr){
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        return eor;
    }
}
