package com.deepika.problem.solving.Graphs;

import java.util.*;

public class GraphUsingAdjacencyList<T> {
    LinkedList<Vertex> vertices;
    int count = 0;
    int numVertex;

    GraphUsingAdjacencyList(){
        this.vertices = new LinkedList<Vertex>();
        numVertex = 0;
    }
    public void addVertex(T value){
        vertices.add(new Vertex(value));
        ++numVertex;
    }
    public Vertex getVertex(T val){
        for (Vertex vertex : vertices){
            if(vertex.value.equals(val))
            return vertex;
        }
        return null;
    }
    public void addEdge(T aa,T bb){
        Vertex first = getVertex(aa);
        Vertex second = getVertex(bb);
        if(first != null && second != null){
        first.neighbours.add(second);
        second.neighbours.add(first);
        }
    }
    public void connectedcomponents(){

        Queue<Vertex> queue = new LinkedList<Vertex>();
        Set<Vertex> visited= new HashSet<Vertex>();

        for (Vertex vertex:vertices) {

            if(visited.contains(vertex)){
                continue;
            }
            ++count;

            System.out.println();
            queue.add(vertex);
            visited.add(vertex);

            while(!queue.isEmpty()) {

                Vertex temp = queue.remove();

                System.out.println(temp.value);

                for (Vertex padosi : temp.neighbours) {

                    if (!visited.contains(padosi)) {

                        visited.add(padosi);
                        queue.add(padosi);
                    }
                }
            }
        }
    }
    public boolean isBarpitite(){
        Queue<Vertex> queue = new LinkedList<Vertex>();
        HashSet<Vertex> visited = new HashSet<Vertex>();
        Vertex vertex = vertices.get(0);
        HashSet<Vertex> red = new HashSet<Vertex>();
        HashSet<Vertex> green = new HashSet<Vertex>();
        red.add(vertex);
        queue.add(vertex);
        visited.add(vertex);
        while (!queue.isEmpty()){
            Vertex temp = queue.remove();
            if(red.contains(temp)){
                for (Vertex padosi : temp.neighbours){
                    if(!visited.contains(temp)){
                        queue.add(temp);
                        visited.add(temp);
                        green.add(temp);
                    }
                    else if(red.contains(temp)){
                        return false;
                    }
                }
            }
            else
                {
                for (Vertex padosi : temp.neighbours){
                    if(!visited.contains(temp)){
                        queue.add(temp);
                        visited.add(temp);
                        red.add(temp);
                    }
                    else if(green.contains(temp)){
                        return false;
                    }
                }
            }
            }
        return true;
        }

    public void depthFirst(){
        Stack<Vertex> stack = new Stack<Vertex>();
        Set<Vertex> visited = new HashSet<Vertex>();
        for (Vertex vertex : vertices){
            if(visited.contains(vertex)){
                continue;
            }
            stack.push(vertex);
            visited.add(vertex);
            while (!stack.isEmpty()){
                Vertex temp = stack.pop();
                System.out.println(temp.value);
                for (Vertex vertex1 : temp.neighbours){
                    if(!visited.contains(vertex1)){
                        stack.push(vertex1);
                        visited.add(vertex1);
                    }
                }
            }
        }
    }
    public void breadthFirst(){
        Queue<Vertex> stack = new LinkedList<Vertex>();
        Set<Vertex> visited = new HashSet<Vertex>();
        for (Vertex vertex : vertices){
            if(visited.contains(vertex)){
                continue;
            }
            stack.add(vertex);
            visited.add(vertex);
            while (!stack.isEmpty()){
                Vertex temp = stack.remove();
                System.out.println(temp.value);
                for (Vertex vertex1 : temp.neighbours){
                    if(!visited.contains(vertex1)){
                        stack.add(vertex1);
                        visited.add(vertex1);
                    }
                }
            }
        }
    }
    public void display(){
        for (Vertex vertex : vertices){
            System.out.print(vertex.value +  " =>");
            for (Vertex padosi : vertex.neighbours){
                System.out.print(padosi.value+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    class Vertex{
        T value;
        LinkedList<Vertex> neighbours;
        Vertex(T dd){
            value = dd;
            neighbours = new LinkedList<Vertex>();
        }
    }

}
