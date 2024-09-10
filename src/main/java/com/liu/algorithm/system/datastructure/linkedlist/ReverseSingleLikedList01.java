package com.liu.algorithm.system.datastructure.linkedlist;

public class ReverseSingleLikedList01 {
    /**
     * 反转单链表
     * 步骤
     * 1.初始化前一个节点pre为null，后一个节点next为null
     * 2.循环 条件 head不等于null
     *  循环体
     *  当前节点后一个节点赋值next
     *  当前节点后一一个节点连接到pre
     *  pre移动到head
     *  head移动到next
     * @param head
     * @return
     */
    public SingleListNode reverseSingleLikedList(SingleListNode head){
        SingleListNode pre = null;
        SingleListNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
