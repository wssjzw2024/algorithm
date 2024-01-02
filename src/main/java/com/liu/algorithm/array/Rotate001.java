package com.liu.algorithm.array;

/**
 * @author liu
 */
public class Rotate001 {
    /**
     * 使用额外的数组
     * 思路 使用额外数组，
     * 步骤
     * 1.获取数组长度
     * 2.新建数组
     * 3.将老数组赋值给新数组
     * 4.再次循环
     * 5.老数组等与新数组位置加k对n取余
     * @param nums
     * @param k
     */
    public void rotate(int[] nums,int k){
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            newArr[i] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = newArr[(i + k)%n];
        }
    }
}
