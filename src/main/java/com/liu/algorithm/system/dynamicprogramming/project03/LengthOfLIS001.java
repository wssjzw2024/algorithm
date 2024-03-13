package com.liu.algorithm.system.dynamicprogramming.project03;

/**
 * @author liu
 */
public class LengthOfLIS001 {

    /**
     * 动态规划
     * 思路
     *  dp[i],i个数字结尾的最长上升的长度
     *  dp[i] = max(dp[j]) + 1,nums[j] < nums[i]
     * 步骤
     * 1.获取数组长度
     * 2.初始化max dp[]
     * 3.循环dp[i]默认1
     * 4.循环i到j
     * 5.dp[i] = Math.max(dp[i],dp[j] + 1);nums[j] < nums[i]
     * 6.返回dp[len - 1]
     * @param nums
     * @return
     */
    public int lengthLIS(int[] nums){
        int len = nums.length;
        int max = 1;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }
        return dp[len - 1];
    }

    /**
     * 贪心 + 二分查找
     * 思路
     *  如果我们要使上升子序列尽可能的长，则我们需要让序列上升得尽可能慢，因此我们希望每次在上升子序列最后加上的那个数尽可能的小。
     * 步骤
     *  1.初始化 len = 1，数组长度
     *  2.数组d  d[len] = nums[0];
     *  3.循环
     *  4.当nums[i] 大于d[len] 数组增加
     *  5.当nums[i] 小于d[len] 找到最接近
     * @param nums
     * @return
     */
    public int lengthLIS1(int[] nums){
        int len = 1 ,n = nums.length;
        if(n == 0){
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];

        for (int i = 1; i < n; ++i){
            if(nums[i] > d[len]){
                d[++len] = nums[i];
            }else {
                int l = 1,r = len,pos = 0;
                while (l <= r){
                    int mid = (l + r) >> 1;
                    if(d[mid] < nums[i]){
                        pos = mid;
                        l = mid + 1;
                    }else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }

}
