package com.deepika.problem.solving.HashMap;

public class HashClient {
    public static void main(String[] args) {


    HashTable<String,Integer> map = new HashTable<String, Integer>(4);
    map.put("USA",200);
        map.put("UK",175);
        map.put("India",100);
        map.put("India",677);
        map.display();
        map.put("China",350);
        map.display();
       // map.put("Sweden",100);
        //map.display();
        //map.put("India",677);
       // map.display();
        //map.put("Nepal",50);
        //map.display();
        //map.put("Ireland",75);
        //map.display();
        //complexity 0(n) in case of put functions
        //System.out.println("*****Get*****");
        //System.out.println(map.get("India"));
        //System.out.println(map.get("RSa"));
        //System.out.println("-----testRemove--------");
        //System.out.println(map.remove("India"));
        //map.display();


}}
