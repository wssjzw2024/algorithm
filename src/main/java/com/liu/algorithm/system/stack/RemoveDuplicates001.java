package com.liu.algorithm.system.stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author liu
 */
public class RemoveDuplicates001 {

    /**
     * 步骤
     * 1.初始化stringBuilder
     * 2.字符串转数组
     * 3.循环数组
     * 4.判断，弹出
     * 5.返回剩余字符
     * 6.反转，返回
     * @param s
     * @return
     */
    public String removeDuplicates(String s){
        StringBuilder sb = new StringBuilder();
        char[] chars =s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(char ch:chars){
            if(stack.size() > 0 && ch == stack.peek()){
                stack.pop();
            }else {
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
