package com.liu.algorithm.system.doublepointer.linkedlist;


import com.liu.algorithm.system.datastructure.linkedlist.SingleListNode;

/**
 * @author liu
 */
public class GetIntersectionNode07 {

    public SingleListNode getIntersectionNode(SingleListNode headA, SingleListNode headB) {
        SingleListNode tempA = headA;
        SingleListNode tempB = headB;

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
