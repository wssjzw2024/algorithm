package com.liu.algorithm.linkedlist.project01;

import com.liu.algorithm.linkedlist.ListNode;

/**
 * @author liu
 */
public class DeleteDuplicates001 {

    /**
     * 步骤
     *  1.head赋值node
     *  2.判断node与node.next的值
     *  3.相等 node.next = node.next.next;
     *  4.不相等 node = node.next
     * @param head
     * @return
     */
    public ListNode deleteDuplicate(ListNode head){
        ListNode node = head;
        while (node != null && node.next != null){
            if(node.val == node.next.val){
                node.next = node.next.next;
            }else {
                node = node.next;
            }
        }
        return head;
    }

}
