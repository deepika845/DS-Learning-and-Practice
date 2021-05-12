package com.Revision.GraphQuestion;

import java.util.ArrayList;
import java.util.HashMap;

public class PathMoreThanK {
    HashMap<Integer,Vertex> allVertex= new HashMap<>();
    class Vertex{
        int val;
        HashMap<Vertex,Integer> neighbours;
        Vertex(int val){
            this.val=val;
            this.neighbours=new HashMap<>();
        }

    }
    public void addEdge(int a,int b,int weight){
        if (!allVertex.containsKey(a)){
            allVertex.put(a,new Vertex(a));
        }
        if (!allVertex.containsKey(b)){
            allVertex.put(b,new Vertex(b));
        }
        allVertex.get(a).neighbours.put(allVertex.get(b),weight);
        allVertex.get(b).neighbours.put(allVertex.get(a),weight);


    }
    public boolean findIfexists(int src,int k){
        boolean[] path= new boolean[allVertex.size()];
        path[src]=true;
        return findIfExists(src,k,path);
    }
    public boolean findIfExists(int src,int k,boolean[] visited){
        if (k<=0){
            return true;
        }
        for (Vertex padosi:allVertex.get(src).neighbours.keySet()){
            if (!visited[padosi.val]){
                if (allVertex.get(src).neighbours.get(padosi)>=k){
                    return true;
                }
                visited[padosi.val]=true;
                if (findIfExists(padosi.val,k-(allVertex.get(src).neighbours.get(padosi)),visited)){
                    return true;
                }
                visited[padosi.val]=false;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        PathMoreThanK ptk = new PathMoreThanK();
//        ptk.addEdge();

    }
}
