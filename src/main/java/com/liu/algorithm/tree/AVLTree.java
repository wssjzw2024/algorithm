package com.liu.algorithm.tree;

/**
 * @author liu
 */
public class AVLTree {

    private void resetHeight(AVLNode avlNode){
        avlNode.height = Math.max(avlNode.left == null ? 0:avlNode.left.height,
            avlNode.right == null ? 0:avlNode.right.height) + 1;
    }

    private AVLNode leftRevolve(AVLNode avlNode){
        //先保存avlNode的右子树
        AVLNode right = avlNode.right;


        // avlNode的右指针指向right的左子树
        avlNode.right = right.left;


        // right的左指针指向avlNode
        avlNode.left = avlNode;

        // 再更新right的高度
        resetHeight(right);


        // 返回right作为调整后的root
        return right;

    }

    private AVLNode rightRevolve(AVLNode avlNode){

        // 保存avlNode的左子树
        AVLNode left = avlNode.left;

        // avlNode的左指针指向left的右子树
        avlNode.left = left.right;

        //left的右指针指向avlNode
        left.right = avlNode;

        // 先更新avlNode的高度
        resetHeight(avlNode);

        //再更新left的高度
        resetHeight(left);

        // 返回left作为调整后的root
        return left;
    }


    private int getAltitudeDiff(AVLNode avlNode) {
        return (avlNode.left != null ? avlNode.left.height : 0) -
            (avlNode.right != null ? avlNode.right.height : 0);
    }

    private AVLNode reBalance(AVLNode avlNode){
        //获取avlNode的平衡因子
        int altitudeDiff = getAltitudeDiff(avlNode);

        if(Math.abs(altitudeDiff) > 1){
            if(altitudeDiff < 0){// LL旋转或者RL旋转
                // avlNode的右子树的平衡因子只可能为-1|0|1
                if(getAltitudeDiff(avlNode.right) == 1){
                    // avlNode的右子树右旋
                    avlNode.right = rightRevolve(avlNode.right);
                }
                // avlNode左旋
                return leftRevolve(avlNode);
            }
        }else {// RR旋转或者LR旋转
            // avlNode的左子树的平衡因子只可能为-1|0|1
            if(getAltitudeDiff(avlNode.left) == -1){
                // avlNode的左子树左旋
                avlNode.left = leftRevolve(avlNode.left);
            }
            return rightRevolve(avlNode);
        }
        return avlNode;
    }

    private AVLNode insert(AVLNode newNode,AVLNode root){
        if(root == null){
            // 找到了正确的位置，直接返回新节点
            return newNode;
        }
        if(root.key > newNode.key){
            root.left = insert(newNode,root.left);
        }else if(root.key < newNode.key){
            root.right = insert(newNode,root.right);
        }else {
            root.value = newNode.value;
            return root;
        }
        resetHeight(root);
        return reBalance(root);
    }



}
