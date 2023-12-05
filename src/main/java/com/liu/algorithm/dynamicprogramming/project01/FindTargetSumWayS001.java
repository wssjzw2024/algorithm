package com.liu.algorithm.dynamicprogramming.project01;

/**
 * @author liu
 */
public class FindTargetSumWayS001 {


    /**
     * 递归
     * 思路
     * 当最后一个位置，和等于target，返回1，不是返回0
     * 不是最后一个，可以添加 + 和 - 两种情况
     * 步骤
     * 1、递归方法
     * 2.当最后一个位置，和等于target，返回1，不是返回0
     * 3.不是最后。添加+的情况 加上 添加 - 的情况
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums,int target){
        return process(nums,0,target,0);
    }

    private int process(int[] nums,int index,int target,int sum){
        if(index == nums.length){
            if(target == sum){
                return 1;
            }else {
                return 0;
            }
        }
        return process(nums,index + 1,target,sum + nums[index])
            +process(nums,index + 1,target,sum - nums[index]);
    }

    /**
     * 动态规划
     * 思路
     * 记数组的元素和为 sum，添加 - 号的元素之和为 neg，则其余添加 +的元素之和为 sum−neg，得到的表达式的结果为
     * (sum−neg)−neg=sum−2⋅neg=target
     * 即
     * neg = (sum - target)/2
     * 由于数组 nums中的元素都是非负整数，neg也必须是非负整数，所以上式成立的前提是 sum−target 是非负偶数。若不符合该条件可直接返回 0
     *
     * 定义二维数组 dp，其中 dp[i][j] 表示在数组 nums的前 i 个数中选取元素，使得这些元素之和等于 j 的方案数。
     * 假设数组 nums 的长度为 n，则最终答案为 dp[n][neg]。
     * 步骤
     * 1.累加nums数组的元素
     * 2.减去target是diff
     * 3.判断diff是否是非负偶数
     * 4.新建dp[n + 1][diff/2]
     * 5.初始值dp[0][0] = 1;
     * 6.i从1到N
     * 7.j从0到diff/2
     * 8.dp[i][j] 默认等于dp[i - 1][j];
     * 9.j大于nums[i - 1]
     * 10.加上dp[i - 1][j - nums[i - 1]]
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays1(int[] nums,int target){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int diff = sum - target;
        if(diff < 0 || diff % 2 != 0){
            return 0;
        }
        int n = nums.length,neg = diff/2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j < neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j >= num){
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][neg];
    }
}
