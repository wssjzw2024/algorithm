package com.liu.algorithm.system.datastructure.stack;

import java.lang.invoke.SwitchPoint;
import java.util.Stack;

/**
 * @author liu
 */
public class Calculate02 {
    public int calculate(String s){
        int sum = 0;
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        stack.push(chars[0] - '0');
        for (int i = 1; i < chars.length; i++) {
            if(Character.isDigit(chars[i])){
                if(chars[i - 1] == '+'){
                     stack.push(chars[i] - '0');
                }else if(chars[i - 1] == '-'){
                    stack.push(-(chars[i] - '0'));
                }
                if(chars[i - 1] == '*' ){
                    int pop = stack.pop();
                    int push = pop * (chars[i] - '0');
                    stack.push(push);
                }else if(chars[i - 1] == '/'){
                    int pop = stack.pop();
                    int push = pop / (chars[i] - '0');
                    stack.push(push);
                }
            }
        }
        while(!stack.isEmpty()){
            int pop = stack.pop();
            sum += pop;
        }
        return sum;
    }
}
