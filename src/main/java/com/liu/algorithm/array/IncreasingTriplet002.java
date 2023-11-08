package com.liu.algorithm.array;

/**
 * @author liu
 */
public class IncreasingTriplet002 {

    /**
     * 贪心
     * 思路
     * 设置一个最小值，和第二小的值，循环数组，判断是否存在三元子序列
     * 步骤
     * 1. 设置min初始值为Integer的最大值
     * 2. 设置secondMin初始值为Integer的最大值
     * 3.循环数组，判断当前值是否小于min，小于将当前值赋值min
     * 4.判断当前值是否小于secondMin，小于将当前值赋值secondMin
     * 5.当前值，大于secondmin，存在合适的三元子序列
     * @param nums
     * @return
     */
    public boolean increasingTriplet1(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= min){
                min = nums[i];
            }else if(nums[i] <= secondMin){
                secondMin = nums[i];
            }else {
                return true;
            }
        }
        return false;
    }

}
