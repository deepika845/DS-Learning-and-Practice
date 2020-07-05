package com.deepika.problem.solving.Coursera;

import java.util.*;
class FindMinCoin{
    public static int returnMin(int sum,int i){
        if(sum == i){
            return 1;
        }
        if(sum<i){
            return 1;
        }
        return 1 + returnMin(sum-i,i+1);
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int arr[] = new int[x];
        for(int i=0;i<x;i++){
            int first = s.nextInt();
            arr[i] = returnMin(first,1);
        }
        for (int i=0;i<x;i++){
            System.out.println(arr[i]);
        }
    }
}