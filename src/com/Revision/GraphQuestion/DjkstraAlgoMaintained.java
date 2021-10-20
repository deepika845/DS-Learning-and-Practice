package com.Revision.GraphQuestion;



import java.util.*;

public class DjkstraAlgoMaintained {
    static class Vertex{
        int val;
       HashMap<Vertex,Integer> neighbours;
        Vertex(int val){
            this.val=val;
            neighbours=new HashMap<>();
        }
    }
    static HashMap<Integer,Integer> parentMaintained= new HashMap<>();
    static HashMap<Integer,Integer> distFromSource= new HashMap<>();
    static List<Vertex> allVertex= new ArrayList<>();
    static HashMap<Integer,Vertex> mapMaintained= new HashMap<>();
    public static void addNeighbour(int val,int padosi,int weight){

        if(mapMaintained.get(val)==null){
          mapMaintained.put(val,new Vertex(val));
          allVertex.add(mapMaintained.get(val));
        }
        if (mapMaintained.get(padosi)==null){
            mapMaintained.put(padosi,new Vertex(padosi));
            allVertex.add(mapMaintained.get(padosi));
        }
        Vertex curr=mapMaintained.get(val);
        Vertex pd=mapMaintained.get(padosi);
        curr.neighbours.put(pd,weight);
        pd.neighbours.put(curr,weight);
    }
    public static void findDjkstra(){
        DSMaintained<Vertex> djks=new DSMaintained<>();
        Iterator it=allVertex.iterator();
        Vertex src=(Vertex) it.next();
        int ss= src.val;
        djks.add(src,0);
        distFromSource.put(src.val,0);
        parentMaintained.put(src.val,null);
        while (it.hasNext()){
            djks.add((Vertex)it.next(),Integer.MAX_VALUE );
        }
        while (!djks.isEmpty()){
            int peek= djks.peekWeight();
            Vertex min= djks.extractMin();
            int minsss=min.val;
            if(min!=src){
                distFromSource.put(min.val,peek);
            }
            for (Vertex padosi:min.neighbours.keySet()){

                if(djks.contains(padosi) && djks.getWeight(padosi)>(distFromSource.get(min.val)+padosi.neighbours.get(min))){
                    int padval=padosi.val;
                    djks.decreaseKey(padosi,distFromSource.get(min.val)+padosi.neighbours.get(min));
                    parentMaintained.put(padosi.val,min.val);
                }
            }

        }

        for (Map.Entry<Integer,Integer> ent:distFromSource.entrySet()){
            System.out.println(ent.getKey()+" => "+ent.getValue());
        }
    }
    public static void main(String[] args) {
        addNeighbour(0,1,4);
        addNeighbour(0,7,8);
        addNeighbour(1,7,11);
        addNeighbour(1,2,8);
        addNeighbour(7,8,7);
        addNeighbour(2,8,2);
        addNeighbour(7,6,1);
        addNeighbour(8,6,6);
        addNeighbour(6,5,2);
        addNeighbour(2,5,4);
        addNeighbour(2,3,7);
        addNeighbour(3,5,14);
        addNeighbour(3,4,9);
        addNeighbour(5,4,10);
        findDjkstra();


    }
}
