package com.Revision.BackTracking;

import java.util.HashMap;
import java.util.Scanner;

public class PalindromicPermutation {

    public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {
        if(cs>ts){
            String rev="";
            for (int i=asf.length()-1;i>=0;i--){
                rev=rev+(asf.charAt(i));
            }
            if(oddc!=null){
                asf=asf+oddc;
            }
            System.out.println(asf+rev);
            return;
        }
        for(Character ch: fmap.keySet()){
            int freq=fmap.get(ch);
            if(freq>0){
                fmap.put(ch,freq-1);
                generatepw(cs+1,ts,fmap,oddc,asf+ch);
                fmap.put(ch,freq);
            }
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        HashMap<Character, Integer> fmap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
        }
        Character ch = null;
        int odd = 0 ;
        int len=0;
        for(Character key: fmap.keySet()){
            int val = fmap.get(key);
            if(val%2 != 0){
                odd++;
                ch = key;
            }
            fmap.put(key,val/2);
            len=len+(val/2);
        }
        if(odd>1){
            System.out.println(-1);
        }
        else{
            generatepw(1,len,fmap,ch,"");
        }

        //write your code here
    }
}
