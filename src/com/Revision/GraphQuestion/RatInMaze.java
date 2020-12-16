package com.Revision.GraphQuestion;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {
    public List<String> findAllPath(int[][] mazePath){
        List<String> pathWays=new ArrayList<>();
        findAllPath(mazePath,"",0,0,pathWays);
        return pathWays;
    }

    private void findAllPath(int[][] mazePath, String s, int row, int col,List<String> pathWays) {
        if(row==mazePath.length-1 && col==mazePath[0].length-1){
            pathWays.add(s);
            return;
        }
        if(row<0 || col<0 || row>=mazePath.length || col>=mazePath[0].length || mazePath[row][col]==-1 || mazePath[row][col]==0){
            return;
        }
        int backUp=mazePath[row][col];
        mazePath[row][col]=-1;
        findAllPath(mazePath,s+"L",row,col-1,pathWays);
        findAllPath(mazePath,s+"R",row,col+1,pathWays);
        findAllPath(mazePath,s+"U",row-1,col,pathWays);
        findAllPath(mazePath,s+"D",row+1,col,pathWays);
        mazePath[row][col]=backUp;
    }

    public static void main(String[] args) {
        RatInMaze rt = new RatInMaze();
        //System.out.println(rt.findAllPath(new int[][]{{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}}));
        int ar[][]= new int[6][6];
        System.out.println(rt.findMinStepsByKnight(ar,3,4,5,0));

    }
    public int findMinStepsByKnight(int[][] paths,int row,int col,int targetRow,int targetCol){
        if(row==targetRow && col == targetCol){
            return 1;
        }
        if(row<0 || row>paths.length-1 || col<0 || col>paths[0].length-1){
            return 0;
        }
        if(paths[row][col]!=0){
            return paths[row][col];
        }
       int a1= findMinStepsByKnight(paths,row-2,col-1,targetRow,targetCol);
        int a2=findMinStepsByKnight(paths,row-2,col+1,targetRow,targetCol);
        int a3=findMinStepsByKnight(paths,row-1,col-2,targetRow,targetCol);
        int a4=findMinStepsByKnight(paths,row-1,col+2,targetRow,targetCol);
        int a5=findMinStepsByKnight(paths,row+1,col-2,targetRow,targetCol);
        int a6=findMinStepsByKnight(paths,row+1,col+2,targetRow,targetCol);
        int a7=findMinStepsByKnight(paths,row+2,col-1,targetRow,targetCol);
        int a8=findMinStepsByKnight(paths,row+2,col+1,targetRow,targetCol);
        paths[row][col]=Math.min(a1,Math.min(a2,Math.min(a3,Math.min(a4,Math.min(a5,Math.min(a6,Math.min(a7,a8)))))))+1;
        return paths[row][col];
    }

}
