package com.liu.algorithm.system.datastructure.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvalRPN06 {
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
