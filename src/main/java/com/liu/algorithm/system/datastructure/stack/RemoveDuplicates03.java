package com.liu.algorithm.system.datastructure.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author liu
 */
public class RemoveDuplicates03 {

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
