package com.liu.algorithm.classicinterview;

import com.liu.algorithm.system.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu
 */
public class PathSum022 {
    Map<Integer, Integer> prefixMap;
    int target;

    public int pathSum(TreeNode root,int targetSum){
        prefixMap = new HashMap<>();
        target = targetSum;
        prefixMap.put(0, 1);
        return recur(root,0);
    }

    public int recur(TreeNode node,int curSum){
        if(node == null){
            return 0;
        }
        int res = 0;
        curSum += node.val;

        res += prefixMap.getOrDefault(curSum - target,0);
        prefixMap.put(curSum,prefixMap.getOrDefault(curSum,0) + 1);
        int left = recur(node.left,curSum);
        int right = recur(node.right,curSum);

        res = res + left + right;

        prefixMap.put(curSum,prefixMap.get(curSum) - 1);
        return res;
    }
}
