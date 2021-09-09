package com.LeetCode.Array;

public class CookQuestion {
    public static int findOperation(int[] arr,int start,int end){
        if(start==end ){
            return arr[start];
        }
        if(start>end){
            return 0;
        }
        int minIndex=findMinIndex(arr,start,end);
        int k=arr[minIndex];
        for(int i=start;i<=end;i++){
            arr[i]=arr[i]-k;
        }
        return k+findOperation(arr,start,minIndex-1)+findOperation(arr,minIndex+1,end);
    }

    private static int findMinIndex(int[] arr, int start, int end) {
        int minIndex=start;
        int minEle = arr[start];
        for (int i=start+1;i<=end;i++){
            if(arr[i]<minEle){
                minIndex=i;
                minEle=arr[i];
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        System.out.println( findOperation(new int[]{3,5,2,3,4},0,4));
    }
}
