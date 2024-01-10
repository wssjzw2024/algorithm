package com.liu.algorithm.array.project01;

/**
 * @author liu
 */
public class FindMaxConsecutiveOnes001 {
    /**
     * 一次遍历
     * 思路 循环，当等于1 累计，当等于0,重新计算
     * 步骤
     * 1.初始化 count = 0，max = 0
     * 2.循环
     * 3.元素等于1 count++
     * 4.元素等于0 count = 0
     * 5.比较 max与count
     * 返回 count
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums){
        int count = 0;
        int max = 0;
        for(int num:nums){
            if(num == 1){
                count++;
            }else {
                count = 0;
            }
            max = Math.max(max,count);
        }
        return max;
    }

    /**
     * 滑动窗口
     * 思路 left，right 记录窗口两边，当right遇到0，计算长度，当再次遇到1，设置left
     * 步骤
     * 1.获取数组长度len
     * 2.初始化 left = 0，right = 0，maxSize = 0；
     * 3.right < len
     * 4.当num等于right++
     * 5.当num等于1 计算长度
     * 6.将right赋值left
     * 7.循环完成
     * 8.最后一次比较在循环外 max = Math.max(max,right - left)
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes1(int[] nums){
        int len = nums.length;
        int left = 0;
        int right = 0;
        int maxSize = 0;

        while (right < len){
            if(nums[right++] == 0){
                maxSize = Math.max(maxSize,right - left - 1);
                left = right;
            }
        }
        return Math.max(maxSize,right - left);
    }
}
