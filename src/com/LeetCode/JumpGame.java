package com.LeetCode;

public class JumpGame {
    public static int findMinJumps(int arr[]){
        int jumps=0;
        int currarthest=0;
        int currEnd=0;
        for(int i=0;i<arr.length;i++){
            currarthest=Math.max(currarthest,i+arr[i]);
            if(i==currEnd){
                jumps++;
                currEnd=currarthest;
            }
        }
        return jumps;
    }
    public static void main(String[] args) {
        findMinJumps(new int[]{2,3,1,1,4});
    }
}
