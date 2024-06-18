package com.liu.algorithm.system.doublePointerForLinkedList;

import com.liu.algorithm.system.datastructure.ListNode;

/**
 * @author liu
 */
public class Partiton02 {

    /**
     *  模拟
     *  步奏
     *  1.新建small节点
     *  2.新建smallHead节点 smallHead = small
     *  3.新建big节点
     *  4.新建bigHead节点 bigHead = big
     *  5，循环判断 head ！= null
     *  6.当 head.val < x
     *     small.next = head;
     *     small = samll.next;
     *  7。当 head.val >= x
     *      big.next = head;
     *      big = big.next
     *  8. head = head.next
     *  9.循环结束
     *  10. small.next = largeHead.next;
     *  11.big.next = null
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {

            ListNode small = new ListNode(-1);
            ListNode smallHead = small;
            ListNode big = new ListNode(-1);
            ListNode bigHead = big;

            while (head != null) {
                if (head.val < x) {
                    small.next = head;
                    small = small.next;
                }else {
                    big.next = head;
                    big = big.next;
                }
                head = head.next;
            }
            big.next = null;
            small.next = bigHead.next;
            return smallHead.next;
    }

}
