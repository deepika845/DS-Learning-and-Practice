package com.deepika.problem.solving.Graphs;

public class MapCliennt {

    public static void main(String[] args) {

        MapusingAdjacencyList<String> gui = new MapusingAdjacencyList<>();

        gui.addVertex("A");
        gui.addVertex("B");
        gui.addVertex("C");
        gui.addVertex("D");
        gui.addVertex("E");
        gui.addVertex("F");
        gui.addEdge("A","B");
        gui.addEdge("A","C");
        gui.addEdge("A","F");
        gui.addEdge("B","D");
        gui.addEdge("B","E");
        gui.addEdge("C","D");
        gui.addEdge("D","E");
        //  gui.display();
        // gui.connectedcomponents();
        gui.DFT();
        //System.out.println(gui.count);

    }
}
