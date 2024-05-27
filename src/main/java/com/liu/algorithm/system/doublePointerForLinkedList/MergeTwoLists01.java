package com.liu.algorithm.system.doublePointerForLinkedList;

import com.liu.algorithm.ListNode;

/**
 * @author liu
 */
public class MergeTwoLists01 {
    /**
     * 迭代
     * 步奏
     * 1。判断 list1是否为null，为null返回list2
     * 2. 判断 list2是否为null，为null返回list1
     * 3.新建虚拟头节点 dumy
     * 4.新建节点current，将dumy赋值current
     * 5.循环判断list1 和 list2 是否等于null
     * 6. 当都不为null，比较list1与list2的值
     * 7. 当list1 小于 list2 ，
     * current.next = list1
     * list1 = list1.next
     * 8.当list2 小于 list1
     * current.next = list2
     * list2 = list2.next
     * 9.current = current.next
     * 10.循环，直到不满组条件
     * 11.判断 list1是否不为null ，不为null
     * current.next = list1
     * 12 判断 list2是否不为null ，不为null
     * current.next = list2
     * 13 返回 dumy.next
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode dumy = new ListNode(-1);
        ListNode current = dumy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }
        return dumy.next;
    }

    /**
     * 递归
     * 步骤
     * 1。判断 list1是否为null，为null返回list2
     * 2。判断 list2是否为null，为null返回list1
     * 3，判断 list1。val < list2.val
     * 成立 list1.next 等于 list1.next与list2合并结果
     * 返回list1
     * 4.判断 list2.val < list1.val
     * 成立 list2.next 等于 list2.next与list1合并结果
     * 返回list2
     * 5.最后返回null
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists1(list1.next, list2);
            return list1;
        } else if (list2.val < list1.val) {
            list2.next = mergeTwoLists1(list2, list1);
            return list2;
        }
        return null;
    }
}
