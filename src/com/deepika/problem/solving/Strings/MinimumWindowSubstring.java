package com.deepika.problem.solving.Strings;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static int findWindowSubstring(String actual,String window){
        HashMap<Character,Integer> windowMap = new HashMap<Character, Integer>();
        for (int i=0;i<window.length();i++){
            if(!windowMap.containsKey(window.charAt(i))){
                windowMap.put(window.charAt(i),1);
            }
            else {
                windowMap.put(window.charAt(i),windowMap.get(window.charAt(i)));
            }
        }
       int startPoint =0;
        int endPoint=0;
        int i=0;
        int minLen =Integer.MAX_VALUE;
        HashMap<Character,Integer> minWindow = new HashMap<Character, Integer>();
        while (endPoint<actual.length()){
            if(minWindow.size()==windowMap.size()){
                if(minLen>(endPoint-startPoint)){
                    minLen=(endPoint-startPoint);
                }
                if(minWindow.get(actual.charAt(startPoint))==1){
                    minWindow.remove(actual.charAt(startPoint));
                }
                else if(minWindow.get(actual.charAt(startPoint))>1){
                    minWindow.put(actual.charAt(startPoint),minWindow.get(actual.charAt(startPoint))-1);
                }
                startPoint=startPoint+1;
                continue;
            }
            if(windowMap.containsKey(actual.charAt(i))){
                if(!minWindow.containsKey(actual.charAt(i))){
                    minWindow.put(actual.charAt(i),1);
                }
                else {
                    minWindow.put(actual.charAt(i),minWindow.get(actual.charAt(i))+1);
                }
                endPoint=i;
                i++;
            }
            else {
                i++;
            }
        }
        return minLen;


    }

    public static void main(String[] args) {
        findWindowSubstring("abbaacdbcab","abc");

    }
}
