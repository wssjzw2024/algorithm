package com.liu.algorithm.system.datastructure.stack.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement07 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] > nums2[i]) {
                stack.pop();
            }
            stack.push(i);
        }
        return null;
    }
}
