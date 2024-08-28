package com.liu.algorithm.system.datastructure.linkedlist;

public class ReverseDoubleLikedList02 {
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
