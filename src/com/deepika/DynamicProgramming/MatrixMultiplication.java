package com.deepika.DynamicProgramming;

public class MatrixMultiplication {
    public long matrixDynamicProgramming(int[] arr){
        int[][] matrMaintained= new int[arr.length-1][arr.length-1];
        for (int g=0;g<matrMaintained.length;g++){
            for (int i=0,j=g;i<matrMaintained.length&&j<matrMaintained[i].length;i++,j++){
                if (g==0){
                    matrMaintained[i][j]=0;
                }
                else if (g==1){
                    matrMaintained[i][j]=arr[i]*arr[j]*arr[j+1];
                }
                else {
                    int max= Integer.MAX_VALUE;
                    for (int k=i;k<j;k++ ){
                        max=Math.min(max,(arr[i]*arr[k+1]*arr[j+1])+matrMaintained[i][k]+matrMaintained[k+1][j]);
                    }
                    matrMaintained[i][j]=max;
                }
            }
        }
        return matrMaintained[0][matrMaintained[0].length-1];

    }
    public static void main(String[] args) {
        MatrixMultiplication mt = new MatrixMultiplication();
        System.out.println(mt.matrixDynamicProgramming(new int[]{10,20,30,40,30}));

    }
}
