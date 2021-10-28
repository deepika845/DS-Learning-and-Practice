package com.LeetCode.DynamicProgramming;

import java.util.Arrays;

public class MinCoinChange {
    public static int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length+1][amount+1];
        for(int i=0;i< dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int f=0;
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
                if(coins[i-1]==j){
                    dp[i][j]=1;
                }

                else if(coins[i-1]>j){

                    dp[i][j]=dp[i-1][j];
                }
                else{
                    if(dp[i][j-coins[i-1]]==-1){
                        dp[i][j]=dp[i-1][j];
                    }

                    else if(i!=1){
                        dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);

                    }
                    else{
                        dp[i][j]=dp[i][j-coins[i-1]]+1;

                    }

                }
                f=dp[i][j];
            }
        }
        return dp[coins.length][amount];

    }

    public static void main(String[] args) {
      coinChange(new int[]{2,5,10,1},27);

    }
}
