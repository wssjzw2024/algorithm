package com.liu.algorithm.system.datastructure.linkedlist;

public class DeleteValue03 {
    /**
     * 删除目标值
     * 步骤
     * 1.新建虚拟节点
     * 2.虚拟节点指向头节点
     * 3.初始化cur指向虚拟节点
     * 4.循环 cur的下一个节点不为null
     *   循环体
     *   如果cur的下一个节点等于val
     *   cur的下一节点指向下下个节点
     *   中断循环
     *   cur移动cur的下个节点
     * 5.返回 虚拟节点的下个节点
     * @param head
     * @param val
     * @return
     */
    public SingleListNode deleteValue(SingleListNode head,int val){
        SingleListNode dummy = new SingleListNode();
        dummy.next = head;
        SingleListNode cur = dummy;
        while (cur.next!= null){
            if(cur.next.val==val){
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
