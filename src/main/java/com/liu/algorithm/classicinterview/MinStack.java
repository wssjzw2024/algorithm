package com.liu.algorithm.classicinterview;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author liu
 */
public class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;


    public MinStack(){
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val){
        stack.push(val);
        minStack.push(Math.min(minStack.peek(),val));
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
