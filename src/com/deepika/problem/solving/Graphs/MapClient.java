package com.deepika.problem.solving.Graphs;

public class MapClient {

    public static void main(String[] args) {

        AdjacencyMapGraph<String> map = new AdjacencyMapGraph<>();
        map.addVertex("A");
        map.addVertex("B");
        map.addVertex("C");
        map.addVertex("D");

        map.addEdgeweight("A","B",4);
        map.addEdgeweight("B","C",2);
        map.addEdgeweight("C","D",1);
        map.addEdgeweight("A","D",2);

        AdjacencyMapGraph<String> mapGraph = map.Kruskal();

        mapGraph.display();
    }
}
