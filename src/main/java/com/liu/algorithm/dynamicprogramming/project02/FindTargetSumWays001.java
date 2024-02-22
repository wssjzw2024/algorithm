package com.liu.algorithm.dynamicprogramming.project02;

/**
 * @author liu
 */
public class FindTargetSumWays001 {

    private static int count = 0;

    /**
     * 回溯
     * 思路
     *  判读最后一个数时，所加的和是否等于目标和
     * 步骤
     * 1. 初始化count = 0；
     * 2. 调用回溯
     * 3. 回溯内部 ，先判断临界情况
     * 4. 不是，分成加上值，和减去值两种情况
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums,int target){
        backtrack(nums,target,0,0);
        return count;
    }

    public void  backtrack(int[] nums,int target,int index,int sum){
        if(index == nums.length){
            if(target == sum){
                count++;
            }
        }
        backtrack(nums,target,index + 1,sum + nums[index]);
        backtrack(nums,target,index + 1,sum - nums[index]);
    }

    /**
     * 动态规划
     * 思路
     *    将题目转化n个里面选等于neg的值的方法
     * 步骤
     * 1.获取数组长度
     * 2.初始化 sum，
     * 3.数组累加 等于sum
     * 4.diff = sum - target
     * 5.diff < 0 || diff % 2 != 0 返回0
     * 6. 初始化 int[][] dp = new int[len + 1][neg + 1];
     * 7.初始值 dp[0][0] = 1;
     * 8.循环 从 0 到len
     * 9. num = nums[i - 1];
     * 10.循环 从0 到neg
     * 默认 dp[i][j] = d[i - 1][j]
     * 当 j > num
     * dp[i][j] += dp[i - 1][j - num];
     * 返回 dp[len][neg]
     * 状态转移方程
     * j < nums[i]  dp[i][j] = dp[i - 1][j];
     * j >= nums[i] dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]]
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays1(int[] nums,int target){
        int len = nums.length;
        int sum = 0;
        for(int num:nums){
            sum += num;
        }
        int diff = sum - target;
        if(diff < 0 || diff % 2 != 0){
            return 0;
        }
        int neg = diff/2;
        int[][] dp = new int[len + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            int num = nums[i - 1];
            for (int j = 1; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j > num){
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[len][neg];
    }

}
