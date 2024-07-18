package com.liu.algorithm.system.datastructure.stack;


import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures05 {
    /**
     * 单调栈
     * 步骤
     * 1，获取数组长度
     * 2. 新建结果数组
     * 3. 新建单调栈
     * 4. 循环数组
     * 5.   循环判断，栈是否为空，当前下标元素是否大于栈顶下标元素，
     * 6.   大于则，弹出栈顶下表，赋值给结果数组
     * 7. 将当前下标加入单调栈
     * 8.返回结果数组
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }
}
