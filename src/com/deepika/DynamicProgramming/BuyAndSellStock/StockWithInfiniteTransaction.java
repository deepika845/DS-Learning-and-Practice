package com.deepika.DynamicProgramming.BuyAndSellStock;

public class StockWithInfiniteTransaction {
    public static int findMaximumProfit(int[] arr){
        int bt=arr[0];
        int si=arr[0];
        int maxProfit=0;
        for (int i=1;i<arr.length;i++){
            if (si<arr[i]){
                si=arr[i];
            }
            else {
                maxProfit+=(si-bt);
                bt=arr[i];
                si=arr[i];
            }



        }
        maxProfit+=(si-bt);
        return maxProfit;
    }
    public static void main(String[] args) {
        System.out.println(findMaximumProfit(new int[]{1,3,4,2,4}));

    }
}
