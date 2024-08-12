package com.liu.algorithm.system.bitoperation;

public class OnlyTwoEvenTime {

    public int[] getArray(int[] arr){
        int eor = 0;
        for (int i = 0; i < arr.length; i++){
            eor ^= arr[i];
        }
        int rightOne = eor & (-eor + 1);
        int first = 0;
        for (int i = 0; i < arr.length; i++){

            if((arr[i] & rightOne)==0){
                first ^= arr[i];
            }
        }
        return new int[]{first,eor^first};
    }
}
