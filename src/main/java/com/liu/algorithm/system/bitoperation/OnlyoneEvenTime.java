package com.liu.algorithm.system.bitoperation;

public class OnlyoneEvenTime {

    /**
     * 异或预算
     * 如果a、b两个值不相同，则异或结果为1。如果a、b两个值相同，异或结果为0。
     * @param arr
     * @return
     */
    public int getNumber(int[] arr){
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        return eor;
    }
}
