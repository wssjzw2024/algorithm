package com.liu.algorithm.system.datastructure.stack;

import java.util.Stack;

/**
 * @author liu
 */
public class IsValid01 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        if(chars.length %2 !=0) return false;
        Stack<Character> stack = new Stack<>();
        for(char ch : chars) {
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            if(ch == ')') {
                if(stack.isEmpty()) return false;
                Character pop = stack.pop();
                if(pop != '(') return false;
            }else if(ch == '}') {
                if(stack.isEmpty()) return false;
                Character pop = stack.pop();
                if(pop != '{') return false;
            }else if(ch == ']') {
                if(stack.isEmpty()) return false;
                Character pop = stack.pop();
                if(pop != '[') return false;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}
