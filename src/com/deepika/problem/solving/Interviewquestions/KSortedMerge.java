package com.deepika.problem.solving.Interviewquestions;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KSortedMerge {
    public static int[] makeAllArraySort(int arr[][]){
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        int total = 0 ;
        for (int i=0;i<arr.length;i++){
            pq.add(new Pair(arr[i],0));
            total+=arr[i].length;
        }
        int result[]  = new int[total];
        int index = 0;
        while (!pq.isEmpty()){
            Pair pp = pq.poll();
            result[index++]=pp.arr[pp.index];
            if(pp.index<pp.arr.length-1){
                pq.add(new Pair(pp.arr,pp.index+1));
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] arr = {{1,3,8},{2,4,9,11},{5,6,7}};
        int res[]=makeAllArraySort(arr);
        System.out.println(Arrays.toString(res));

    }
    static class Pair implements Comparable<Pair>{
        int arr[];
        int index;
        Pair(int arr[],int index){
            this.arr=arr;
            this.index=index;
        }
        @Override
        public int compareTo(Pair o) {
            return this.arr[index]-o.arr[o.index];
        }
    }
}
