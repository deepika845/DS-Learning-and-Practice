package com.deepika.DynamicProgramming;

public class SubSequenceProductLessTanK {
    public static int findAllSubsequendProductLessThankK(int[] arr,int k){
        int dp[][]= new int[k+1][arr.length+1];
        for (int i=1;i<=k;i++){
            for (int j=1;j<=arr.length;j++){
                dp[i][j]=dp[i][j-1];
                if (arr[j-1]<=i && arr[j-1]>0){
                    dp[i][j]+=dp[i/arr[j-1]][j-1]+1;
                }
            }
        }
        return dp[k][arr.length];
    }
    public static void main(String[] args) {
        System.out.println(findAllSubsequendProductLessThankK(new int[]{4,8,7,2},50));

    }
}
