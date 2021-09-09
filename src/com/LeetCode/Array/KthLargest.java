package com.LeetCode.Array;

public class KthLargest {
    public static int findKthLargest(int[] nums, int k) {
        k=nums.length-k;
        int lo=0;
        int hi=nums.length-1;
        while(lo<=hi){
            int j=partition(nums,lo,hi);
            if(j<k){
                lo=j+1;
            }
            else if (j>k){
                hi=j-1;
            }
            else{
                break;
            }
        }
        return nums[k];
    }
    public  static int partition(int[] arr,int lo1,int hi1){
        int lo=lo1;
        int hi=hi1;
        int pivot=arr[lo];
        while(lo<hi){
            while(lo<arr.length&&arr[lo]<=pivot){
                lo++;
            }
            while(hi>=0&&arr[hi]>pivot){
                hi--;
            }
            if(lo<hi){
                int temp=arr[lo];
                arr[lo]=arr[hi];
                arr[hi]=temp;
            }
            else{
                break;
            }
        }
        int temp=arr[hi];
        arr[hi]=pivot;
        arr[lo1]=temp;
        return hi;

    }
    public static void main(String[] args) {
       findKthLargest(new int[]{2,1},1);
    }
}
