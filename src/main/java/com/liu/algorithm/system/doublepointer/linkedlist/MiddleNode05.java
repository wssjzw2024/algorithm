package com.liu.algorithm.system.doublepointer.linkedlist;

import com.liu.algorithm.system.datastructure.linkedlist.ListNode;

/**
 * @author liu
 */
public class MiddleNode05 {
    /**
     * 快慢指针
     * 步骤
     * 1.新建快慢指针
     * 2.循环判断 快指针是否为空，快指针的下一节点是否为空
     * 3.快指针跳两步
     * 4.慢指针跳异步
     * 5.返回慢指针
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
