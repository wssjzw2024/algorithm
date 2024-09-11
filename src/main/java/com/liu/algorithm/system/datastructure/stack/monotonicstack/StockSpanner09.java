package com.liu.algorithm.system.datastructure.stack.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 单调栈，对象保存数组
 * 步骤
 * 1.新建栈，初始化栈
 * 2.初始化，下标
 * 3.加入时
 *  下标加加
 *  循环，条件栈不为空，当前值大于等于，栈的数组中第二个值
 *  循环体
 *      栈弹出
 *   下标减栈对象数组第一个值赋值ans
 *   将，当前下标，价格组成数组，加入栈
 *  4。返回ans
 */
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
