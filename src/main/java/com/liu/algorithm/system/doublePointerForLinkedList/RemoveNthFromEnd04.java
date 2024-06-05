package com.liu.algorithm.system.doublePointerForLinkedList;

import com.liu.algorithm.ListNode;

/**
 * @author liu
 */
public class RemoveNthFromEnd04 {
    public ListNode  removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
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
