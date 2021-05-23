package com.Revision.GraphQuestion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class WaterJugProblem {
    static class Pair{
        int a;
        int b;
        Pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
    public static void target(int a,int b,int target){
        Queue<Pair> queueMaintained= new LinkedList<>();
        queueMaintained.add(new Pair(0,0));
        int[][] visited= new int[50][50];
        ArrayList<Pair> compPath= new ArrayList<>();
        while (!queueMaintained.isEmpty()){
            Pair polled= queueMaintained.poll();
            if (polled.a>a ||polled.a<0||polled.b>b||polled.b<0){
                continue;
            }
            if (visited[polled.a][polled.b]==1){
                continue;
            }
            visited[polled.a][polled.b]=1;
            compPath.add(polled);
            if (polled.a==target ||polled.b==target){
                if (polled.a==target){
                    compPath.add(new Pair(polled.a, 0));
                }
                if (polled.b==target){
                    compPath.add(new Pair(0,polled.b));
                }
                for (int i=0;i<compPath.size();i++){
                    System.out.println("("+compPath.get(i).a+" , "+compPath.get(i).b+")");
                }
               break;
            }
            queueMaintained.add(new Pair(polled.a, b));
            queueMaintained.add(new Pair(a, polled.b));
            for (int i=0;i<Math.max(a,b);i++){
                int a1=polled.a-i;
                int b1=polled.b+i;
                if (a1==0 || b1==b ){
                    queueMaintained.add(new Pair(a1,b1));
                }
                a1=polled.a+i;
                b1= polled.b-i;
                if (a1==a || b1==0 ){
                    queueMaintained.add(new Pair(a1,b1));
                }
            }
            queueMaintained.add(new Pair(a,0));
            queueMaintained.add(new Pair(0,b));
        }
    }
    public static void main(String[] args) {
        target(4,3,2);

    }
}
