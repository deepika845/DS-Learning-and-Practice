package com.deepika.problem.solving.Graphs;

import java.util.*;

public class TarjansAlgo {
    HashMap<Integer,Vertex> allVertices= new HashMap<>();
    class Vertex{
        int val;
        List<Vertex> neighbours;
        Vertex(int val){
            this.val=val;
            neighbours= new ArrayList<>();
        }
    }
    public void addEdge(int first,int second){
        if (!allVertices.containsKey(first)){
            allVertices.put(first,new Vertex(first));
        }
        if (!allVertices.containsKey(second)){
            allVertices.put(second,new Vertex(second));
        }
        allVertices.get(first).neighbours.add(allVertices.get(second));
        allVertices.get(second).neighbours.add(allVertices.get(first));
    }
    public void allConnectedComponents(int u,int[] low,int[] disc,boolean[] inStack,Stack<Integer> stkMaintained,int timer){
        low[u]=timer;
        disc[u]=timer;
        timer++;
        inStack[u]=true;
        stkMaintained.push(u);
        for (Vertex padosi:allVertices.get(u).neighbours){
            if (disc[padosi.val]==-1){
                allConnectedComponents(padosi.val,low,disc,inStack,stkMaintained,timer);
                low[u]=Math.min(low[u],low[padosi.val]);
            }
            else if (disc[padosi.val]!=-1 && inStack[padosi.val]){
                low[u]=Math.min(low[u],disc[padosi.val]);
            }
        }
        if (low[u]==disc[u]){
            while (stkMaintained.peek()!=u){
                System.out.print(stkMaintained.peek()+" , ");
                inStack[stkMaintained.peek()]=false;
                stkMaintained.pop();
            }
            System.out.println(stkMaintained.peek());
            inStack[stkMaintained.peek()]=false;
            stkMaintained.pop();
        }
    }
    public void allConnectedComponents(){

        int[] low= new int[allVertices.size()];
        Arrays.fill(low,-1);
        int[] disc=new int[allVertices.size()];
        Arrays.fill(disc,-1);
        boolean[] instack= new boolean[allVertices.size()];
        Stack<Integer> stkMaintained= new Stack<>();
        for (Vertex curr:allVertices.values()){
            if (disc[curr.val]==-1){
                allConnectedComponents(curr.val,low,disc,instack,stkMaintained,0);
            }
        }
    }
    public void findArticulationPoints(int curr,int[] low,int[] disc,int[] parent,boolean[] isArticulationPoint,int timer){
        low[curr]=timer;
        disc[curr]=timer;
        timer++;
        int c=0;
        for (Vertex padosi: allVertices.get(curr).neighbours){
            if (disc[padosi.val]==-1){
                c++;
                parent[padosi.val]=curr;
                findArticulationPoints(padosi.val,low,disc,parent,isArticulationPoint,timer);
                low[curr]=Math.min(low[curr],low[padosi.val]);
            }
            else if (disc[padosi.val]!=-1 && parent[curr]!=padosi.val){
                low[curr]=Math.min(low[curr],disc[padosi.val]);
            }
        }
        if (c>1){
            isArticulationPoint[curr]=true;
        }
        else {
            for (Vertex padosi :allVertices.get(curr).neighbours){
                if (low[padosi.val]>disc[curr]){
                    isArticulationPoint[curr]=true;
                    break;
                }
            }
        }


    }
    public void findArticulationPoints(){

        int[] low= new int[allVertices.size()];
        Arrays.fill(low,-1);
        int[] disc=new int[allVertices.size()];
        Arrays.fill(disc,-1);
        int[] parent=new int[allVertices.size()];
        Arrays.fill(disc,-1);
        boolean[] articulationPoints= new boolean[allVertices.size()];
        for (Vertex curr:allVertices.values()){
            if (disc[curr.val]==-1){
                findArticulationPoints(curr.val,low,disc,parent,articulationPoints,0);
            }
        }
        for (int i=0;i<articulationPoints.length;i++){
            if (articulationPoints[i]){
                System.out.println(i+" , ");
            }
        }
    }


    public static void main(String[] args) {
        TarjansAlgo newGraph= new TarjansAlgo();
        newGraph.addEdge(0,1);
        newGraph.addEdge(1,3);
        newGraph.addEdge(0,2);
        newGraph.addEdge(3,0);
        newGraph.addEdge(4,3);
        newGraph.addEdge(3,5);
//        newGraph.addEdge(4,6);
//        newGraph.addEdge(5,2);
//        newGraph.addEdge(5,6);
//        newGraph.addEdge(6,5);
       // newGraph.allConnectedComponents();
        newGraph.findArticulationPoints();
    }
}
