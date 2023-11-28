package com.liu.algorithm.array;

/**
 * @author liu
 */
public class PlusOne001 {
    /**
     * 数学
     * 思路
     * 两种情况
     * 1.除9之外的数字加一
     * 2.数字9
     * 步骤
     * 1.逆序循环
     * 2.数字加1
     * 3.对数字取余
     * 4.判断，不等于0，结束循环
     * 5.循环完，没结束，新建数组长度加1
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
                digits[i]++;
                digits[i] = digits[i] % 10;
                if(digits[i] != 0){
                    return digits;
                }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
