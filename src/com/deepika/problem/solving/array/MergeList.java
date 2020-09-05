package com.deepika.problem.solving.array;

import java.util.Arrays;

public class MergeList {


    public static void main(String[] args) {
        int arr[]={3,2,5,4,-1,0};
         mergeSortTheArray(arr,0,5);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSortTheArray(int[] ints,int start,int end) {

        if(start<end){
            int mid = (start+end)/2;
          mergeSortTheArray(ints,start,mid);
          mergeSortTheArray(ints,mid+1,end);
          mergeTheArray(ints,start,mid,end);

        }
    }

    private static void mergeTheArray(int[] ints, int start, int mid, int end) {
        int temp[] = new int[end-start+1];
        int i = start;
        int j=mid+1;
        int k=0;
        while (i<=mid && j<=end){
            if(ints[i]<ints[j]){
                temp[k]=ints[i];
                k++;
                i++;
            }
            else{
                temp[k]=ints[j];
                k++;
                j++;
            }
        }
        if(j>=end){
            while (i<=mid){
                temp[k]=ints[i];
                i++;
                k++;
            }
        }
        if(i>=mid){
            while (j<=end){
                temp[k]=ints[j];
                j++;
                k++;
            }
        }
        for(int h=start;h<=end;h++){
            ints[h]=temp[h-start];
        }
    }

}
