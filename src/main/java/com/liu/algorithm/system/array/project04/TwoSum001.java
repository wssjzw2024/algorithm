package com.liu.algorithm.system.array.project04;

/**
 * @author liu
 */
public class TwoSum001 {
    /**
     * 对撞指针
     * 思路
     *  两边向中间移动
     * 步骤
     *  1.获取数组长度
     *  2.left = 0 right = len - 1
     *  3.当left < right
     *  4.寻找nums[left] + nums[right] = target
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers,int target){
        int len = numbers.length;
        int left = 0;
        int right = len - 1;
        while (left < right){
            if(numbers[left] + numbers[right] == target){
                return new int[]{left,right};
            }else if(numbers[left] + numbers[right] > target){
                right --;
            }else {
                left++;
            }
        }
        return null;
    }
}
