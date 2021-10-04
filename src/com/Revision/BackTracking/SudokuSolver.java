package com.Revision.BackTracking;
import java.util.*;
public class SudokuSolver {
    // import java.io.*;


        public static void display(int[][] board){
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }

        public static boolean solveSudoku(int[][] board, int i, int j) {
            // write your code here
            if(j==board[i].length){
                j=0;
                i=i+1;
            }
            if(i==board.length){
                display(board);
                return true;
            }
            if(board[i][j]==0){
            for(int d=1;d<=9;d++){
                if(isSafe(board,i,j,d)){
                    board[i][j]=d;
                    if(solveSudoku(board,i,j+1)){
                        return true;
                    }
                    board[i][j]=0;
                }
            }
            }
            else{
                return solveSudoku(board,i,j+1);
            }
            return false;

        }
        public static boolean isSafe(int[][] board,int row,int col, int d){
            return isSafeRow(board,row,d) && isSafeCol(board,col,d) && isSafeBox(board,row-row%3,col-col%3,d);
        }
        public static boolean isSafeRow(int[][] arr, int row,int d){
            HashSet<Integer> hm= new HashSet<Integer>();
            for(int i=0;i<arr[row].length;i++){
                if(hm.contains(d)){
                    return false;
                }
                if(arr[row][i]!=0){
                    hm.add(arr[row][i]);
                }
            }
            return true;
        }
        public static boolean isSafeCol(int[][] arr, int col,int d){
            HashSet<Integer> hm= new HashSet<Integer>();
            for(int i=0;i<arr.length;i++){
                if(hm.contains(d)){
                    return false;
                }
                if(arr[i][col]!=0){
                    hm.add(arr[i][col]);
                }
            }
            return true;
        }
        public static boolean isSafeBox(int[][] arr, int row,int col,int d){
            HashSet<Integer> hm= new HashSet<Integer>();
            for(int i=row;i<row+3;i++){
                for(int j=col;j<col+3;j++){
                    if(hm.contains(d)){
                        return false;
                    }
                    if(arr[i][j]!=0){
                        hm.add(arr[i][j]);
                    }
                }
            }
            return true;
        }
        /*
3 0 6 5 0 8 4 0 0
5 2 0 0 0 0 0 0 0
0 8 7 0 0 0 0 3 1
0 0 3 0 1 0 0 8 0
9 0 0 8 6 3 0 0 5
0 5 0 0 9 0 6 0 0
1 3 0 0 0 0 2 5 0
0 0 0 0 0 0 0 7 4
0 0 5 2 0 6 3 0 0
*/

        public static void main(String[] args) throws Exception {
//            Scanner scn = new Scanner(System.in);
//            int[][] arr = new int[9][9];
//            for (int i = 0; i < 9; i++) {
//                for (int j = 0; j < 9; j++) {
//                    arr[i][j] = scn.nextInt();
//                }
//            }
            int[][] arr= {{3,0, 6, 5, 0, 8, 4, 0, 0},
                    {5 ,2 ,0 ,0 ,0 ,0 ,0 ,0 ,0},
                    {0, 8, 7, 0, 0, 0, 0, 3, 1},
                    {0 ,0 ,3 ,0 ,1 ,0 ,0 ,8 ,0},
                    {9, 0, 0, 8, 6, 3, 0, 0, 5},
                    {0 ,5 ,0 ,0 ,9 ,0 ,6 ,0 ,0},
                    {1, 3, 0, 0, 0, 0, 2, 5, 0},
                    {0 ,0 ,0 ,0 ,0 ,0 ,0 ,7 ,4},
                    {0 ,0 ,5 ,2 ,0 ,6 ,3 ,0 ,0}};
            solveSudoku(arr,0,0);
            }

        }


