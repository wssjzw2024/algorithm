package com.liu.algorithm.system.binarysearch;

public class SearchInsert01 {
    /**
     * 步骤
     * 1.初始化左右边界，闭区间.
     * 2.初始化index = 最右位置
     * 3.循环比较左右界
     * 4.获取中点位置
     * 5.当目标值小于等于中点位置，记录位置，right=mid - 1
     * 6.当目标值大于中点位置，left = mid + 1
     * 7.循环结束
     * 8.返回index
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target <= nums[mid]) {
                index = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return index;
    }

}
