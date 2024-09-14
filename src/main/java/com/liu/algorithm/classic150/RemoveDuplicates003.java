package com.liu.algorithm.classic150;

public class RemoveDuplicates003 {
    /**
     * 双指针
     * 步骤
     * 1.初始化 temp为Integer的最小值,初始化下标为0
     * 2.循环数组
     * 3. 循环体
     *    如果temo不等于当前值，将当前值赋值下标index的数组
     *    下标自增，将当前值赋值为temp
     * 4.返回 index
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums){
        int temp = Integer.MIN_VALUE, index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(temp!= nums[i]){
                nums[index++] = nums[i];
                temp = nums[i];
            }
        }
        return index;
    }
}
