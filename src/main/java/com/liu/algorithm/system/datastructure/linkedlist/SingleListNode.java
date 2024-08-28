package com.liu.algorithm.system.datastructure.linkedlist;

/**
 * @author liu
 */
public class SingleListNode {
    public int val;
    public SingleListNode next;
    public SingleListNode() {}
    public SingleListNode(int val) { this.val = val; }
    public SingleListNode(int val, SingleListNode next) { this.val = val; this.next = next; }
}
