package com.deepika.problem.solving.Interviewquestions;

public class MaxSizeSquareArrayOne {
    public static int returnMaxSize(int arr[][]){
        int ss[][] = new int[arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++){
            ss[i][0]=arr[i][0];
        }
        for (int j= 0;j<arr[0].length;j++){
            ss[0][j]=arr[0][j];
        }
        for(int i=1;i<arr.length;i++){
            for(int j= 1;j<arr[0].length;j++){
                if(arr[i][j] == 1){
                    ss[i][j] = Math.min(arr[i-1][j],(Math.min(arr[i][j-1],arr[i-1][j-1])))+1;
                }
                else{
                    ss[i][j]=0;
                }
            }
        }
        int max = ss[0][0];
        for (int i=1;i<ss.length;i++){
            for (int j=1;j<ss[0].length;j++){
                if(ss[i][j]>max){
                    max  = ss[i][j];
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int arr[][] = {{1,0,1,1},{0,1,1,0},{1,1,1,0},{0,1,0,1}};
        System.out.println(returnMaxSize(arr));

    }
}
