package com.LeetCode.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {


       static class Pair{
            int row;
            int col;
            int numSteps;
            Pair(int row,int col,int numSteps){
                this.row=row;
                this.col=col;
                this.numSteps=numSteps;
            }
        }
        public static boolean isSafe(int cr,int cc,boolean[][] rooms){
            if(cr<0||cr>rooms.length-1||cc<0||cc>rooms[cr].length-1||rooms[cr][cc]){
                return false;
            }
            return true;
        }
        public static void wallsAndGates(int[][] rooms) {
            // write your code here
            for(int i=0;i<rooms.length;i++){
                for(int j=0;j<rooms[i].length;j++){
                    if(rooms[i][j]==Integer.MAX_VALUE){
                        Queue<Pair> queMn= new LinkedList<Pair>();
                        boolean visited[][] = new boolean[rooms.length][rooms[0].length];
                        queMn.add(new Pair(i,j,0));
                        visited[i][j]=true;
                        while(!queMn.isEmpty()){
                            Pair pop=queMn.remove();
                            int cr=pop.row;
                            int cc=pop.col;
                            int cn=pop.numSteps;
                            if(rooms[cr][cc]==0){
                                rooms[i][j]=cn;
                                break;
                            }
                            else if(rooms[cr][cc]==-1){
                                continue;
                            }
                            if(isSafe(cr+1,cc,visited)){
                                visited[cr+1][cc]=true;
                                queMn.add(new Pair(cr+1,cc,cn+1));
                            }
                            if(isSafe(cr-1,cc,visited)){
                                visited[cr-1][cc]=true;
                                queMn.add(new Pair(cr-1,cc,cn+1));
                            }
                            if(isSafe(cr,cc-1,visited)){
                                visited[cr][cc-1]=true;
                                queMn.add(new Pair(cr,cc-1,cn+1));
                            }
                            if(isSafe(cr,cc+1,visited)){
                                visited[cr][cc+1]=true;
                                queMn.add(new Pair(cr,cc+1,cn+1));
                            }

                        }

                    }
                }
            }
            for(int i=0;i<rooms.length;i++){
                System.out.println(Arrays.toString(rooms[i]));
            }

        }

    public static void main(String[] args) {
        wallsAndGates(new int[][]{{2147483647,-1,0,2147483647},
                                  {2147483647,2147483647,2147483647,-1},
                                  {2147483647,-1,2147483647,-1},
                                   {0,-1,2147483647,2147483647}});
    }

}
