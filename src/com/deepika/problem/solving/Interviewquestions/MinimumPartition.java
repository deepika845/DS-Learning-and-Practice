package com.deepika.problem.solving.Interviewquestions;

public class MinimumPartition {
    public static int findMinPartition(int arr[]){
            int range = 0;
            for(int i = 0;i<arr.length;i++){
                range+=arr[i];
            }
            int dpArr[][] = new int[arr.length+1][range+1];
            for (int i = 0;i<dpArr.length;i++){
                for (int j=0;j<dpArr[0].length;j++){
                    if (i==0 || j==0){
                        dpArr[i][j] = 0;
                        continue;
                    }
                    if (arr[i-1] == j){
                        dpArr[i][j]=1;
                    }
                    else {
                        if(arr[i-1]<j){
                            if(dpArr[i-1][j] == 1){
                                dpArr[i][j]=dpArr[i-1][j];
                                continue;
                            }
                            dpArr[i][j] = dpArr[i-1][j-arr[i-1]];
                        }
                        if (arr[i-1]>j){
                            if(dpArr[i-1][j]==1){
                                dpArr[i][j] = dpArr[i-1][j];
                            }
                           }}}}
                                    int min = Integer.MAX_VALUE;
                                    for (int i=0;i<(dpArr[0].length + 1)/2;i++){
                                        if(dpArr[arr.length][i]==1){
                                            if(range-(2*i) < min){
                                                min = range - 2*i;
                                            }
                                        }
                                    }
                                    return min;}

    public static void main(String[] args) {
        System.out.println( findMinPartition(new int[]{1,6,11,5}));
    }
}
