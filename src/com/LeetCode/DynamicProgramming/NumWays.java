package com.LeetCode.DynamicProgramming;


import java.util.Scanner;

public class NumWays {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n=Integer.parseInt(s.nextLine());
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        int currEnd= 0;
        int currFarthest=0;
        int jumps=0;
        for(int i=0;i<n;i++){
            currFarthest=Math.max(currFarthest,i+arr[i]);
            if(currEnd==i){
                currEnd=currFarthest;
                jumps++;
            }

        }
        System.out.println(jumps);
    }
}
