package com.liu.algorithm.system.datastructure.linkedlist;

public class ReverseSingleLikedList01 {
    public SingleListNode reverseSingleLikedList(SingleListNode head){
        SingleListNode pre = null;
        SingleListNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
