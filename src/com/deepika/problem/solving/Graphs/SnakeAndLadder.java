package com.deepika.problem.solving.Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadder {
    public static void main(String[] args) {
        int[][] gameBoard= {
                {-1,-1,-1,-1,-1,-1},
        {-1,-1,-1,-1,-1,-1},
        {-1,-1,-1,-1,-1,-1},
        {-1,35,-1,-1,13,-1},
        {-1,-1,-1,-1,-1,-1},
        {-1,15,-1,-1,-1,-1}};
        System.out.println(findMinSteps(gameBoard));
    }

    private static int findMinSteps(int[][] gameBoard) {
        int n= gameBoard.length;
        Queue<Integer> queueMaintained= new LinkedList<>();
        HashMap<Integer,Integer> mapMaintained= new HashMap<>();
        queueMaintained.add(1);
        mapMaintained.put(1,0);
        while (!queueMaintained.isEmpty()){
            int popped= queueMaintained.remove();
            if (popped==n*n){
                return mapMaintained.get(popped);
            }
           for (int i=popped+1;i<=Math.min(popped+6,n*n);i++){
               int rc=get(i,n);
               int row=rc/n;
               int col=rc%n;
               int ifinal=gameBoard[row][col]==-1?i:gameBoard[row][col];
               if (!mapMaintained.containsKey(ifinal)){
                   queueMaintained.add(ifinal);
                   mapMaintained.put(ifinal,mapMaintained.get(popped)+1);
               }
           }
        }
        return -1;
    }

    private static int get(int i, int n) {
        int quo=(i-1)/n;
        int rem=(i-1)%n;
        int row=n-1-quo;
        int col=(row%2!=n%2)?rem:n-1-rem;
        int rc=row*n+col;
        return rc;
    }
}
