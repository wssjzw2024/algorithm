package com.liu.algorithm.system.datastructure.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author liu
 */
public class RemoveDuplicates03 {
    /**
     * 步骤
     * 1. 创建StringBuilder
     * 2，将字符串转化为数组
     * 3. 循环数组
     * 4. 判断栈是否为空，不为空，比较当前元素与栈顶元素
     * 5. 相同，则弹出，
     * 6.不同 入栈
     * 7.循环栈，加入StringBuilder
     * 8.反转字符串
     * @param S
     * @return
     */
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        char[] chars = S.toCharArray();
        Deque<Character> stack = new ArrayDeque<Character>();
        for (char c : chars) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
