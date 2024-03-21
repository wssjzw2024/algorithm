package com.liu.algorithm.classicinterview;


import java.util.HashMap;
import java.util.Map;

/**
 * @author liu
 */
public class LRUCache {
    class ListNode{
        int key;
        int value;
        ListNode prev;
        ListNode next;

        public ListNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;

    private int count;

    private ListNode dummy;

    private ListNode tail;

    private Map<Integer,ListNode> map;

    public LRUCache(int capacity){
        this.capacity = capacity;
        count = 0;
        dummy = new ListNode(0,0);
        tail = dummy;
        map = new HashMap<>();
    }

    private void removeHead(){
        map.remove(dummy.next.key);
        dummy.next = dummy.next.next;
        if(dummy.next !=null){
            dummy.next.prev = dummy;
        }
    }

    private void appengTail(ListNode node){
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }else {
            ListNode node = map.get(key);
            if(node!=tail){
                ListNode prev = node.prev;
                prev.next = node.next;
                prev.next.prev = prev;
                appengTail(node);
            }
            return node.value;
        }
    }

    public void put(int key,int value){
        ListNode node = new ListNode(key,value);
        if(map.containsKey(key)){
            ListNode temp = map.get(key);
            if(temp != tail){
                ListNode prev = temp.prev;
                prev.next = temp.next;
                prev.next.prev = prev;
            }else {
                tail = tail.prev;
            }
        }else {
            if(count < capacity){
                count++;
            }else {
                removeHead();
            }
        }
        appengTail(node);
        map.put(key,node);
    }
}