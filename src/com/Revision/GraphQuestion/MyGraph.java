package com.Revision.GraphQuestion;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyGraph<T> {
    HashMap<T,Vertex> allVertices = new HashMap<T, Vertex>();
    public Vertex getVertex(T key){
        if(allVertices.containsKey(key)){
            return allVertices.get(key);
        }
        return null;
    }
    public void addVertex(T key){
        allVertices.put(key,new Vertex(key));
    }
    public boolean addEdge(T first,T second){
        if(allVertices.containsKey(first) && allVertices.containsKey(second)){
            allVertices.get(first).neighbours.add(allVertices.get(second));
            allVertices.get(second).neighbours.add(allVertices.get(first));
            return true;
        }
        return false;
    }
    public void printGraph(){
        for (T vertex : allVertices.keySet()){
            System.out.print(vertex+" -> ");
            for (Vertex padosi : allVertices.get(vertex).neighbours){
                System.out.print(padosi.val+",");
            }
            System.out.println();
        }
    }
    class Vertex{
        T val;
        List<Vertex> neighbours;
        Vertex(T val){
            this.val=val;
            neighbours=new ArrayList<>();
        }
    }
}
