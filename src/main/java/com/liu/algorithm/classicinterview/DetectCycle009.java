package com.liu.algorithm.classicinterview;

import com.liu.algorithm.system.linkedlist.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liu
 */
public class DetectCycle009 {
    public ListNode maxSlidingWindow(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true){
            if(fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        fast = head;
        while (slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
