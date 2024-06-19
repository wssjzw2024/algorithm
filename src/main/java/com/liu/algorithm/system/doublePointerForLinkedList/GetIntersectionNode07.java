package com.liu.algorithm.system.doublePointerForLinkedList;


import com.liu.algorithm.system.datastructure.ListNode;

/**
 * @author liu
 */
public class GetIntersectionNode07 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != tempB) {
            if (tempA == null) {
                tempA = headB;
            }else {
                tempA = tempA.next;
            }

            if (tempB == null) {
                tempB = headA;
            }else {
                tempB = tempB.next;
            }
        }
        return tempA;
    }
}
