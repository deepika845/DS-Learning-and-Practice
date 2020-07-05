package com.deepika.problem.solving.Heaps;

import com.deepika.GenricsInterface.Car;

public class GenericHeapClient {
    public static void main(String[] args) {


    Car[] cararr = new Car[5];
    cararr[0] = new Car(1000,400,"Red");
    cararr[1] = new Car(2000,200,"Yellow");
    cararr[2] = new Car(500,900,"Black");
    cararr[3] = new Car(300,30,"Grey");
    cararr[4] = new Car(700,60,"White");
    HeapGenerics<Car> heapg = new HeapGenerics<Car>();
    heapg.add(cararr[0]);
    heapg.add(cararr[1]);
    heapg.add(cararr[2]);
    heapg.add(cararr[3]);
    heapg.add(cararr[4]);
    System.out.println(heapg.remove());
        System.out.println(heapg);
}
}
