package com.deepika.problem.solving.Strings;

import java.util.*;

public class RomanToumeral {
    private static final HashMap<String,Integer> mapping = new HashMap<String, Integer>();

    public static void main(String[] args) {
        mapping.put("I",1);
        mapping.put("V",5);
        mapping.put("X",10);
        mapping.put("L",50);
        mapping.put("C",100);
        mapping.put("D",500);
        mapping.put("M",1000);
        mapping.put("IV",4);
        mapping.put("IX",9);
        mapping.put("XL",40);
        mapping.put("XC",90);
        mapping.put("CD",400);
        mapping.put("CM",900);
    //    int i = romanToNumeral("V");
      //  System.out.println(i);
       // numeralToRoman(1296);
    }
        private static int romanToNumeral(String s) {
        if(s.length()==0){
            return 0;
        }
        int fs=0;
        if (s.length() == 1) {
            return mapping.get(s);
        }
        String ch =s.substring(0,1);
        String ch1 =s.substring(0,2);
        if(mapping.containsKey(ch1)){
            fs = mapping.get(ch1);
            fs=fs+romanToNumeral(s.substring(2));
        }
        else if(mapping.containsKey(ch)){
            fs=mapping.get(ch);
            fs=fs+romanToNumeral(s.substring(1));
        }
        return fs;
    }
}
