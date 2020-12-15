package com.Revision.GraphQuestion;

public class GraphClient {
    public static void main(String[] args) {
        MyGraph<Character> firstGraph = new MyGraph<>();
        firstGraph.addVertex('A');
        firstGraph.addVertex('B');
        firstGraph.addVertex('C');
        firstGraph.addVertex('D');
        firstGraph.addVertex('E');
        firstGraph.addEdge('A','B');
        firstGraph.addEdge('A','D');
        firstGraph.addEdge('B','E');
        firstGraph.addEdge('C','E');
        firstGraph.printGraph();
    }
}
