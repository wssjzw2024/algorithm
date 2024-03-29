package com.liu.algorithm.classicinterview;

import com.liu.algorithm.system.tree.TreeNode;

import java.util.*;

/**
 * @author liu
 */
public class RightSideView020 {
    public List<Integer> rightSideView(TreeNode root){
        Map<Integer,Integer> rightmostValueAtDepth = new HashMap<>();
        int max_depth = -1;

        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Integer
            > depthStack = new LinkedList<>();
        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if(node != null){
                max_depth = Math.max(max_depth,depth);

                if(!rightmostValueAtDepth.containsKey(depth)){
                    rightmostValueAtDepth.put(depth,node.val);
                }

                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }
        List<Integer> rightview = new ArrayList<>();
        for (int i = 0; i <= max_depth; i++) {
            rightview.add(rightmostValueAtDepth.get(i));
        }
        return rightview;
    }
}
