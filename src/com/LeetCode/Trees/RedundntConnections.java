package com.LeetCode.Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RedundntConnections  {
    public static int[] findRedundantDirectedConnection(int[][] edges) {
        HashMap<Integer, List<Integer>> vertexes=new HashMap<>();
        for(int i=0;i<edges.length;i++){
            if(vertexes.containsKey(edges[i][0])){
                vertexes.get(edges[i][0]).add(edges[i][1]);
            }
            else{
                vertexes.put(edges[i][0],new ArrayList<Integer>());
                vertexes.get(edges[i][0]).add(edges[i][1]);
            }
            if(!vertexes.containsKey(edges[i][1])){
                vertexes.put(edges[i][1],new ArrayList<Integer>());

            }
        }
        int[] ans=new int[2];
        boolean req[]= new boolean[vertexes.size()+1];
        boolean visited[] = new boolean[vertexes.size()+1];
        findRedundant(vertexes.keySet().iterator().next(),vertexes,req,visited,ans);
        return ans;
    }
    public static boolean findRedundant(int currVert,HashMap<Integer,List<Integer>> vertexes,boolean[] req,boolean[] visited,int[] ans){
        if(req[currVert]){
            return true;
        }
        if(visited[currVert]){
            return true;
        }
        req[currVert]=true;
        visited[currVert]=true;
        for(int padosi:vertexes.get(currVert)){
            if(findRedundant(padosi,vertexes,req,visited,ans)){
                ans[0]=currVert;
                ans[1]=padosi;
                return false;
            }
        }
        req[currVert]=false;
        return false;

    }

    public static void main(String[] args) {
        findRedundantDirectedConnection(new int[][]{{1,2},{1,3},{2,3}});

    }

}
