package com.liu.algorithm.tree;

/**
 * @author liu
 */
public class SortArrayToBST002 {

    public TreeNode sortArrayToBST(int[] nums){
        if(nums.length == 0){
            return null;
        }
        return sortArrayToBST(nums,0,nums.length - 1);
    }

    public TreeNode sortArrayToBST(int[] nums,int start,int end){
        if(start > end){
            return null;
        }
        int mid = (start + end) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortArrayToBST(nums,start,mid - 1);
        root.right = sortArrayToBST(nums,mid + 1,end);
        return root;
    }
}
