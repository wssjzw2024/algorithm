package com.liu.algorithm.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liu
 */
public class GetIntersectionNode001 {
    /**
     * 哈希表
     * 思路
     * 将一个链表放入set集合，循环判断另外一个链表是否存在。
     * 步骤
     * 1.新建set集合
     * 2.新建零时节点，指向headA
     * 3.循环，将链表A放入set
     * 4.循环链表B，判读是否有节点在set中
     * 5.有，是相交节点，否，不相交
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersection1(ListNode headA,ListNode headB){
        Set<ListNode> set = new HashSet<>();
        ListNode newheadA = headA;
        while (newheadA != null){
            set.add(newheadA);
            newheadA = newheadA.next;
        }
        ListNode newheadB = headB;
        while (newheadB !=null){
            if(set.contains(newheadB)){
                return newheadB;
            }
            newheadB = newheadB.next;
        }
        return null;
    }

    public ListNode getIntersection2(ListNode headA,ListNode headB){
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB){
            pA = pA == null ? headB:pA.next;
            pB = pB == null ? headA:pB.next;
        }
        return pA;
    }

}
