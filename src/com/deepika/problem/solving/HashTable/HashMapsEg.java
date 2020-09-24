package com.deepika.problem.solving.HashTable;

import java.util.HashMap;

public class HashMapsEg {
    public static HashMap<Character,Integer> freq(String str){
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,1);
            }
            else{
                map.put(ch,map.get(ch)+1);

            }
        }
        return map;
    }
    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();
        map.put("apple","Theek");
        map.put("banana","mast");
        map.put("mango","bekar");
        System.out.println(map);
        for(String str:map.keySet()){
            System.out.println(str);
        }
        for(String str:map.values()){
            System.out.println(str);
        }
        System.out.println(freq("abaaa"));
    }
}
