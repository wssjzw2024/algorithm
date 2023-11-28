package com.liu.algorithm.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu
 */
public class LenLongestFibSubseq003 {
    /**
     * 动态规划
     * 思路
     * dp[i][j] i >j  表示arr[j]和arr[i]作为最后两个数字的斐波拉契
     * 子序列的最大长度，初始dp中所有值0；
     * 步骤
     * 新建hashmap
     * 将数组值与下标放入
     * 新建dp
     * i从0到n-1
     * j从 i-1开始，到0
     * 由于数组 arr是严格单调递增的，因此在确定下标 i 的情况下可以反向遍历下标 j，
     * 计算 dp[j][i]的值，只有当 arr[j]×2>arr[i] 时才满足 arr[k]<arr[j]
     * 从hashmap获取arr[i] - arr[j]
     * dp[j][i] = Math.max(dp[k][j] + 1,3);
     * @param arr
     * @return
     */
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer,Integer> indices = new HashMap<Integer,Integer>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            indices.put(arr[i],i);
        }
        int[][] dp = new int[n][n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >=0 && arr[j]* 2>arr[i] ; j--) {
                int k = indices.getOrDefault(arr[i]- arr[j],-1);
                if(k >= 0){
                    dp[j][i] = Math.max(dp[k][j] + 1,3);
                }
                ans = Math.max(ans,dp[j][i]);
            }
        }
        return ans;
    }
}
