package com.deepika.problem.solving.HeapSection;

public class HashMapsClient {
    public static void main(String[] args) {
        HashMaps map = new HashMaps();
        map.put("apple","Theek");
        map.put("orange","mastt");
        map.put("pomegranate","loveely");
        System.out.println(map.get("apple"));
        System.out.println(map.get("orange"));
        System.out.println(map.get("pomegranate"));
       // map.remove("apple");
        //System.out.println(map.get("apple"));
        System.out.println(map);
    }
}
