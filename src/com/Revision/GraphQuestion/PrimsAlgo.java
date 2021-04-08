package com.Revision.GraphQuestion;

import java.util.HashMap;
import java.util.Map;

public class PrimsAlgo {
    HashMap<Integer,Vertex> allvertices= new HashMap<>();
    class Vertex{
        int val;
        HashMap<Vertex,Integer> neighbours;
        Vertex(int val){
            this.val=val;
            neighbours= new HashMap<>();
        }
    }
    public void addEdge(int first,int second,int weight){
        if (!allvertices.containsKey(first)){
            allvertices.put(first,new Vertex(first));
        }
        if (!allvertices.containsKey(second)){
            allvertices.put(second,new Vertex(second));
        }
        allvertices.get(first).neighbours.put(allvertices.get(second),weight);
        allvertices.get(second).neighbours.put(allvertices.get(first),weight);
    }
    public void findMinSpanningALgo(){
        HashMap<Vertex,Vertex> parentEdge=new HashMap<>();
        DsMaintained<Vertex> heapMap= new DsMaintained<>();
        PrimsAlgo minSpan= new PrimsAlgo();
        for (Vertex curr:allvertices.values()){
            if (heapMap.isEmpty()){
                heapMap.add(curr,0);
            }
            else {
                heapMap.add(curr,Integer.MAX_VALUE);
            }
        }

        while (!heapMap.isEmpty()){
            Vertex pop=heapMap.extractMin();
            int df= pop.val;
            for (Map.Entry<Vertex,Integer> neighbours:pop.neighbours.entrySet()){
                int pop1=neighbours.getKey().val;
                if (heapMap.containsData(neighbours.getKey())&&(heapMap.findWeight(neighbours.getKey())>neighbours.getValue())){
                    parentEdge.put(neighbours.getKey(),pop);
                    heapMap.decreaseKey(neighbours.getKey(),neighbours.getValue());
                    //minSpan.addEdge(pop.val,neighbours.getKey().val,neighbours.getValue());
                }
            }
        }
        for (Map.Entry<Vertex,Vertex> entries: parentEdge.entrySet()){
            minSpan.addEdge(entries.getKey().val,entries.getValue().val, entries.getKey().neighbours.get(entries.getValue()));
        }
        for (Vertex cur:minSpan.allvertices.values()){
            System.out.print(cur.val+" => ");
            for (Map.Entry<Vertex,Integer> padosi:cur.neighbours.entrySet()){
                System.out.print(padosi.getKey().val+"( Weight : "+padosi.getValue()+") ,");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        PrimsAlgo myGraph= new PrimsAlgo();
        myGraph.addEdge(1,2,-1);
        myGraph.addEdge(1,3,5);
        myGraph.addEdge(1,4,4);
        myGraph.addEdge(3,4,3);
        myGraph.addEdge(2,4,-3);
        myGraph.addEdge(2,5,2);
        myGraph.addEdge(4,6,4);
        myGraph.addEdge(5,6,6);
        myGraph.addEdge(5,4,2);
        myGraph.findMinSpanningALgo();





    }

}
