package com.Revision.GraphQuestion;

public class GraphClient {
    public static void main(String[] args) {
        MyGraph<Character> firstGraph = new MyGraph<>();
        firstGraph.addVertex('A');
        firstGraph.addVertex('B');
        firstGraph.addVertex('C');
        firstGraph.addVertex('D');
        firstGraph.addVertex('E');
        firstGraph.addEdge('B','A');
        firstGraph.addEdge('B','C');
        firstGraph.addEdge('E','A');
        firstGraph.addEdge('D','E');
        firstGraph.addEdge('A','D');
        //firstGraph.printGraph();
        //firstGraph.findDFS();
        System.out.println(firstGraph.containsCycle());
    }
}
