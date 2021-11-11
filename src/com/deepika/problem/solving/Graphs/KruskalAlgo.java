package com.deepika.problem.solving.Graphs;

import java.util.*;

public class KruskalAlgo {
    HashMap<Integer,Vertex> allVertex=new HashMap<>();
    HashMap<Integer,Integer> parent = new HashMap<>();
    class Vertex{
        int val;
        HashMap<Integer,Integer> padosi;
        Vertex(int val){
            this.val=val;
            this.padosi=new HashMap<>();
        }
    }
    class Edge implements Comparable<Edge> {
        int first;
        int second;
        int weight;
        Edge(int first,int second,int weight){
            this.first=first;
            this.second=second;
            this.weight=weight;
        }
        public int compareTo(Edge a1){
            return this.weight- a1.weight;
        }
    }
    public void add(int a,int b, int wt){
        if(!allVertex.containsKey(a)){
            allVertex.put(a,new Vertex(a));
        }
        if(!allVertex.containsKey(b)){
            allVertex.put(b,new Vertex(b));
        }
        allVertex.get(a).padosi.put(b,wt);
        allVertex.get(b).padosi.put(a,wt);
    }
    public void setParent(){
        for(Integer a : allVertex.keySet()){
            parent.put(a,null);
        }
    }
    public KruskalAlgo minimumSpanning(){
        setParent();
        KruskalAlgo ktq = new KruskalAlgo();
        List<Edge> edgePair = new ArrayList<Edge>();
        for (Vertex vt : allVertex.values()){
            for (Integer pd : vt.padosi.keySet()){
                edgePair.add(new Edge(vt.val,pd,vt.padosi.get(pd)));
            }
        }
        Collections.sort(edgePair);
        for(Edge curr : edgePair){
            if(findUnion(curr.first,curr.second)){
                ktq.add(curr.first,curr.second,curr.weight);
            }
        }
        return ktq;


    }
    public boolean findUnion(Integer a,Integer b){
        Integer a1= find(a);
        Integer a2= find(b);
        if(a1!=a2){
            parent.put(a1,a2);
            return true;
        }
        return false;
    }

    private Integer find(Integer a) {
        while (parent.get(a)!=null){
            a=parent.get(a);
        }
        return a;
    }


    public static void main(String[] args) {
        KruskalAlgo kta = new KruskalAlgo();
        kta.add(0,1,4);
        kta.add(0,7,8);
        kta.add(1,7,11);
        kta.add(1,2,8);
        kta.add(7,6,1);
        kta.add(7,8,7);
        kta.add(2,8,2);
        kta.add(2,5,4);
        kta.add(6,5,2);
        kta.add(2,3,7);
        kta.add(3,5,14);
        kta.add(3,4,9);
        kta.add(5,4,10);
        kta.add(8,6,6);
        KruskalAlgo aa=kta.minimumSpanning();
        for (Integer aaVert : aa.allVertex.keySet()){
            System.out.print(aaVert+" = > ");
            for (Map.Entry<Integer,Integer> padosi : aa.allVertex.get(aaVert).padosi.entrySet()){
                System.out.print("( "+padosi.getKey()+" , "+padosi.getValue()+" )");
            }
            System.out.println();
        }


    }
}
