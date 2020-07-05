package com.deepika.problem.solving.Heaps;

import java.util.Arrays;

public class MakeMinToMax {
    public static void sortTheArray(int arr[]){
        int n = arr.length;
        for (int i=(n/2 - 1);i>=0;i--){
            heapify(arr,n,i);
        }
    }
    public static void heapify(int arr[] ,int n,int i){
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
        if(l<n && arr[largest]<arr[l]){
            largest=l;
        }
        if(r<n && arr[r] > arr[largest]){
            largest = r;
        }
        if(largest!=i){
            int temp = arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;
            heapify(arr,n,largest);
        }
    }
    public static void main(String[] args) {
        int arr[] = {3,5,9,6,8,20,10,12,18,9};
        sortTheArray(arr);
        System.out.println(Arrays.toString(arr));

    }
}
