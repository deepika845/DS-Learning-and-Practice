package com.deepika.problem.solving.Interviewquestions;

public class FindMaxProduct {
    public static int findMaxProduct(int arr[][]){
        int minArray[][] = new int[arr.length][arr.length];
        int maxArray[][] = new int[arr.length][arr.length];
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length;j++){
                if (i==0 && j==0 ){
                    minArray[i][j]=arr[i][j];
                    maxArray[i][j]=arr[i][j];
                    continue;
                }
                int minValue = Integer.MAX_VALUE;
                int maxValue = Integer.MIN_VALUE;
                if(i>0){
                    int tempMax = Math.max(arr[i][j] * maxArray[i-1][j],arr[i][j] * minArray[i-1][j]);
                    maxValue =Math.max(maxValue,tempMax);
                    int tempMin = Math.min(arr[i][j]*maxArray[i-1][j],arr[i][j] * minArray[i-1][j]);
                    minValue = Math.min(minValue,tempMin);
                }
                if(j>0){
                    int tempMax = Math.max(arr[i][j] * maxArray[i][j-1],arr[i][j] * minArray[i][j-1]);
                    maxValue =Math.max(maxValue,tempMax);
                    int tempMin = Math.min(arr[i][j] * maxArray[i][j-1],arr[i][j] * minArray[i][j-1]);
                    minValue = Math.min(minValue,tempMin);
                }
                maxArray[i][j]=maxValue;
                minArray[i][j]=minValue;
            }
        }
        return maxArray[arr.length-1][arr.length-1];
    }
    public static void main(String[] args) {
        int arr[][] = {{-1,2,3},{4,5,-6},{7,8,9}};
        System.out.println(findMaxProduct(arr));
    }
}
