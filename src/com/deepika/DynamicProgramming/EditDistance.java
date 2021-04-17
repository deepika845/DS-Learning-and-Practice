package com.deepika.DynamicProgramming;

public class EditDistance {
    public static void main(String[] args) {
        System.out.println(findMinOperations("sunday","saturday"));
    }

    private static int findMinOperations(String source, String target) {
        int dp[][] = new int[source.length()+1][target.length()+1];
        for (int i=0;i<=source.length();i++){
            for (int j=0;j<=target.length();j++){
                if (i==0){
                    dp[i][j]=j;
                }
                else if (j==0){
                    dp[i][j]=i;
                }
                else if(source.charAt(i-1)==target.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else {
                    dp[i][j]=Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1])+1;
                }
            }
        }
        return dp[source.length()][target.length()];
    }
}
