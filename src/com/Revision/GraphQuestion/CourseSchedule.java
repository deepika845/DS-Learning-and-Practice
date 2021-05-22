package com.Revision.GraphQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseSchedule { HashMap<Integer,Vertex> allVertex= new HashMap<>();
    class Vertex{
        int val;
        List<Vertex> neighbours;
        Vertex(int val){
            this.val=val;
            neighbours= new ArrayList<Vertex>();
        }
    }
    public void addEdge(int a,int b){
        if(!allVertex.containsKey(a)){
            allVertex.put(a,new Vertex(a));
        }
        if(!allVertex.containsKey(b)){
            allVertex.put(b,new Vertex(b));
        }
        allVertex.get(a).neighbours.add(allVertex.get(b));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i=0;i<prerequisites.length;i++){
            addEdge(prerequisites[i][0],prerequisites[i][1]);
        }

        List<Integer> stack = new ArrayList<Integer>();
        List<Integer> visited= new  ArrayList<Integer>();
        for(Vertex curr: allVertex.values()){
            if(!visited.contains(curr.val)){
                if( !findPath(curr,stack,visited)){
                    return false;
                }
            }
            else if(visited.contains(curr.val)&&!stack.contains(curr.val)){
                return false;
            }
        }
        return allVertex.size()==numCourses;

    }
    public boolean findPath(Vertex curr, List<Integer> stack,List<Integer> visited){
        visited.add(curr.val);
        for(Vertex padosi:curr.neighbours){
            if(!visited.contains(padosi.val)){
                findPath(padosi,stack,visited);
            }
            else if(visited.contains(padosi.val)&&!stack.contains(padosi.val)){
                return false;
            }
        }
        stack.add(curr.val);
        return true;
    }

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        cs.canFinish(2,new int[][]{{0,1},{1,0}});
    }
}
