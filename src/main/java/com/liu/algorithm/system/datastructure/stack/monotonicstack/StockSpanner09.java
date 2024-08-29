package com.liu.algorithm.system.datastructure.stack.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;


public class StockSpanner09 {
    private Deque<int[]> stack;
    private Integer index;

    public StockSpanner09(){
        stack = new ArrayDeque<int[]>();
        stack.push(new int[]{-1,Integer.MAX_VALUE});
        index = -1;
    }

    public int next(int price){
        index++;
        while (!stack.isEmpty() && price >= stack.peek()[1]){
            stack.pop();
        }
        int ans = index - stack.peek()[0];
        stack.push(new int[]{index,price});
        return ans;
    }
}
