package com.liu.algorithm.system.linkedlist.project02;

import com.liu.algorithm.system.linkedlist.ListNode;

/**
 * @author liu
 */
public class SortList001 {

    public ListNode sortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head.next,slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while (left != null && right != null){
            if(left.val < right.val){
                dummy.next = left;
                left = left.next;
            }else {
                dummy.next = right;
                right = right.next;
            }
            dummy = dummy.next;
        }
        dummy.next = left != null ? left : right;
        return res.next;
    }

}
