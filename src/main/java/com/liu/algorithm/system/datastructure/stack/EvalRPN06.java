package com.liu.algorithm.system.datastructure.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvalRPN06 {
    /**
     * 步骤
     * 1.新建一个栈
     * 2.循环遍历tokens数组
     * 3.如果token是运算符，则弹出栈顶两个元素，运算，并将结果压入栈中
     * 4.如果token是数字，则直接压入栈中
     * 5.返回栈顶元素
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }else if (token.equals("-")) {
                int top = stack.pop();
                int bottom = stack.pop();
                stack.push(bottom - top);
            }else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }else if (token.equals("/")) {
                int top = stack.pop();
                int bottom = stack.pop();
                stack.push(bottom / top);
            }else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
