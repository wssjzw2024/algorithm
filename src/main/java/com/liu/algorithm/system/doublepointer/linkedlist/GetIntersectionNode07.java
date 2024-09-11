package com.liu.algorithm.system.doublepointer.linkedlist;


import com.liu.algorithm.system.datastructure.linkedlist.SingleListNode;

/**
 * @author liu
 */
public class GetIntersectionNode07 {
    /**
     * 双指针
     * 步骤
     * 1,判断headA，headB是否为空，任一为空，都不相交
     * 2.初始pA 为 headA，pB为headB
     * 3.循环 条件 pA不等于pB
     *   循环体
     *    pA是否为空，为空，指向headB，否则向后移动
     *    pB是否为空，为空，指向headA，否则向后移动
     *  4.返回 pA
     * @param headA
     * @param headB
     * @return
     */
    public SingleListNode getIntersectionNode(SingleListNode headA, SingleListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        SingleListNode pA = headA,pB = headB;
        while (pA != pB){
            pA = pA == null ? headB:pA.next;
            pB = pB == null ? headA:pB.next;
        }
        return pA;
    }
}
