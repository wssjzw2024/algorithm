package com.liu.algorithm.system.linkedlist.project01;

import com.liu.algorithm.system.linkedlist.ListNode;

/**
 * @author liu
 */
public class DeleteDulicates002 {
    /**
     * 步骤
     * 1.判断边界
     * 2，设置虚拟节点(有可能换头)
     * 3.循环
     * 4.判断数值 记录数据
     * 5.如果相等向后移动，cur。next直到移动不同
     * 6.不等 cur向后移
     * @param head
     * @return
     */
    public ListNode deleteDulicates(ListNode head){
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode(0,head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null){
            if(cur.next.val == cur.next.next.val){
                int x = cur.next.val;
                while (cur.next!=null && cur.next.val == x){
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
