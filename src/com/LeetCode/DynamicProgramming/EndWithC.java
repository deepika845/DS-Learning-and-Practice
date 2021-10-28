package com.LeetCode.DynamicProgramming;

import java.util.Scanner;

public class EndWithC {
    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);
        int n= s.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        int include=Math.max(arr[0],0);
        int exclude=0;
        for(int i=1;i<arr.length;i++){
            int ninclude=exclude+arr[i];
            int nexclude=Math.max(exclude,include);
            include=Math.max(include,ninclude);
            exclude=nexclude;

        }
        System.out.println(Math.max(include,exclude));
}}
