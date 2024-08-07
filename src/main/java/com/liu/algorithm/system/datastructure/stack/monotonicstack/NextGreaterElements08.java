package com.liu.algorithm.system.datastructure.stack.monotonicstack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElements08 {

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
