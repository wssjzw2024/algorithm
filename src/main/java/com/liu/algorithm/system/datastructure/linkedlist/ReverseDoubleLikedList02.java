package com.liu.algorithm.system.datastructure.linkedlist;

public class ReverseDoubleLikedList02 {
    /**
     * 反转双链表
     * 步骤
     * 1.初始前一个节点pre为null，初始化后一个节点next为null
     * 2，循环 条件 head不为null
     *    循环体
     *    将head的后一个节点赋值next
     *    head的后一个节点指向前一个节点pre
     *    head的前一个节点指向next
     *    pre移动到head
     *    head移动到next
     * 3.返回 pre
     * @param head
     * @return
     */
    public DoubleListNode reverseDoubleLikedList(DoubleListNode head){
        DoubleListNode pre = null;
        DoubleListNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
