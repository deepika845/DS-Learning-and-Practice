package com.deepika.problem.solving.Heaps;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class KSortedArray {
    public static void kSortArray(int arr[] ,int n,int k){
        PriorityQueue<Integer> pp = new PriorityQueue<Integer>();
        for(int i=0;i<k+1;i++){
            pp.add(arr[i]);
        }
        int index=0;
        for (int j=k+1;j<n;j++){
            arr[index++] = pp.poll();
            pp.add(arr[j]);
        }
        Iterator<Integer> i = pp.iterator();
        while (i.hasNext()){
            arr[index++]=pp.poll();
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int arr[] ={2,5,1,6,3,9,4,7,8};
        kSortArray(arr,arr.length,3);
    }
}
