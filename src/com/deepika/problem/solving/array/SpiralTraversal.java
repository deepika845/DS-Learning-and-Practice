package com.deepika.problem.solving.array;

public class SpiralTraversal {
    public void findSpiralTraversal(int arr[][],int row,int col) {
        int k = 0;
        int l=0;
        int i = 0;
        while (k<row && l<col){
            for (i =l;i<col;i++){
                System.out.println(arr[k][i]);

            }
            k++;
            for (i=k;i<row;i++){
                System.out.println(arr[i][col-1]);
            }
            col--;
            for (i=col-1;i>=l;i--){
                System.out.println(arr[row-1][i]);

            }
            row--;
            for (i=row-1;i>=k;i--){
                System.out.println(arr[i][l]);
            }
            l++;
        }
    }

    public static void main(String[] args) {
        SpiralTraversal ss = new SpiralTraversal();
        ss.findSpiralTraversal(new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        },4,4);

    }
}
