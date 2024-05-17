package com.liu.algorithm.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu
 */
public class MyArrayList<E>{
    /**
     * 存储数据的底层数组
     */
    private E[] data;
    /**
     *记录元素个数
     */
    private int size;
    /**
     * 默认初始容量
     */
    private static int INIT_CAPACITY = 10;

    public MyArrayList(int initCapacity){
        data = (E[])new Object[initCapacity];
        size = 0;
    }

    public MyArrayList(){
        this(INIT_CAPACITY);
    }

    public void addLast(E e) {
        int cap = data.length;
        if(cap == size){
            resize(cap * 2);
        }
        data[size++] = e;
    }

    public void add(int index, E e) {
        checkPositionIndex(index);

    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private void checkPositionIndex(int index) {
        if(!isPositionIndex(index)){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
    private void resize(int newCap) {
        E[] newData = (E[])new Object[newCap];
        for(int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }
    


    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
    }
}
