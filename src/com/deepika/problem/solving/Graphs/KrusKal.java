package com.deepika.problem.solving.Graphs;

import java.util.*;

class KrusKal<T>{
    HashMap<T,Vertex> vertices = new HashMap<T,Vertex>();
    HashMap<Vertex,Vertex> parent = new HashMap<Vertex, Vertex>();
    public  void addVertex(T val){
        vertices.put(val,new Vertex(val));
    }
    public void addEdgeWeight(T start, T end,int weight){
        if(vertices.containsKey(start) && vertices.containsKey(end)){
            vertices.get(start).neighbours.put(vertices.get(end),weight);
            vertices.get(end).neighbours.put(vertices.get(start),weight);
        }
    }
    public void setParent(){
        for (Vertex vv : vertices.values()){
            parent.put(vv,null);
        }
    }
    public KrusKal<T> kruskMethod(){
        setParent();
        KrusKal<T> minSpan = new KrusKal<T>();
        ArrayList<Edge> edges =  new ArrayList<Edge>();
        for (T vv : vertices.keySet()){
            minSpan.addVertex(vv);
        }
        for(Vertex vertex : vertices.values() ){
            for (Vertex padosi : vertex.neighbours.keySet()){
                edges.add(new Edge(vertex,padosi,vertex.neighbours.get(padosi)));
            }
        }
        Collections.sort(edges);
        for (Edge pair : edges){
            if(union(pair.first,pair.second)){
                minSpan.addEdgeWeight(pair.first.value,pair.second.value,pair.weight);
            }
        }
        return minSpan;
    }
    public void display(){
        for (Vertex ver : vertices.values()){
            System.out.println(ver.value + "=>");
            for (Vertex padosi : ver.neighbours.keySet()){
                System.out.println(padosi.value + "=>" + ver.neighbours.get(padosi));
            }
            System.out.print("__________");
        }
    }
    public boolean union(Vertex a ,Vertex b){
        Vertex pa = find(a);
        Vertex pb = find(b);
        if(pa!=pb){
            parent.put(pa,pb);
            return true;
        }
        return false;
    }
    public Vertex find(Vertex v){
        while (parent.get(v) != null){
            v=parent.get(v);
        }
        return v;
    }
    class Edge implements Comparable<Edge>{
        Vertex first;
        Vertex second;
        int weight;
        public Edge(Vertex first,Vertex second,int weight){
            this.first=first;
            this.second=second;
            this.weight=weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight-o.weight;
        }
    }

    class Vertex {
         T value;
         HashMap<Vertex,Integer> neighbours;
         Vertex(T val){
             value= val;
             neighbours = new HashMap<Vertex,Integer>();
         }
    }
}