package com.liu.algorithm.system.doublepointer.linkedlist;

import com.liu.algorithm.system.datastructure.linkedlist.ListNode;

import java.util.PriorityQueue;

/**
 * @author liu
 */
public class MergeKLists03 {
    /**
     *  利用小根堆
     *  步奏
     *  1.新建小根堆
     *  2.循环Listnode数组
     *  3.循环当前链表
     *  4.当链表的值加入小根堆，链表向后移动
     *  5.直到全部加入小根堆
     *  6.新建虚拟节点
     *  7.循环将小根堆中的数弹出
     *  8.将数值新建节点 加入链表
     *  9.返回虚拟节点的下一个结点
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

    /**
     * 两两合并
     * 步骤
     * 1，循环listNode
     * 2.新建ans
     * 3，将ans与数组元素依次合并，
     * 4.返回ans
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null){
            cur.next = l1;
        }
        if (l2 != null){
            cur.next = l2;
        }
        return dummy.next;
    }
}
