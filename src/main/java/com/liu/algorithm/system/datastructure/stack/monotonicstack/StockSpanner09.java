package com.liu.algorithm.system.datastructure.stack.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;


public class StockSpanner09 {
    private Deque<Integer> stack;
    private Map<Integer, Integer> map;

    public StockSpanner09(){
        stack = new ArrayDeque<Integer>();
        map = new HashMap<>();
    }

    public int next(int price){

        while(!stack.isEmpty() && stack.peek() < price){
            stack.pop();
        }
        stack.push(price);
        return 0;
    }
}
