package com.deepika.DynamicProgramming;

public class MinCoinChange {
    public static int findNoWays(int arr[],int n){
        int dparr[][] = new int[arr.length][n+1];
        for (int i=0 ; i <arr.length ; i++ ){
            dparr[i][0]=1;
        }
        for (int i=1;i<dparr[0].length;i++){
            if(i % arr[0] ==0 ){
                dparr[0][i]=1;
            }
            else {
                dparr[0][i]=0;
            }
        }
        for (int i=1;i<dparr.length;i++){
            for (int j=1;j<dparr[i].length;j++){
                if(arr[i]>j){
                    dparr[i][j]=dparr[i-1][j];
                }
                else {
                    dparr[i][j]=dparr[i-1][j]+dparr[i][j-arr[i]];
                }
            }
        }
        return dparr[arr.length-1][n];
    }
    public static void main(String[] args) {
        int arr[] = {2,3,5};
        System.out.println(findNoWays(arr,5));

    }
}
