package com.deepika.problem.solving.Interviewquestions;

import java.util.Arrays;

public class MergeTwoSortNa {
    public static void mergeIt(int arr[],int arr1[],int m,int n){
        int a1 = m-1;
        int a2=n-1;
        int lastIndex = m+n-1;
        while(a2 >= 0){
            if(a1>=0 && arr[a1]>arr1[a2]){
                arr[lastIndex] = arr[a1];
                a1--;
            }
            else if(arr1[a2] > arr[a1]){
                arr[lastIndex]=arr1[a2];
                a2--;
            }
            lastIndex--;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,3,5,0,0,0};
        int arr1[]={2,4,6};
        mergeIt(arr,arr1,3,3);
        System.out.println(Arrays.toString(arr));
    }
}
