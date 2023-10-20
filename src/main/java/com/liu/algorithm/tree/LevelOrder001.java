package com.liu.algorithm.tree;

import java.util.*;

/**
 * @author liu
 */
public class LevelOrder001 {

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int leveNUm = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < leveNUm; i++) {
                TreeNode node = queue.poll();
                subList.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(subList);
        }
        return result;
    }
}
