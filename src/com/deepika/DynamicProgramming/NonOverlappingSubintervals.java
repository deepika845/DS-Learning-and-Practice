package com.deepika.DynamicProgramming;

import java.io.*;
import java.util.*;

public class NonOverlappingSubintervals {
    static class Bridge implements Comparable<Bridge>{
        int start;
        int end;
        Bridge(int start,int end){
            this.start=start;
            this.end=end;
        }
        public int compareTo(Bridge o1){
            if(this.start!=o1.start){
                return this.start-o1.start;
            }
            return this.end-o1.end;
        }
    }


    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n=Integer.parseInt(s.nextLine());
        Bridge[] btr = new Bridge[n];
        for(int i=0;i<n;i++){
            String str=s.nextLine();
            String[] atr=str.split(" ");
            int a1=Integer.parseInt(atr[0]);
            int a2=Integer.parseInt(atr[1]);
            btr[i]=new Bridge(a1,a2);
        }
        Arrays.sort(btr );
        int[] dp= new int[n];
        int maxBridge=0;
        for(int i=0;i<n;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(btr[j].end<btr[i].end){
                    if(max<dp[j]){
                        max=dp[j];
                    }
                }
            }
            dp[i]=max+1;
            maxBridge=Math.max(maxBridge,dp[i]);
        }
        System.out.println(maxBridge);


    }

}
