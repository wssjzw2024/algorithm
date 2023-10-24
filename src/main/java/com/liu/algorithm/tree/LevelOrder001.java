package com.liu.algorithm.tree;

import java.util.*;

/**
 * @author liu
 */
public class LevelOrder001 {
    /**
     * BFS
     * 思路
     * 将一层树节点，加入到queue中，循环加入list，同时将下层节点加入queue
     * 步骤
     * 1.新建list
     * 2.判断root是否为空
     * 3.新建队列
     * 4.将root加入队列
     * 5.判断队列是否为空
     * 6.获取队列长度
     * 7.新建下层list
     * 8.循环队列长度
     * 9.弹出队列元素，将值加入下层list
     * 10.判断左右子树，是否为空，不为空加入queue
     * 11，将下层list加入list，
     * 12.循环完成，返回list
     * @param root
     * @return
     */
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

    /**
     * DFS
     * 思路
     * 根据list的下标，将同层数据放到同一层
     * 步骤
     * 1.构建递归方法，传入list，节点，层数
     * 2.判断节点是否为空
     * 3.层数对应list是否存在，不存在新建
     * 4.获取对应的下层list，将vlaue放入
     * 5.递归左右子树。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        levelHeper(result,root,0);
        return result;
    }
    public void levelHeper(List<List<Integer>> result,TreeNode node,int level){
        if(node == null){
            return;
        }
        if(level >= result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        levelHeper(result,node.left,level + 1);
        levelHeper(result,node.right,level + 1);
    }
}
