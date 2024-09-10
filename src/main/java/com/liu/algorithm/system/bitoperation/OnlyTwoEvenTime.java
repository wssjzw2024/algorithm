package com.liu.algorithm.system.bitoperation;

public class OnlyTwoEvenTime {
    /**
     * 异或，取最后一位，区分
     * 步骤
     * 1.初始化eor 为0
     * 2.循环数组
     *   循环体
     *   eor与每个数组异或
     * 3.eor 与上 eor取反加1
     * 4.获取rightOne
     * 5.初始化first为0
     * 6.循环数组
     *   循环体
     *   如果数组值与rightOne等于0
     *   first ^= arr[i]
     * 7.返回数组 first，first异或eor
     * @param arr
     * @return
     */
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
