package com.liu.algorithm.system.doublepointer.linkedlist;

import com.liu.algorithm.system.datastructure.linkedlist.SingleListNode;

/**
 * @author liu
 */
public class DetectCycle06 {
    /**
     * 快慢指针
     * 步骤
     * 1.新建快慢指针
     * 2.循环判断快指针是否为空，判断快指针下一个节点是否为空
     * 3.快指针移动2步
     * 4.慢指针移动1步
     * 5.如何快指针等于慢指针，跳出循环
     * 6.判断快指针是否为空，判断快指针下一个节点是否为空，为空，返回false
     * 7. 快指针重新指向头节点
     * 8.循环判断快慢指针是否相等
     * 9，不等 快慢指针一起向后移
     * 10。相等 跳出循环，
     * 11.返回 fast
     * @param head
     * @return
     */
    public SingleListNode detectCycle(SingleListNode head) {
        SingleListNode fast = head;
        SingleListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

}
