package com.liu.algorithm.system.datastructure.stack.monotonicstack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElements08 {
    /**
     * 单调栈，数组循环
     * 步骤
     * 1.获取数组长度
     * 2.初始化新数组ret
     * 3.将数组填充-1
     * 4.新建栈
     * 5.循环数组，长度为数组长度两倍 - 1
     * 6.循环 条件 栈不为空且栈顶元素小于当前元素
     *   循环体
     *   ret[stack.pop] = nums[i%len]
     *
     *   将循环下标对长度取余，加到栈中
     * 7.返回数组ret
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] ret = new int[len];
        Arrays.fill(ret, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len * 2 -1 ; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                ret[stack.pop()] = nums[i%len];
            }
            stack.push(i%len);
        }
        return ret;
    }
}
