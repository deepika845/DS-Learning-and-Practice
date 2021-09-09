package com.LeetCode.Array;

public class JumpGame {
    public static boolean canReach(int[] arr, int start) {
        if(start>=0 && start<arr.length && arr[start]<arr.length){
            int jump=arr[start];
            arr[start]+=arr.length;
            return jump==0 || canReach(arr,start+arr[start])||canReach(arr,start-arr[start]);
        }
        return false;
    }

    public static void main(String[] args) {
        canReach(new int[]{4,2,3,0,3,1,2},5);
    }
}
