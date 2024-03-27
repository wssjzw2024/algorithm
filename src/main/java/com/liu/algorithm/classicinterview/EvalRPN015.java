package com.liu.algorithm.classicinterview;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liu
 */
public class EvalRPN015 {
    public int evalRPN(String[] tokens){
        Deque<Integer> stack = new LinkedList<>();
        for(String str:tokens){
            if("+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str)){
                Integer nums2 = stack.pop();
                Integer nums1 = stack.pop();
                switch (str){
                    case "+":
                        stack.push(nums1 + nums2);
                        break;
                    case "-":
                        stack.push(nums1 - nums2);
                        break;
                    case "*":
                        stack.push(nums1 * nums2);
                        break;
                    case "/":
                        stack.push(nums1 / nums2);
                        break;
                    default:
                }
            }else {
                stack.push(Integer.valueOf(str));
            }
        }
        return stack.pop();
    }
}
