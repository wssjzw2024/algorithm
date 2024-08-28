package com.liu.algorithm.system.doublepointer.linkedlist;

import com.liu.algorithm.system.datastructure.linkedlist.SingleListNode;

/**
 * @author liu
 */
public class RemoveNthFromEnd04 {
    /**
     * 快慢指针
     * 步骤
     * 1.如果为空，返回空
     * 2.新建虚拟节点
     * 3.新建快指针
     * 4.新建慢指针
     * 5.快指针向后移动n-1
     * 6.然后快慢指针一起后移，知道快指针为空
     * 7.返回慢指针
     * @param head
     * @param n
     * @return
     */
    public SingleListNode removeNthFromEnd(SingleListNode head, int n) {
        if (head == null){
            return null;
        }
        SingleListNode dummy = new SingleListNode(0);
        dummy.next = head;
        SingleListNode fast = dummy;
        SingleListNode slow = dummy;
        while (n!=0){
            fast = fast.next;
            n--;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
