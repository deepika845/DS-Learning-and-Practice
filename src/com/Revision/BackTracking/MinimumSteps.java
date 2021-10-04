package com.Revision.BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MinimumSteps {
public static int findMinmoves(int sr, int sc,int numPawns, HashSet<Integer> allPos,int endRow,int endCol,boolean[][] visited){
    if(sr<0|| sr>=endRow||sc<0||sc>=endCol||visited[sr][sc]){
        return Integer.MAX_VALUE;
    }
    if(numPawns==0){
        return 0;
    }
    int curPos=sr*10+sc;
    int numCurr=numPawns;
    if(allPos.contains(curPos)){
        numCurr--;
        allPos.remove(curPos);

    }
    visited[sr][sc]=true;
    int a1=findMinmoves(sr+1,sc+2,numCurr,allPos,endRow,endCol,visited);
    int a2=findMinmoves(sr-1,sc+2,numCurr,allPos,endRow,endCol,visited);
    int a3=findMinmoves(sr+2,sc+1,numCurr,allPos,endRow,endCol,visited);
    int a4=findMinmoves(sr+2,sc-1,numCurr,allPos,endRow,endCol,visited);
    int a5=findMinmoves(sr+1,sc-2,numCurr,allPos,endRow,endCol,visited);
    int a6=findMinmoves(sr-1,sc-2,numCurr,allPos,endRow,endCol,visited);
    int a7=findMinmoves(sr-2,sc+1,numCurr,allPos,endRow,endCol,visited);
    int a8=findMinmoves(sr-2,sc-1,numCurr,allPos,endRow,endCol,visited);
    visited[sr][sc]=false;
    allPos.add(curPos);
    int fres=Math.min(a1,Math.min(a2,Math.min(a3,Math.min(a4,Math.min(a5,Math.min(a6,Math.min(a7,a8)))))));
    if(fres==Integer.MAX_VALUE){
        return Integer.MAX_VALUE;
    }
    return 1+fres;


}

    public static void main(String[] args) {
    HashSet<Integer> arr= new HashSet<>();
    arr.add(51);
    arr.add(24);
        System.out.println( findMinmoves(0,0,2,arr,8,8,new boolean[8][8]));
    }



}
