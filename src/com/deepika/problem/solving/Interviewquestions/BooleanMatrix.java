package com.deepika.problem.solving.Interviewquestions;

import java.util.Arrays;

public class BooleanMatrix {
    public static void setMatrix(boolean arr[][]){
        int row[] = new int[arr.length];
        int max= 0;
        for (int i = 0;i<arr.length;i++){
            if(arr[i].length>max){
                max = arr[i].length;
            }
        }
        int col[] = new int[max];
        for(int i=0;i<arr.length;i++){
            row[i]= 0;
        }
        for(int j=0;j<col.length ; j++){
            col[j]=0;
        }
        for(int i = 0;i < arr.length ; i++ ){
            for (int j = 0;j<arr[i].length;j++){
            if(arr[i][j]){
                row[i]=1;
                col[j]=1;
            }
            }
        }
        for (int i = 0;i<arr.length;i++){
            for (int j = 0;j<arr[i].length;j++){
                if(row[i]== 1 || col[j]==1){
                    arr[i][j] = true;
                }
            }
        }
    }
    public static void setAnArray(int arr[][]){
        boolean rowFlag = false;
        boolean colFlag = false;
        for (int i= 0;i<arr.length;i++){
            for (int j= 0 ; j <arr[i].length;j++){
                if(i==0  && arr[i][j]==1){
                    rowFlag = true;
                }
                if(j==0 && arr[i][j]==1){
                    colFlag = true;
                }
                if(arr[i][j] == 1){
                    arr[i][0]=1;
                    if(j<arr[arr.length - 1].length)
                      arr[0][j]=1;
                }
            }
        }
        for(int i = 0;i<arr.length;i++){
            for (int j= 0 ;j<arr[i].length;j++){
                if(arr[i][0]==1 || arr[0][j]==1){
                    arr[i][j]=1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[][] = {{1,0,0,1},{0,0},{1,0,1,0,1}};
       // setMatrix(arr);
        setAnArray(arr);
        for (int i = 0;i<arr.length;i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
