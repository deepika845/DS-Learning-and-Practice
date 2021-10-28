package com.LeetCode.DynamicProgramming;

public class CountSquares {
    public static int countSquares(int[][] matrix) {
        int curr=-1;
        int[][] dp= new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(i==0||j==0){
                    dp[i][j]=matrix[i][j];
                }
                else if(matrix[i][j]==1){
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                }
                else{
                    dp[i][j]=0;
                }
                curr=dp[i][j];
            }
        }
        int sum=0;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                if(dp[i][j]>1){
                    sum+=dp[i][j];
                }
                else if(dp[i][j]==1){
                    sum+=1;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
       countSquares(new int[][]{{0,1,1,1},{1,1,1,1},{0,1,1,1}});
    }
}
