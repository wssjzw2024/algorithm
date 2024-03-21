package com.liu.algorithm.classicinterview;

import com.liu.algorithm.system.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author liu
 */
public class KthSmallest013 {
    public int kthSmallest(TreeNode root,int k){
        Deque<TreeNode>  stack = new ArrayDeque<>();
        while (root!=null || !stack.isEmpty()){
            while (root !=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            --k;
            if(k == 0){
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}
