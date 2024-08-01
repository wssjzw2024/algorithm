package com.liu.algorithm.system.datastructure.stack.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement07 {
    /**
     * 步骤
     * 1. 创建一个栈
     * 2.新建一个map
     * 3.新建一个数组
     * 4.倒序遍历nums2
     * 5.如果栈不为空，并且栈顶元素小于当前元素，则出栈，直到栈为空或者栈顶元素大于当前元素
     * 6.如果栈为空，则将当前元素放入map中，key为当前元素，value为-1
     * 7.如果栈不为空，则将当前元素放入map中，key为当前元素，value为栈顶元素
     * 9.循环遍历nums1，将nums1中的元素放入res中，res[i] = map.get(nums1[i])
     * 10.返回res
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : nums2[stack.peek()]);
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
