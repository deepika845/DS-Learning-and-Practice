package com.deepika.problem.solving.Interviewquestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindMinSubArrayTarget {
    public static void put(Map<Integer, ArrayList<Integer>> mm , int key, int value){
        if(!mm.containsKey(key)){
            mm.put(key,new ArrayList<Integer>());
        }
        mm.get(key).add(value);
    }
    public static void findMinSubArray(int arr[],int target){
        Map<Integer,ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
        put(hm,0,-1);
        int sum = 0;
        int minlength=0;
        int minI=0;
        int minJ=0;
        for (int i=0;i<arr.length;i++){
            sum=sum+arr[i];
            int ll=sum-target;
            if(hm.containsKey(ll)){
                for (Integer index : hm.get(ll)){
                    if(minlength == 0 ){
                        minlength=i-index;
                    }
                    else if(i-index <minlength){
                        minlength = i- index;
                        minI = index+1;
                        minJ = i;
                    }
                }
            }
            put(hm,sum,i);
        }
        System.out.println("Min length : "+minlength);
        System.out.println("Starts at : " + minI);
        System.out.println("Ends at : "+minJ);

    }
    public static void main(String[] args) {
        int arr[] = {1,-2,4,1,2,-1,1};
        findMinSubArray(arr,3);

    }
}
