package com.Revision.GraphQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class TopologicalSort {
    HashMap<Integer,Vertex> allVertex= new HashMap<>();
    public void addEdge(int a, int b,int weight){
        if (!allVertex.containsKey(a)){
            allVertex.put(a,new Vertex(a));
        }
        if (!allVertex.containsKey(b)){
            allVertex.put(b,new Vertex(b));
        }
        allVertex.get(a).neighbours.put(allVertex.get(b),weight);

    }
    class Vertex{
        int val;
        HashMap<Vertex,Integer> neighbours;
        Vertex(int val){
            this.val=val;
            neighbours=new HashMap<>();
        }
    }
    public void findTopologicalSort(Vertex curr, Stack<Vertex> stkMaintained, ArrayList<Vertex> visited){
        visited.add(curr);
        for (Vertex padosi:curr.neighbours.keySet()){
            if (!visited.contains(padosi)){
                findTopologicalSort(padosi,stkMaintained,visited);
            }
        }
        stkMaintained.push(curr);
    }
    public void findTopologicalSort(){
        ArrayList<Vertex> visited= new ArrayList<>();
        Stack<Vertex> stkMaintained= new Stack<>();
        for (Vertex curr:allVertex.values()){
            if (!visited.contains(curr)){
                findTopologicalSort(curr,stkMaintained,visited);
            }
        }
        int[] longDistances= new int[allVertex.size()];
        Arrays.fill(longDistances,Integer.MIN_VALUE);
        longDistances[0]=0;
        while (!stkMaintained.isEmpty()){
            Vertex pop= stkMaintained.pop();
            if (longDistances[pop.val]!=Integer.MIN_VALUE){
            for (Vertex padosi:pop.neighbours.keySet()){
                if (longDistances[padosi.val]<longDistances[pop.val]+pop.neighbours.get(padosi)){
                    longDistances[padosi.val]=longDistances[pop.val]+pop.neighbours.get(padosi);
                }
            }
        }
        }
        for (int i=0;i<longDistances.length;i++){
            if (longDistances[i]==Integer.MIN_VALUE){
                System.out.print(Integer.MIN_VALUE+" , ");
            }else {
            System.out.print(longDistances[i]+" , ");
        }
        }

    }
    public static void main(String[] args) {
        TopologicalSort tsp= new TopologicalSort();
        tsp.addEdge(0,2,3);
        tsp.addEdge(0,1,5);
        tsp.addEdge(1,3,6);
        tsp.addEdge(1,2,2);
        tsp.addEdge(2,3,7);
        tsp.addEdge(2,4,4);
        tsp.addEdge(3,4,-1);
        tsp.addEdge(2,5,2);
        tsp.addEdge(3,5,1);
        tsp.addEdge(4,5,-2);
        tsp.findTopologicalSort();
    }
}
