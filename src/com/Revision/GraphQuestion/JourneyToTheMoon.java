package com.Revision.GraphQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
public class JourneyToTheMoon {
    HashMap<Integer,Vertex> allVertex= new HashMap<>();
    static class Vertex{
        int val;
        ArrayList<Vertex> neighbours;
        Vertex(int val){
            this.neighbours= new ArrayList<>();
        }
    }
    public void addEdge(int a,int b){
        if (!allVertex.containsKey(a)){
            allVertex.put(a,new Vertex(a));
        }
        if (!allVertex.containsKey(b)){
            allVertex.put(b,new Vertex(b));
        }
        allVertex.get(a).neighbours.add(allVertex.get(b));
        allVertex.get(b).neighbours.add(allVertex.get(a));


    }
    public int findTotalPairs(){
        int total=1;
        ArrayList<Vertex> visited= new ArrayList<>();
        int countComponents=0;

        for (Vertex curr:allVertex.values()){
            if (!visited.contains(curr)){
                countComponents++;

               int total1 =findConnected(curr,visited);
               if (countComponents>1 || (total1<allVertex.size())){
                   total*=total1;
               }
            }
        }
        return total;
    }

    private int findConnected(Vertex curr,ArrayList<Vertex> visited) {
        Stack<Vertex> stkMaintained= new Stack<>();
        visited.add(curr);
        stkMaintained.push(curr);
        int totalUnique=0;
        while (!stkMaintained.isEmpty()){
            Vertex pop=stkMaintained.pop();
            totalUnique++;
            for (Vertex padosi:pop.neighbours){
                if (!visited.contains(padosi)){
                    stkMaintained.push(padosi);
                    visited.add(padosi);
                }
            }

        }
        return totalUnique;
    }


    public static void main(String[] args) {
        JourneyToTheMoon jtm = new JourneyToTheMoon();
        jtm.allVertex.put(3,new  Vertex(3));
        jtm.addEdge(0,1);
        jtm.addEdge(1,4);
        jtm.addEdge(2,3);
       // jtm.addEdge(2,4);
        System.out.println(jtm.findTotalPairs());

    }
}
