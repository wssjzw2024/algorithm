package com.liu.algorithm.classicinterview;

import com.liu.algorithm.system.tree.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author liu
 */
public class BuildTree014 {
    public TreeNode buildTree(int[] preorder,int[] inorder){
        if(preorder == null || inorder == null || preorder.length != inorder.length){
            return null;
        }
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return buildMyTree(preorder,0,preorder.length - 1,inorder,0,inorder.length - 1,map);
    }

    public TreeNode buildMyTree(int[] preorder, int L1, int R1, int[] inorder, int L2, int R2, Map<Integer,Integer> indexMap) {
        if (L1 > R1) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[L1]);
        if (L1 == R1) {
            return head;
        }
        int find = indexMap.get(preorder[L1]);
        head.left = buildMyTree(preorder, L1 + 1, L1 + find - L2, inorder, L2, find - 1, indexMap);
        head.right = buildMyTree(preorder, L1 + find - L2 + 1, R1, inorder, find + 1, R2, indexMap);
        return head;
    }
}
