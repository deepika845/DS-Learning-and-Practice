package com.Revision.GraphQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DjkstraAlgo<T> {
    HashMap<T, Vertex> allVertices = new HashMap<T,Vertex>();
    class Vertex{
        T val;
        Map<Vertex,Integer> neighbours;
        Vertex(T val){
            this.val=val;
            neighbours=new HashMap<>();
        }
    }
    public Vertex getVertex(T key) {
        if (allVertices.containsKey(key)) {
            return allVertices.get(key);
        }
        return null;
    }
    public void addVertex(T key){
        allVertices.put(key,new Vertex(key));
    }
    public boolean addEdge(T first,T second,int weight){
        if(allVertices.containsKey(first) && allVertices.containsKey(second)){
            allVertices.get(first).neighbours.put(allVertices.get(second),weight);
            allVertices.get(second).neighbours.put(allVertices.get(first),weight);
            return true;
        }
        return false;
    }
    public void findShprtestPath(){
        HashMap<T,T> minDistanceParent = new HashMap<>();
        HashMap<T,Integer> minDistanceEdge = new HashMap<>();
        HeapMapStructure<Vertex> binaryHeap = new HeapMapStructure<>();
        for (Vertex vertex : allVertices.values()){
            if(binaryHeap.isEmpty()){
                binaryHeap.add(vertex,0);
            }
            else {
                binaryHeap.add(vertex,Integer.MAX_VALUE);
            }
        }
        Vertex k = allVertices.values().iterator().next();
        T va=k.val;
        minDistanceParent.put(k.val,null);
        while (!binaryHeap.isEmpty()){
            Integer kk = binaryHeap.min();
            Vertex minNode = binaryHeap.extractMin();
            minDistanceEdge.put(minNode.val,kk);
            for (Map.Entry<Vertex,Integer> entrir :minNode.neighbours.entrySet()){
                int j= kk+entrir.getValue();
                if( binaryHeap.containsData(entrir.getKey()) && j<binaryHeap.getWeight(entrir.getKey())){
                    binaryHeap.decreaseKey(entrir.getKey(),kk+entrir.getValue());
                    minDistanceParent.put(entrir.getKey().val,minNode.val);
                }
            }
        }
        for (Map.Entry<T,T> entries : minDistanceParent.entrySet()){
            System.out.println(entries.getKey() +" --> "+entries.getValue());
        }
    }
    public static void main(String[] args) {
        DjkstraAlgo<Character> dgrap=new DjkstraAlgo<>();
        dgrap.addVertex('A');dgrap.addVertex('B');dgrap.addVertex('C');dgrap.addVertex('D');dgrap.addVertex('E');dgrap.addVertex('F');
        dgrap.addEdge('A','B',2);
        dgrap.addEdge('B','C',3);
        dgrap.addEdge('C','E',2);
        dgrap.addEdge('A','D',6);
        dgrap.addEdge('C','D',1);
        dgrap.addEdge('A','E',2);
        dgrap.addEdge('E','F',5);
        dgrap.findShprtestPath();

    }
}
