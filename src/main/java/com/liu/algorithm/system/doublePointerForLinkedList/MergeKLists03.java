package com.liu.algorithm.system.doublePointerForLinkedList;

import com.liu.algorithm.ListNode;

import java.util.PriorityQueue;

/**
 * @author liu
 */
public class MergeKLists03 {
    /**
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(ListNode node:lists){
            while (node!=null){
                pq.add(node.val);
                node=node.next;
            }
        }
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (!pq.isEmpty()){
            int val = pq.poll();
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return head.next;
    }
}
