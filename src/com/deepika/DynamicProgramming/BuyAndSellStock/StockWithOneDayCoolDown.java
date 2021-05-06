package com.deepika.DynamicProgramming.BuyAndSellStock;

public class StockWithOneDayCoolDown {
    public static int findMaxProfit(int[] arr){
        int obbp=-arr[0];
        int obsp=0;
        int obcp=0;
        for (int i=1;i<arr.length;i++){
            int nbbp=0;
            int nbsp=0;
            int nbcp=0;
            if (obcp-arr[i]>obbp){
                nbbp=obcp-arr[i];
            }
            else {
                nbbp=obbp;
            }
            if (obbp+arr[i]>obsp){
                nbsp=obbp+arr[i];
            }
            else {
                nbsp=obsp;
            }
            if (obcp>obsp){
                nbcp=obcp;
            }
            else {
                nbcp=obsp;
            }
            obbp=nbbp;
            obcp=nbcp;
            obsp=nbsp;
        }
        return obsp;

    }
    public static void main(String[] args) {
        System.out.println(findMaxProfit(new int[]{10,50,5,30,45,56}));

    }
}
