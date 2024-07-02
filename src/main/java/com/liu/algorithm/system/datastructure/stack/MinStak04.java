package com.liu.algorithm.system.datastructure.stack;

import java.util.Stack;

/**
 * @author liu
 */
public class MinStak04 {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStak04(){
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val){
        stack.push(val);
        minStack.push(Math.min(val, minStack.peek()));
    }

    public void pop(){
        stack.pop();
        minStack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }
}
