package com.liu.algorithm.system.datastructure.linkedlist;

public class DoubleListNode {
    public int val;
    public DoubleListNode pre;
    public DoubleListNode next;

    public DoubleListNode() {
    }

    public DoubleListNode(int val) {
        this.val = val;
    }

    public DoubleListNode(int val, DoubleListNode pre, DoubleListNode next) {
        this.val = val;
        this.pre = pre;
        this.next = next;
    }
}
