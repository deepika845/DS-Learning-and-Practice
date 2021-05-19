package com.deepika.DynamicProgramming.BuyAndSellStock;

public class StockWithTwoTransaction {
    public static int findMaxProfit(int[] arr){
        int lsf=arr[0];
        int maxProfit[]=new int[arr.length];
        for (int i=1;i<arr.length;i++){
            if (lsf<arr[i]){
                maxProfit[i]=Math.max(maxProfit[i-1],(arr[i]-lsf));
            }
            else {
                lsf=arr[i];
            }
        }
        int[] maxProfit1= new int[arr.length];
        int msf= arr[arr.length-1];
        for (int i=arr.length-2;i>=0;i--){
            if (msf>arr[i]){
                maxProfit1[i]=Math.max(maxProfit1[i+1],msf-arr[i]);
            }
            else {
                msf=arr[i];
                maxProfit1[i]=maxProfit1[i+1];
            }
        }
        int mxRes=0;
        for (int i=0;i<arr.length;i++){
            mxRes=Math.max(maxProfit[i]+maxProfit1[i],mxRes);
        }
        return mxRes;
    }
    public static void main(String[] args) {

        System.out.println( findMaxProfit(new int[]{3,10,20,30}));

    }
}
