package com.deepika.problem.solving.Graphs;

public class KruskalClient {
    public static void main(String[] args) {
        KrusKal<String> kk = new KrusKal<String>();
        kk.addVertex("A");
        kk.addVertex("B");
        kk.addVertex("C");
        kk.addVertex("D");
        kk.addVertex("E"); kk.addVertex("F");
        kk.addEdgeWeight("A","B",1);
        kk.addEdgeWeight("A","C",1);
        kk.addEdgeWeight("B","E",2);
        kk.addEdgeWeight("D","E",5);
        kk.addEdgeWeight("C","D",8);
        kk.addEdgeWeight("E","F",9);
        KrusKal<String> min = kk.kruskMethod();
        min.display();

    }
}
