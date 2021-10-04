package com.Revision.BackTracking;

import java.util.ArrayList;

public class RatMaze {
    public static void findPath(int[][] m, int n) {
        // Your code here

        dfs(m,0,0,n-1,n-1,"");
    }
    public static void dfs(int[][] m,int srow,int scol,int erow,int ecol,String currPath){
        if(srow<0 || srow>erow || scol<0 || scol>ecol || m[srow][scol]<0){
            return;
        }
        if(srow==erow && scol==ecol){
            System.out.print(currPath +" ");
            return;
        }
        m[srow][scol]=-m[srow][scol];
        if(srow>0 && m[srow-1][scol]>0){
            dfs(m,srow-1,scol,erow,ecol,currPath+"U");
        }
        if(scol>0 && m[srow][scol-1]>0){
            dfs(m,srow,scol-1,erow,ecol,currPath+"L");
        }
        if(srow<erow && m[srow+1][scol]>0){
            dfs(m,srow+1,scol,erow,ecol,currPath+"D");
        }
        if(scol<erow && m[srow][scol+1]>0){
            dfs(m,srow,scol+1,erow,ecol,currPath+"R");
        }
        m[srow][scol]=-m[srow][scol];


    }
    public static void main(String[] args) {
        findPath(new int[][]{{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}},4);
    }
}
