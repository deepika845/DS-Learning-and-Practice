package com.deepika.problem.solving.array;

import java.util.HashMap;

public class RomanToInteger {
    public static int findRomanToInteger(String roman){
        HashMap<Character,Integer> hm= new HashMap<>();
        hm.put('I',1);hm.put('V',5);hm.put('X',10);hm.put('L',50);hm.put('C',100);hm.put('D',500);hm.put('M',1000);
        int sum=hm.get(roman.charAt(roman.length()-1));
        for (int i=roman.length()-2;i>=0;i--){
            if(hm.get(roman.charAt(i))<hm.get(roman.charAt(i+1))){
                sum-=hm.get(roman.charAt(i));
            }
            else {
                sum+=hm.get(roman.charAt(i));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(findRomanToInteger("IX"));
    }
}
