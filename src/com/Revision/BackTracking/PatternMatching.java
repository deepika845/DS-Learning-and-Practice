package com.Revision.BackTracking;
import java.io.*;
import java.util.*;
public class PatternMatching {




        public static void solution(String str, String pattern, HashMap<Character,String> map, String op){
            //write your code here
            if(pattern.length()==0){
                if(str.length()==0){
                    HashSet<Character> hm= new HashSet<Character>();
                    for(int i=0;i<op.length();i++){
                        if(!hm.contains(op.charAt(i))){
                            System.out.print(op.charAt(i)+" -> "+map.get(op.charAt(i))+", ");
                        }
                    }
                    System.out.println(" .");

                }
                return;

            }
            char ch= pattern.charAt(0);
            if(map.containsKey(ch)){
                String prevMap=map.get(ch);
                if(str.length()>=prevMap.length() && prevMap.equals(str.substring(0,prevMap.length()))){
                    solution(str.substring(prevMap.length()),pattern.substring(1),map,op);
                }
            }
            else{
                for(int i=0;i<str.length();i++){
                    map.put(ch,str.substring(0,i+1));
                    solution(str.substring(i+1),pattern.substring(1),map,op);
                    map.remove(ch);
                }
            }

        }
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            String str = scn.next();
            String pattern = scn.next();
            HashMap<Character,String> map = new HashMap<>();
            solution(str,pattern,map,pattern);
        }

}
