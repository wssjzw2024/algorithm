package com.liu.algorithm.classicinterview;

import com.liu.algorithm.system.linkedlist.ListNode;

/**
 * @author liu
 */
public class SwapPairs010 {

    public ListNode swapPair(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        while (temp.next != null && temp.next.next != null){
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummy.next;
    }

}
