package com.liu.algorithm.system.linkedlist.project03;

import com.liu.algorithm.system.linkedlist.ListNode;

/**
 * @author liu
 */
public class AddTwoNUmbers002 {

    public ListNode addTwoNUmbers(ListNode l1, ListNode l2){
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode l3 = addTwo(l1, l2);
        return reverseList(l3);
    }

    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    private ListNode addTwo(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null){
                carry += l1.val;
            }
            if (l2 != null) {
                carry += l2.val;
            }
            cur = cur.next = new ListNode(carry % 10);
            carry /= 10;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
}
