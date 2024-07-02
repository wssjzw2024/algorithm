package com.liu.algorithm.system.datastructure.stack;

import java.lang.invoke.SwitchPoint;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author liu
 */
public class Calculate02 {
    /**
     * 步骤
     * 1.ArrayDeque作为栈
     * 2.设置preSign默认为+
     * 3.设置num = 0
     * 4.循环字符串
     * 7.如果是数字，可能是多位，获取值
     * 8。如果不是数字且不为空，或者 最后一位
     * 9.根据符号，作不同操作
     * 10.加 入栈
     * 11 减 负数入栈
     * 12 乘除，先弹出操作，再入栈
     * 13 最后循环出栈，相加
     * @param s
     * @return
     */
    public int calculate(String s){
        Deque<Integer> stack = new ArrayDeque<Integer>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
