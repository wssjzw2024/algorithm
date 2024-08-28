package com.liu.algorithm.system.datastructure.linkedlist;

public class DeleteValue03 {

    public SingleListNode deleteValue(SingleListNode head,int val){
        SingleListNode dummy = new SingleListNode();
        dummy.next = head;
        SingleListNode cur = dummy;
        while (cur.next!= null){
            if(cur.next.val==val){
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
