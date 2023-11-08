package com.liu.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu
 */
public class TwoSum001 {

    /**
     * 暴力枚举
     * 1.外层循环从0到数组末尾
     * 2.内层循环从外层加1起到末尾
     * 3.判断是否有两个数之和等于target
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums,int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    /**
     * 哈希表
     * 1。新建哈希表
     * 2.循环数组
     * 3.判断哈希表是否存在target - num[i]
     * 4.存在 返回当前 i，和从哈希表获取 target - num[i]的值
     * 5.不存在，继续循环
     * 6.循环结束不存在，返回null
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{i,map.get(target - nums[i])};
            }else{
                map.put(nums[i],i);
            }
        }
        return null;
    }
}
