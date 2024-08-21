package com.liu.algorithm.system.sort;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

public class Check {

    private static Random random = new Random();


    public static void arrayCheck(int times,int len,int max,Sort sort) {
        for (int t = 0; t < times; t++) {
            int[] arr = generateRandomArray(len,max);
            int[] copy = Arrays.copyOf(arr,arr.length);
            Arrays.sort(copy);
            sort.sort(arr);
            if(!Arrays.equals(arr,copy)){
                System.out.println("出错数组"+Arrays.toString(arr));
                break;
            }
        }
    }

    public static int[] generateRandomArray(int len, int max) {
        int length = random.nextInt(len)+1;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(max);
        }
        return arr;
    }






    public static void main(String[] args) {
        arrayCheck(500,7,7,new MergeSort());
    }
}
