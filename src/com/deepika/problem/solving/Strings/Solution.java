package com.deepika.problem.solving.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public static int numDecodings(String s) {
        HashMap<Integer,Character> maps= new HashMap<Integer,Character>();
        for(int i=1;i<=26;i++){
            maps.put(i,(char)('a'+i-1));
        }
        List<String> allDecode = new ArrayList<String>();
        allDecodings(allDecode,maps,"",0,s);
        return allDecode.size();
    }
    public static void allDecodings(List<String> allDecode,HashMap<Integer,Character> maps,String backUp,int start,String k){
        if(start==k.length()){
            allDecode.add(backUp);
            return;
        }
        for(int i=start;i<k.length();i++){
            int jo = Integer.parseInt(k.substring(start,i+1));
            if(jo<1 || jo>26){
                return;
            }
            String ff =backUp;
            ff +=Integer.toString(maps.get(jo));
            allDecodings(allDecode,maps,ff,i+1,k);
        }
    }

    public static void main(String[] args) {
        System.out.println( numDecodings("123"));
    }
}