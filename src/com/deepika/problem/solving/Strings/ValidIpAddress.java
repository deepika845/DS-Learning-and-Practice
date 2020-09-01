package com.deepika.problem.solving.Strings;

public class Histogram {
    public int findMaxArea(int arr[]){
        int max_above=arr[0];
        int max_tillNow=arr[0];
        int min=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                if(min*(i+1)>max_tillNow){
                    max_tillNow=min*(i+1);
                }
                else{
                    if(arr[i]<arr[i+1]){
                        min=arr[i];
                        
                    }
                }
            }

        }

    }
}
