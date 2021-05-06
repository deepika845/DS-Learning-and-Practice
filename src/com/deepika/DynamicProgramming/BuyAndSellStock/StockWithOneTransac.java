package com.deepika.DynamicProgramming.BuyAndSellStock;

import java.util.Scanner;

public class StockWithOneTransac {
    public static int findMaximumProfit(int[] arr){
        int min=arr[0];
        int max=Integer.MIN_VALUE;
        for (int i=1;i<arr.length;i++){
            if (arr[i]>min){
                max=Math.max(max,arr[i]-min);
            }
            else {
                min=arr[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        int n=s.nextInt();
//        int[] prf=new int[n];
//        for (int i=0;i<n;i++){
//            prf[i]=s.nextInt();
//        }
        System.out.println( findMaximumProfit(new int[]{3,2,1,5,3,9}));

    }
}
