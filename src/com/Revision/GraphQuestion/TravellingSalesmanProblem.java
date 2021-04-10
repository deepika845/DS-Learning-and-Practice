package com.Revision.GraphQuestion;

import java.util.Arrays;

public class TravellingSalesmanProblem {
    int MAX=Integer.MAX_VALUE;
    int[][] adjacencyMatrix;
    int[][] dpMaintained;
    int visitedAll;
            int V;
    TravellingSalesmanProblem(int[][] adjacencyMatrix){
        this.adjacencyMatrix=adjacencyMatrix;
        V=adjacencyMatrix.length;
        visitedAll=(1<<V)-1;
        dpMaintained=new int[(1<<V)-1][V];
       for (int i=0;i<dpMaintained.length;i++){
           for (int j=0;j<dpMaintained[i].length;j++){
               dpMaintained[i][j]=-1;
           }
       }
    }
    public static void main(String[] args) {
        int[][] adjacencyMatrix = {{Integer.MAX_VALUE,10,15,20},{10,Integer.MAX_VALUE,35,25},{15,35,Integer.MAX_VALUE,30},{20,25,30,Integer.MAX_VALUE}};
        TravellingSalesmanProblem tsp= new TravellingSalesmanProblem(adjacencyMatrix);
        System.out.println(tsp.findMinWeight(1,0));
    }

    private int findMinWeight(int mask,int pos) {
        if (mask==((1<<V)-1)){
            return adjacencyMatrix[pos][0];
        }
        if (dpMaintained[mask][pos]!=-1){
            return dpMaintained[mask][pos];
        }
        int minWeight = Integer.MAX_VALUE;
        for (int adj=0;adj<V;adj++){
            if((mask &  (1<<adj))==0 && adjacencyMatrix[pos][adj]!=MAX){
                int answer= adjacencyMatrix[pos][adj]+findMinWeight(mask|(1<<adj),adj);
                minWeight=Math.min(minWeight,answer);
            }
        }
        dpMaintained[mask][pos]=minWeight;
        return minWeight;
    }
}
