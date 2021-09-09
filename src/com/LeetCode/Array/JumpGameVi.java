package com.LeetCode.Array;

public class JumpGameVi {
    public static int maxResult(int[] nums, int k) {
        int start=0;
        int max=nums[start];
        int dp[]=new int[nums.length];
        max=maxDFS(dp,nums,0,k);
        return max;
    }
    public static int maxDFS(int[] dp,int[] arr,int j,int k){
        if(dp[j]!=0){
            return dp[j];
        }
        int max=Integer.MIN_VALUE;
        for(int i=j+1;i<=Math.min(j+k,arr.length-1);i++){
            int max1=maxDFS(dp,arr,i,k);
            max=Math.max(max,max1+arr[j]);
        }
        return dp[j]=(max==Integer.MIN_VALUE)?arr[j]:max;
    }

    public static void main(String[] args) {
        System.out.println( maxResult(new int[]{1,-5,-20,4,-1,3,-6,-3},2));
    }
}
