package com.Revision.GraphQuestion;

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Kruskal {
    HashMap<Integer,Vertex> allVertices = new HashMap<>();
    HashMap<Vertex,Vertex> parent = new HashMap<>();
    class  Vertex{
        int val;
        HashMap<Vertex,Integer> neighnours;
        Vertex(int val){
            this.val=val;
            this.neighnours=new HashMap<>();
        }
    }
    class Edge implements  Comparable<Edge>{
        Vertex first;
        Vertex second;
        int weight;
        Edge(Vertex first,Vertex second,int weight){
            this.first=first;
            this.second=second;
            this.weight=weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight-o.weight;
        }
    }
    public void findMinSpanningTree(){
        setParent();
        Kruskal minspan=new Kruskal();
        ArrayList<Edge> edgesmaintained= new ArrayList<>();
        for (Integer curr: allVertices.keySet()){
            minspan.allVertices.put(curr,new Vertex(curr));
        }
        for (Vertex curr: allVertices.values()){
            for (Vertex padosi: curr.neighnours.keySet()){
                edgesmaintained.add(new Edge(curr,padosi,curr.neighnours.get(padosi)));
            }
        }
        Collections.sort(edgesmaintained);
        for (Edge curr: edgesmaintained){
            int first=curr.first.val;
            int second = curr.second.val;
            if (union(curr.first,curr.second)){
                minspan.addEdge(curr.first.val,curr.second.val,curr.weight);
            }
        }
        minspan.printGraph();

    }

    private void printGraph() {
        for (Vertex curr: allVertices.values()){
            System.out.print(curr.val+" => ");
            for (Vertex padosi:curr.neighnours.keySet()){
                System.out.print(padosi.val+" , ");
            }
            System.out.println();
        }
    }

    private void addEdge(int first, int second,int weight) {
        if (!allVertices.containsKey(first)){
            allVertices.put(first,new Vertex(first));
        }
        if (!allVertices.containsKey(second)){
            allVertices.put(second,new Vertex(second));
        }

        this.allVertices.get(first).neighnours.put(allVertices.get(second),weight);
        this.allVertices.get(second).neighnours.put(allVertices.get(first),weight);
    }

    private boolean union(Vertex first, Vertex second) {
        Vertex pfirst = find(first);
        Vertex psecond=find(second);
        if (pfirst!=psecond) {
            parent.put(pfirst, psecond);
            return true;
        }
        return false;
    }

    private Vertex find(Vertex first) {
        while (parent.get(first)!=null){
            first=parent.get(first);
        }
        return first;
    }

    private void setParent() {
        for (Vertex curr: allVertices.values()){
            parent.put(curr,null);
        }
    }

    public static void main(String[] args) {
        Kruskal mainGraph = new Kruskal();
        mainGraph.addEdge(0,1,10);
        mainGraph.addEdge(0,2,6);
        mainGraph.addEdge(2,3,4);
        mainGraph.addEdge(1,3,15);
        mainGraph.addEdge(0,3,5);
        mainGraph.findMinSpanningTree();

    }



}
