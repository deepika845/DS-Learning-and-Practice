package com.deepika.DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestSubseqDiffOne {
    public static int findMaxLength(int arr[]){
        int[] dp= new int[arr.length];
        Arrays.fill(dp,1);
        int maxLen=Integer.MIN_VALUE;
        for (int i=1;i<dp.length;i++){
            for (int j=0;j<i;j++){
                if (Math.abs(arr[j]-arr[i])==1){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    maxLen=Math.max(maxLen,dp[i]);
                }
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{1,2,3,4,5}));

    }
}
