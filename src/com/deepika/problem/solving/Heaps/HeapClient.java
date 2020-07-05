package com.deepika.problem.solving.Heaps;

public class HeapClient {
    public static void main(String[] args) {
        Heap hh = new Heap();
        hh.add(10);
        hh.display();
        hh.add(20);
        hh.display();
        hh.add(30);
        hh.display();
        hh.add(40);
        hh.display();
        hh.add(5);
        hh.display();
        hh.add(3);
        hh.display();
        hh.remove();
        hh.display();
    }
}
