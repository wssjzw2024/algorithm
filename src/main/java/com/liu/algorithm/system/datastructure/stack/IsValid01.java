package com.liu.algorithm.system.datastructure.stack;

import java.util.Stack;

/**
 * @author liu
 */
public class IsValid01 {
    /**
     * 步骤
     * 1.将字符串转为字符数组
     * 2.判断长度是否是偶数
     * 3.循环字符数组
     * 4.判断是否是左括号，是加入栈
     * 5.如果是右括号，栈弹出相应的括号
     * 6.如何栈为空，返回false
     * 7.循环结束
     * 8.如果栈为空，返回true
     * @param s
     * @return
     */
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
