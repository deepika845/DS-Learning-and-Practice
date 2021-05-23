package com.Revision.GraphQuestion;

import java.util.Arrays;

public class HamiltonianCycle {

    public static void main(String[] args) {
        int[][] adjacencyMatrix= {{0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
        };
        hamCycle(adjacencyMatrix);

    }

    private static void hamCycle(int[][] adjacencyMatrix) {
        int[] path = new int[adjacencyMatrix.length];
        Arrays.fill(path,-1);
        path[0]=0;
        if (hamCycleUtil(adjacencyMatrix.length,adjacencyMatrix,path,1)){
            System.out.println("Have cycle");
        }
        else
        {
            System.out.println("Not having Cycle");
        }
    }

    private static boolean hamCycleUtil(int v, int[][] adjacencyMatrix, int[] path, int pos) {
        if (pos==v){
            if (adjacencyMatrix[path[pos-1]][path[0]]==1){
                return true;
            }
            else
            {
                return false;
            }
        }
        for (int vert=1;vert<v;vert++){
            if (isSafe(vert,adjacencyMatrix,path,pos)){
                path[pos]=vert;
                if (hamCycleUtil(v,adjacencyMatrix,path,pos+1)){
                    return true;
                }
                path[pos]=-1;

            }
        }
        return false;
    }

    private static boolean isSafe(int v, int[][] adjacencyMatrix, int[] path, int pos) {
        if (adjacencyMatrix[path[pos-1]][v]==0){
            return false;
        }
        for (int i=0;i<pos;i++){
            if (path[i]==v){
                return false;
            }
        }
        return true;
    }
}
