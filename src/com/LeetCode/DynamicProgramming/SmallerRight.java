package com.LeetCode.DynamicProgramming;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallerRight {
    public static void countSmaller(int[] nums) {
        int[] res = new int[nums.length];
        mergeSort(res, nums,0,nums.length-1);
        ArrayList<Integer> rew=new ArrayList<>();
        for(int i=0;i<res.length;i++){
            rew.add(res[i]);
        }
        //return Arrays.asList(res);
    }
    public static void mergeSort(int[] res,int[] nums,int start,int end){
        if(start==end){
            return;
        }
        int mid=(start+end)/2;
        if(start<end){

            mergeSort(res,nums,start,mid);
            mergeSort(res,nums,mid+1,end);
        }
        int n1=mid-start+1;
        int n2=end-mid;
        int l[]=new int[n1];
        int r[]=new int[n2];
        int i=start;
        int j=mid+1;
        for(int k=0;k<n1;k++){
            l[k]=nums[start+k];
        }
        for(int k=0;k<n2;k++){
            r[k]=nums[mid+1+k];
        }

        while(i<=mid && j<=end){
            if(l[i-mid>0?i-mid:i]>r[j-(mid+1)]){
                for(int f= (i-mid>0?i-mid:i);f<=mid;f++){
                    res[f]++;
                }
                j++;
            }
          else {
              i++;
            }
        }

    }

    public static void main(String[] args) {
        countSmaller(new int[]{5,2,6,1});
    }

}
