package com.deepika.DynamicProgramming.BuyAndSellStock;

public class StockWithTransactionFee {
    public static int fijndMaximumProfit(int[] arr,int transactionFee){
        int obcp=-arr[0];
        int obsp=0;
        for (int i=1;i<arr.length;i++){
            int nbcp=0;
            int nbsp=0;
            if (obsp-arr[i]>obcp){
                nbcp=obsp-arr[i];
            }
            else {
                nbcp=obcp;
            }
            if ((obcp+arr[i]-transactionFee)>obsp){
                nbsp=(obcp+arr[i]-transactionFee);

            }
            else {
                nbsp=obsp;
            }
            obcp=nbcp;
            obsp=nbsp;
        }
        return obsp;

    }
    public static void main(String[] args) {
        System.out.println(fijndMaximumProfit(new int[]{10,15,17,20,16,18,22,20,22,20,23,25},3));

    }
}
