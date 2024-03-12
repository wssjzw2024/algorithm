package com.liu.algorithm.tree;

import com.liu.algorithm.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liu
 */
public class LevelOrder001 {

    public List<List<Integer>> levelorder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                subList.add(node.val);
                if(node.left!=null){
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
