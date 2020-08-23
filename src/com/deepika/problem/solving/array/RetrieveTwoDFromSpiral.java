package com.deepika.problem.solving.array;

import java.util.Arrays;
import java.util.Scanner;

public class RetrieveTwoDFromSpiral {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int arr1[][] = findArray(arr);
        for (int i=0;i<arr1.length;i++){
            System.out.println(Arrays.toString(arr1[i]));
        }
    }

    private static int[][] findArray(int[] arr) {
        double k = Math.sqrt(arr.length);
        int row = (int)k;
        int col =(int)k;
        int array[][]=new int[row][col];
        int l=0;
        int m=0;
        int i=0;
        int d=0;
        while (l<row && m<col){
            for (i=m;i<col;i++){
                array[l][i]=arr[d++];
            }
            l++;
            for (i= l; i<row; i++){
                array[i][col-1]=arr[d++];
            }
            col--;
            for (i=col-1;i>=m;i--){
                array[row-1][i]=arr[d++];
            }
            row--;
            for (i=row-1;i>=l;i--){
                array[i][m]=arr[d++];
            }
            m++;

        }
        return array;

    }
}
