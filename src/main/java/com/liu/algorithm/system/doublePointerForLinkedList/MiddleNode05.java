package com.liu.algorithm.system.doublePointerForLinkedList;

import com.liu.algorithm.ListNode;

/**
 * @author liu
 */
public class MiddleNode05 {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
