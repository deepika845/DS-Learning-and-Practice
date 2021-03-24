package com.Revision.GraphQuestion;


public class GraphClient {
    public static void main(String[] args) {
        MyGraph<Character> firstGraph = new MyGraph<>();
        firstGraph.addVertex('A');
        firstGraph.addVertex('B');
        firstGraph.addVertex('C');
        firstGraph.addVertex('D');
        firstGraph.addVertex('E');
        firstGraph.addVertex('F');
        firstGraph.addEdge('A','B');
        firstGraph.addEdge('C','B');
        firstGraph.addEdge('E','C');
        firstGraph.addEdge('E','F');
        firstGraph.addEdge('C','D');
        firstGraph.addEdge('F','D');
        //firstGraph.printGraph();
        //firstGraph.findDFS();
 //       System.out.println(firstGraph.containsCycle());
   //     MyGraph.Vertex root = firstGraph.cloneTheGraph();
        firstGraph.topologicalSort();
    }
}
