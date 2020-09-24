package com.deepika.problem.solving.Heaps;

//import sun.util.resources.cldr.ext.CurrencyNames_ug;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SortingKsortedList {

    static class CurrentStatus implements Comparator<CurrentStatus>{
        int arr[];
        int index;
        CurrentStatus(int arr[],int index){
            this.arr=arr;
            this.index=index;
        }
        CurrentStatus(){

        }

        @Override
        public int compare(CurrentStatus currentStatus, CurrentStatus t1) {
            return currentStatus.arr[currentStatus.index]-t1.arr[t1.index];
        }
    }
    public static void main(String[] args) {
        int allSorted[][]={{3,4,9},{5,14},{7,8,13}};
     int result[]= returnTheWhole(allSorted);
      System.out.println(Arrays.toString(result));


    }

    private static int[] returnTheWhole(int[][] allSorted) {
        PriorityQueue<CurrentStatus> pp = new PriorityQueue<CurrentStatus>(allSorted.length,new CurrentStatus());
        int res=0;
        //int ss = allSorted.length*allSorted[0].length;
        int result[]=new int[8];
        int i=0;
        while (i<allSorted.length){
            pp.add(new CurrentStatus(allSorted[i++],0));
        }
        while (!pp.isEmpty()){
            CurrentStatus polled=pp.poll();
            result[res++]=polled.arr[polled.index];
            if(polled.index<polled.arr.length-1){
                pp.add(new CurrentStatus(polled.arr,polled.index+1));
            }
        }
        return result;
    }
}
