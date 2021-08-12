package com.deepika.problem.solving.array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KLeastSorted {
    static int[] sortKMessedArray(int[] arr, int k) {
        // your code goes here
        if(arr.length==0 || k==0){
            return arr;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
        for(int i=0;i<=k;i++){
            pq.add(arr[i]);//1,4,5
        }
        int f=0;
        int res[]=new int[arr.length];
        for(int i=k+1;i<arr.length;i++){
            res[f++]=pq.poll();
            pq.add(arr[i]);
        }
        for(int curr=f;f<arr.length;curr++,f++){
            res[curr]=pq.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortKMessedArray(new int[]{1, 4, 5, 2, 3, 7, 8, 6, 10, 9},2)));
    }

}
