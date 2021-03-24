package com.Revision.GraphQuestion;


import java.util.*;

public class MyGraph<T> {
    HashMap<T,Vertex> allVertices = new HashMap<T, Vertex>();
    HashMap<Vertex,Vertex> parent = new HashMap<>();
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
            //allVertices.get(second).neighbours.add(allVertices.get(first));
            return true;
        }
        return false;
    }
    public Vertex cloneTheGraph(){
        Vertex firstVertex = allVertices.entrySet().iterator().next().getValue();
        HashMap<T,Vertex> containedMap=new HashMap<>();
        Vertex nodeClone= cloneTheGraph(firstVertex,containedMap);
        return nodeClone;
    }
    public Vertex cloneTheGraph(Vertex node,HashMap<T,Vertex> containedMap){
        if(node==null){
            return node;
        }
        if(containedMap.containsKey(node.val)){
            return containedMap.get(node.val);
        }
        Vertex cr = new Vertex(node.val);
        for (Vertex padosi : node.neighbours){
            cr.neighbours.add(cloneTheGraph(padosi,containedMap));
        }
        return cr;
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
    public void findBST(){
        Queue<Vertex> maintainedQueue = new LinkedList<>();
        List<T> visitedVertex = new ArrayList<>();
        maintainedQueue.add(allVertices.entrySet().iterator().next().getValue());
        visitedVertex.add(allVertices.entrySet().iterator().next().getKey());
        while (!maintainedQueue.isEmpty()){
            Vertex popped = maintainedQueue.remove();
            System.out.print(popped.val+" , ");
            for (Vertex padosi : popped.neighbours){
                if(!visitedVertex.contains(padosi.val)){
                    maintainedQueue.add(padosi);
                    visitedVertex.add(padosi.val);
                }
            }
        }
    }
    public void topologicalSort(){
        Integer time =1;
        Stack<T> allRecord = new Stack<>();
        List<T> visited = new ArrayList<>();
        for (Vertex corner : allVertices.values()){
            if(visited.contains(corner.val)){
                continue;
            }
            time = topologicalSort(allRecord,visited,corner,time);
        }
        while (!allRecord.isEmpty()){
            T g=allRecord.pop();
            System.out.println(g);
        }
    }
    private Integer topologicalSort(Stack<T> allRecord, List<T> visited, Vertex corner,Integer timeLast) {
        visited.add(corner.val);
        T vv=corner.val;
        for (Vertex padosi : corner.neighbours){
            if(visited.contains(padosi.val)){
                continue;
            }
            topologicalSort(allRecord,visited,padosi,timeLast++);
        }
        allRecord.push(corner.val);
        return timeLast;
    }

    public void setParent()
    {
        for (Vertex padosi : allVertices.values()){
            parent.put(padosi,null);
        }
    }

    public boolean containsCycle(){
        Queue<Vertex> maintainedQueue = new LinkedList<>();
        List<T> allVisited = new ArrayList<>();
        setParent();
        maintainedQueue.add(allVertices.entrySet().iterator().next().getValue());
        allVisited.add(allVertices.entrySet().iterator().next().getKey());
        while (!maintainedQueue.isEmpty()){
            Vertex popped = maintainedQueue.remove();
            for (Vertex padosi : popped.neighbours){
                if(!allVisited.contains(padosi.val)){
                allVisited.add(padosi.val);
                maintainedQueue.add(padosi);
                }
                else{
                    if(hasCycle(popped,padosi)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean hasCycle(Vertex popped, Vertex padosi) {
        Vertex first = find(popped);
        Vertex second = find(padosi);
        if(first!=second){
            parent.put(padosi,popped);
            return false;
        }
        return true;
    }

    private Vertex find(Vertex popped) {
        while (parent.get(popped)!=null){
            popped=parent.get(popped);
        }
        return popped;
    }

    public void findDFS(){
        Stack<Vertex> maintainedQueue = new Stack<>();
        List<T> visitedVertex = new ArrayList<>();
        maintainedQueue.add(allVertices.entrySet().iterator().next().getValue());
        visitedVertex.add(allVertices.entrySet().iterator().next().getKey());
        while (!maintainedQueue.isEmpty()){
            Vertex popped = maintainedQueue.pop();
            System.out.print(popped.val+" , ");
            for (Vertex padosi : popped.neighbours){
                if(!visitedVertex.contains(padosi.val)){
                    maintainedQueue.push(padosi);
                    visitedVertex.add(padosi.val);
                }
            }
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
