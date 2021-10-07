package com.deepika.DynamicProgramming;
import java.io.*;
import java.util.*;

public class Topological {

    public static void nQueen(boolean[][] board,int row){
        if(row==board.length){
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[i].length;j++){
                    if(board[i][j]){
                        System.out.print(i+"-"+j+", ");

                    }
                }
            }}
            for(int j=0;j<board[row].length;j++){
                if(isSafe(board,row,j)){
                    board[row][j]=true;
                    nQueen(board,row+1);

                    board[row][j]=false;
                }
            }

        }
    
        public static boolean isSafe(boolean[][] board,int row,int j){
            for(int i=row-1;i>=0;i--){
                if(board[i][j]){
                    return false;
                }
            }
            for(int i=row-1,k=j-1;i>=0&&k>=0;i--,k--){
                if(board[i][k]){
                    return false;
                }
            }
            for(int i=row-1,k=j+1;i>=0&&k<board.length;i--,k++){
                if(board[i][k]){
                    return false;
                }
            }
            return true;

        }

        public static void main(String[] args) throws Exception {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            boolean[][] board = new boolean[n][n];
            //write your code here
            nQueen(board,0);
        }

    }
