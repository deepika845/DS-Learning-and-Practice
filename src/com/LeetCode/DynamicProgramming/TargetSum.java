package com.LeetCode.DynamicProgramming;

import java.util.Scanner;

public class TargetSum {
    public static void main(String[] args) {


    Scanner s = new Scanner(System.in);
    int n=Integer.parseInt(s.nextLine());
    int[] arr= new int[n];
        for(int i=0;i<n;i++){
        arr[i]=s.nextInt();
    }
    int tar=s.nextInt();
    boolean[][] dp=new boolean[n+1][tar+1];
    boolean res=false;
    int curr=-1;
        for(int i=0;i<=n;i++){
        dp[i][0]=true;
    }
        for(int i=1;i<=n;i++){
        for(int j=1;j<=tar;j++){
            if(dp[i-1][j]){
                dp[i][j]=dp[i-1][j];
            }
            else{
                if(j>=arr[i-1]) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]];
                    curr=j-arr[i-1];
                }
            }
            res=dp[i][j];
        }
    }
        System.out.println(dp[n][tar]);
}}
