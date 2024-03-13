package com.liu.algorithm.system.dynamicprogramming.project04;

/**
 * @author liu
 */
public class CanPartition {

    /**
     * 动态规划
     * 思路
     *  在0到len-1 范围，选择结果等于 target的数字
     * 步骤
     *  1.获取数组长度len
     *  2.初始化 数组和sum，最大值maxNum
     *  3.循环获得sum 和maxNum
     *  4.判断sum能被2除尽，不能 返回false
     *  5.比较maxNum和 sum/2 = target
     *  5.maxNum 大于 target 返回false
     *  6.初始化 boolean[][] dp = new boolean[len][target + 1]
     *  7.i从0到len - 1 dp[i][0] = true;
     *  8.dp[0][nums[0]] = true;
     *  9.循环 i从0到len - 1 num = nums[i]
     *  10 循环j行1到target
     *  11 j > num dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
     *  12.否则 dp[i][j] = dp[i - 1][j];
     *  13.返回 dp[len][target]
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums){
        int len = nums.length;
        if (len < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for(int num:nums){
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if(sum % 2 != 0){
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[][] dp = new boolean[len][target + 1];
        for (int i = 0; i < len; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < len; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len - 1][target];
    }

    /**
     * 动态规划优化
     * 思路
        i行与i-1行有关
     * 步骤
     *  1.获取数组长度len
     *  2.初始化 数组和sum，最大值maxNum
     *  3.循环获得sum 和maxNum
     *  4.判断sum能被2除尽，不能 返回false
     *  5.比较maxNum和 sum/2 = target
     *  5.maxNum 大于 target 返回false
     *  6.初始化 boolean[] dp = new boolean[target + 1];
     *  7. dp[0] = true;
     *  8.循环 从 0 到了len - 1 num = nums[i]
     *  9.j从target 到num，dp[j] |= dp[j - num];
     *  10、返回dp[target]
     * @param nums
     * @return
     */
    public boolean canPartition1(int[] nums){
        int len = nums.length;
        int sum = 0,maxNum = 0;
        for (int num:nums){
            sum += num;
            maxNum = Math.max(maxNum,num);
        }
        if(sum % 2 != 0){
            return false;
        }
        int target = sum /2;
        if(maxNum > target){
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < len; i++){
            int num = nums[0];
            for (int j = target; j >=num ; --j) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }
}
