package com.Revision.BackTracking;



import java.util.Scanner;

public class NQueenProblem {
    public static void printQueens(boolean[][] maze,int row,int n){
        if(row==n){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(maze[i][j]){
                        System.out.print("Q ");
                    }
                    else {
                        System.out.print(". ");
                    }
                }
                System.out.println();
            }
            return;
        }
        for(int col=0;col<n;col++){
            if(isSafe(maze,row,col)){
                maze[row][col]=true;
                printQueens(maze,row+1,n);
                maze[row][col]=false;
            }
        }
    }

    private static boolean isSafe(boolean[][] maze, int row, int col) {
        for (int i=0;i<row;i++){
            if(maze[i][col]){
                return false;
            }
        }
        for (int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(maze[i][j]){
                return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0 && j<maze.length;i--,j++ ){
            if(maze[i][j]){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        boolean[][] mazeBoard=new boolean[n][n];
        printQueens(mazeBoard,0,n);

    }
}
