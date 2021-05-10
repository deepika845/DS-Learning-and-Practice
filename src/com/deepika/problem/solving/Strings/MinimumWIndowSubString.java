package com.deepika.problem.solving.Strings;

import java.util.HashMap;

public class MinimumWIndowSubString {
    public static int  findWindow(String hay,String needle){
        int ansArray[]={-1,0,0};
        HashMap<Character,Integer> needleMap=new HashMap<>();
        for (int i=0;i<needle.length();i++){
            char ch=needle.charAt(i);
            needleMap.put(ch,needleMap.getOrDefault(ch,0)+1);
        }
        HashMap<Character,Integer> window= new HashMap<>();
        int required=needleMap.size();
        int formed= 0;
        int l=0;int r=0;
        while (r<hay.length()){
            char ch=hay.charAt(r);
            int x= window.getOrDefault(ch,0);
            window.put(ch,x+1);
            if (needleMap.containsKey(ch)&&(needleMap.get(ch)==window.get(ch))){
                formed++;
            }
            while (l<=r &&(formed==required)){
                char ch1=hay.charAt(l);
                if (ansArray[0]==-1 || (r-l+1<ansArray[0])){
                    ansArray[0]=r-l+1;
                    ansArray[1]=l;
                    ansArray[2]=r;
                }
                window.put(ch1,window.getOrDefault(ch1,0)-1);
                if (needleMap.containsKey(ch1) && needleMap.get(ch1)>window.get(ch1)){
                    formed--;
                }
                l++;
            }
            r++;

        }
        return ansArray[0];

    }
    public static void main(String[] args) {
        System.out.println(findWindow("anbabrsswerswaaca","rsw"));

    }
}