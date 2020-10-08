package com.deepika.problem.solving.array;

public class KthLargest {
    public static int kthLargest(int[] arr,int k,int low,int high){
        if(low<high){
            int pivot=arr[low];
            int end=partition(arr,low,high,pivot);
            if(end==(arr.length-k)){
                return end;
            }
           int ff= kthLargest(arr,k,low,end-1);
            if(ff==(arr.length-k)){
                return ff;
            }
            int jj=kthLargest(arr,k,end+1,high);
            if(jj==(arr.length-k)){
                return jj;
            }
        }
        return -1;
    }
    public static int partition(int[] arr,int low,int high,int pivot){
        int start=low;
        int end=high;
        while (start<end){
        while (arr[start]<=pivot){
            start++;
        }
        while (arr[end]>pivot){
            end--;
        }
        if(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
        }
        }
        arr[low]=arr[end];
        arr[end]=pivot;
    return end;
    }

    public static void main(String[] args) {
        int arr[] =new int[]{3,5,2,9,8};
   int ind =kthLargest(arr,3,0,arr.length-1);
      System.out.println(ind!=-1?arr[ind] :-1);
    }
}
