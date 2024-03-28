package com.liu.algorithm.classicinterview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu
 */
public class CopyRandomList018 {

    class Node{
        int val;
        Node next;
        Node random;

        public Node(int val){
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    Map<Node,Node> cache = new HashMap<>();
    public Node copyRandomList(Node head){
        if(head == null){
            return null;
        }
        if(!cache.containsKey(head)){
            Node headNew = new Node(head.val);
            cache.put(head,headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cache.get(head);
    }
}
