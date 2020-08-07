package com.deepika.problem.solving.Interviewquestions;

import java.util.Arrays;
import java.util.Collections;

public class LongestIncreasingSubsequence {
    public static int findLongestIncreasingConsequence(int arr[]){
        int dpArr[] =new int[arr.length];
        for (int i=0;i<arr.length;i++){
            dpArr[i] = 1;
        }
        int j = 0;
        for(int  i = 1; i< arr.length;i++){
            j = 0;
            while (j<i){
            if(arr[j] < arr[i] ){
                if(dpArr[i] <dpArr[j]+1){
                    dpArr[i] = dpArr[j]+1;
                }
            }
            j=j+1;
            }
        }
        int min = Integer.MIN_VALUE;
        for (int i=0;i<dpArr.length;i++){
            if(dpArr[i]>min){
                min = dpArr[i];
            }
        }
        return min;

    }
    public static void main(String[] args) {
        System.out.println(findLongestIncreasingConsequence(new int[]{50, 3, 10, 7, 40, 80}));
    }
}
