package com.LeetCode.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class EdgeLengthLimitedPath {
    HashMap<Integer,Vertex> allVertex = new HashMap<>();
    class Vertex{
        int val;
        HashMap<Vertex, List<Integer>> neighbours;
        Vertex(int val){
            this.val=val;
            neighbours=new HashMap<>();
        }
    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        boolean contained[] = new boolean[queries.length];
        for(int i=0;i<edgeList.length;i++){
            addEdge(edgeList[i][0],edgeList[i][1],edgeList[i][2]);
        }
        int count =0;
        for(int j=0;j<queries.length;j++){
            count=0;
            Vertex first = allVertex.get(queries[j][0]);
            Vertex second = allVertex.get(queries[j][1]);
            for(int f : first.neighbours.get(second)){
                if(f>queries[j][2]){
                    count++;
                }
            }
            if(count==0){
                contained[j]=true;}
        }
        return contained;
    }
    public void addEdge(int ft,int sd,int weight){
        if(!allVertex.containsKey(ft)){
            allVertex.put(ft,new Vertex(ft));
        }
        if(!allVertex.containsKey(sd)){
            allVertex.put(sd,new Vertex(sd));
        }
        Vertex first = allVertex.get(ft);
        Vertex second = allVertex.get(sd);
        if(first.neighbours.containsKey(second)){
            first.neighbours.get(second).add(weight);
        }
        else{
            List<Integer> ss = new ArrayList<>();
            ss.add(weight);
            first.neighbours.put(second,ss);
        }
        if(second.neighbours.containsKey(first)){
            second.neighbours.get(first).add(weight);
        }
        else{
            List<Integer> ss = new ArrayList<>();
            ss.add(weight);
            second.neighbours.put(first,ss);
        }
    }

    public static void main(String[] args) {
        EdgeLengthLimitedPath ed = new EdgeLengthLimitedPath();
        boolean[] result=ed.distanceLimitedPathsExist(3,new int[][]{{0,1,2},{1,2,4},{2,0,8},{1,0,16}},new int[][]{{0,1,2},{0,2,5}});
        System.out.println(Arrays.toString(result));
    }

}