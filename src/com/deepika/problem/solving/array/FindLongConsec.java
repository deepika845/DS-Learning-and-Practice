package com.deepika.problem.solving.array;

import java.util.HashSet;

public class FindLongConsec {
    public static int findLongConsec(int arr[]){
        HashSet<Integer> hs = new HashSet<Integer>();
        int ans = 0;
        for(int i= 0 ;i<arr.length;i++ ){
            hs.add(arr[i]);
        }
        for (int j= 0;j<arr.length;j++){
            if(!hs.contains(arr[j] - 1)){
                int f = arr[j];
                while(hs.contains(f)){
                    f++;
                }
                if(ans < f - arr[j]){
                    ans = f - arr[j];
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,9,7,10,5,4,6,3};
        System.out.println(findLongConsec(arr));
    }
}
