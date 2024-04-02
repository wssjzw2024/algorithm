package com.liu.algorithm.classicinterview;

import com.liu.algorithm.system.tree.TreeNode;

import java.util.Stack;

/**
 * @author liu
 */
public class Flatten024 {
    public void flatten(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        TreeNode pre = null;
        while (!s.isEmpty()){
            TreeNode temp = s.pop();

            if(pre != null){
                pre.right = temp;
                pre.left = null;
            }
            if(temp.right != null){
                s.push(temp.right);
            }
            if(temp.left != null){
                s.push(temp.left);
            }
            pre = temp;
        }

    }
}
