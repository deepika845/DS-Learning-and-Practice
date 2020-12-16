package com.Revision.GraphQuestion;

import java.util.LinkedList;
import java.util.Queue;

public class MinStepsByKnight {
    class Cell{
        int xrow;
        int ycol;
        int distT;
        Cell(int xrow,int ycol,int distT){
            this.xrow=xrow;
            this.ycol=ycol;
            this.distT=distT;
        }
    }
    public int findMinStep(int xrow,int ycol,int targetrow,int targetcol,int n){
        int decRow[] = {-2,-2,-1,-1,1,1,2,2};
        int decCol[] = {-1,1,-2,2,-2,2,-1,1};
        boolean visited[][] =new boolean[n+1][n+1];
        Queue<Cell> maintained = new LinkedList<Cell>();
        maintained.add(new Cell(xrow,ycol,0));
        visited[xrow][ycol]=true;
        int x,y=0;
        while (!maintained.isEmpty()){
            Cell t=maintained.remove();
            if(t.xrow==targetrow && t.ycol==targetcol){
                return t.distT;
            }
            for (int i=0;i<=7;i++){
                x=t.xrow+decRow[i];
                 y=t.ycol+decCol[i];
                if(isInside(x,y,n) && !visited[x][y]){
                    visited[x][y]=true;
                    maintained.add(new Cell(x,y,t.distT+1));
                }
            }
        }
        return -1;
    }

    private boolean isInside(int x, int y,int n) {
        if(x>=1 && x<=n && y>=1 && y<=n ){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MinStepsByKnight mnt = new MinStepsByKnight();
        System.out.println(mnt.findMinStep(1,1,30,30,30));
    }
}
