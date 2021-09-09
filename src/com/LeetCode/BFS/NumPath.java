package com.LeetCode.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumPath {
    static class Pair{
        int numSteps;
        int row;
        int col;
        Pair(int numSteps,int row,int col){
            this.numSteps=numSteps;
            this.row=row;
            this.col=col;
        }
    }
    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        Queue<Pair> queMaintained=new LinkedList<Pair>();
     //   List<String> backUp=new ArrayList<>();
       // backUp.add(startRow+""+startColumn);
        queMaintained.add(new Pair(0,startRow,startColumn));
        int numPath=0;
        while(!queMaintained.isEmpty()){
            Pair pop = queMaintained.remove();
            int cur=pop.row;
            int cur1=pop.col;
            if(pop.row<0||pop.row>m-1||pop.col<0||pop.col>n-1)
            {
                numPath++;
                continue;
            }
            if(pop.numSteps==maxMove){
                continue;
            }

            int currRow=pop.row;
            int currCol=pop.col;
            int currSteps=pop.numSteps;

                queMaintained.add(new Pair(currSteps+1,currRow-1,currCol));
                //visited[currRow-1][currCol]=true;



                queMaintained.add(new Pair(currSteps+1,currRow+1,currCol));
               // visited[currRow+1][currCol]=true;


                queMaintained.add(new Pair(currSteps+1,currRow,currCol-1));
               // visited[currRow][currCol-1]=true;


                queMaintained.add(new Pair(currSteps+1,currRow,currCol+1));
                //visited[currRow][currCol+1]=true;

        }
        return numPath;

}

    public static void main(String[] args) {
        System.out.println( findPaths(10,10,11,5,5));
    }
}
