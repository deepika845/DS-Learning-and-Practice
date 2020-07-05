package com.deepika.problem.solving.Graphs;

public class GraphCKient {
    public static void main(String[] args) {
        GraphUsingAdjacencyList<String> gui = new GraphUsingAdjacencyList<String>();
        gui.addVertex("A");
        gui.addVertex("B");
        gui.addVertex("C");
        gui.addVertex("D");
        gui.addVertex("E");
        gui.addVertex("F");
        gui.addVertex("G");
        gui.addVertex("H");
        gui.addEdge("A","B");
        gui.addEdge("B","C");
        gui.addEdge("C","E");
        gui.addEdge("D","E");
        gui.addEdge("B","D");
        gui.addEdge("F","G");
        gui.addEdge("H","F");
        //gui.addEdge("D","E");
      //  gui.display();
        gui.connectedcomponents();
       // gui.depthFirst();
        //gui.breadthFirst();
        gui.display();
        //System.out.println(gui.isBarpitite());
        System.out.println(gui.count);
    }
}
