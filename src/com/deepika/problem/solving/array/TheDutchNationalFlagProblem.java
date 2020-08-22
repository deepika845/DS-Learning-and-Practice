package com.deepika.problem.solving.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TheDutchNationalFlagProblem {
    public static ArrayList<Integer> sortTnroughPivot(int arr[], int pivot,int start){
        if(start==arr.length-1){
            ArrayList<Integer> br = new ArrayList<Integer>();
            if(arr[start]==pivot){
                br.add(start);
            }
            return br;
        }
        //ArrayList<Integer> mr = new ArrayList<>();

        ArrayList<Integer> rr = sortTnroughPivot(arr,pivot,start+1);
        //mr.addAll(rr);
        if(arr[start] == pivot){
            rr.add(start);
        }
        return rr;

    }
    public static void theDutchNationalFlag(int arr[] , int high,int low){
    }

    public static void main(String[] args) {
        int arr[] =new int[]{1,2,3,4,1,2,3};
        ArrayList<Integer> kk = sortTnroughPivot(arr,2,0);
        System.out.println(kk);
        int high = Collections.max(kk);
        int low = Collections.min(kk);
        System.out.println(high + " "+low);
        theDutchNationalFlag(arr,high,low);
        System.out.println(Arrays.toString(arr));
    }

}
