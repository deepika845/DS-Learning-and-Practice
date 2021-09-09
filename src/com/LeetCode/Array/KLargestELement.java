package com.LeetCode.Array;

import java.util.ArrayList;

public class KLargestELement {
    public static ArrayList<Integer> kLargest(int arr[], int n, int k,int act)
    {
        // code here
        if(k==0){
            return null;
        }
        return partition(arr,n,0,n-1,n-k,k);//12345


    }
    public static ArrayList<Integer> partition(int[] arr,int n,int start,int end,int k,int act){

        if(k>=0&&k<=end-start){
            int pos=returnPosition(arr,start,end);
            if(pos+1==k){
                ArrayList<Integer> bc= new ArrayList<Integer>();
                for(int i=arr.length-act;i<arr.length;i++){
                    bc.add(arr[i]);

                }
                return bc;
            }
            if(pos+1<k){
                return partition(arr,n,pos+1,end,k,act);

            }
            else{
                return partition(arr,n,start,pos-1,pos-k+1,act);
            }

        }
        return null;
    }
    public static int returnPosition(int[] arr, int start,int end){
        int pivot=arr[end];
        int i=start-1;
        for(int j=start;j<end;j++){
            if(arr[j]<=pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[end];
        arr[end]=temp;
        return i+1;
    }

    public static void main(String[] args) {
        System.out.println(kLargest(new int[]{1, 23, 12, 9, 30, 2, 50},7,3,3));
    }
}
