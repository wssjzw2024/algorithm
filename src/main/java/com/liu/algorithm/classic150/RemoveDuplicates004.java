package com.liu.algorithm.classic150;

public class RemoveDuplicates004 {
    public int removeDuplicates(int[] nums){

        return removeNDuplicate(nums,2);
    }

    /**
     * 数据有序，相同元素保留 n 位
     * 步骤
     * 1.获取数据长度
     * 2.如果长度小于等于n，返回n
     * 3.初始化index等于n + 1
     * 4.循环数组
     *   循环体
     *   如果 下标i大于index，且 前2位不等于现在位置的数
     *   num[index++] = num[i]
     *  5.返回n
     * @param nums
     * @param n
     * @return
     */
    private int removeNDuplicate(int[] nums,int n){
        int len = nums.length;
        if(len <= n){
            return n;
        }
        int index = n+1;
        for (int i = 0; i < len; i++) {
            if(i > index && nums[i-2]!=nums[i]){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
