package com.deepika.problem.solving.Strings;

import java.util.ArrayList;
import java.util.List;

public class MnemonicsNumPad {
    static String[] mappint = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};


    public static void main(String[] args) {
        System.out.println(findALlMnemonics("123").toString());
       // System.out.println(allMnemonics.toString());
    }

    private static List<String> findALlMnemonics(String s) {
        List<String> allmnemonics = new ArrayList<String>();
        char ch[] = new char[s.length()];
        recursion(s,allmnemonics,ch,0);
        return allmnemonics;
    }

    private static void recursion(String s, List<String> allmnemonics, char[] ch, int i) {
        if(i==s.length()){
            allmnemonics.add(String.valueOf(ch));
            return;
        }
        for (int k=0;k<mappint[s.charAt(i)-'0'].length();k++){
            char cd = mappint[s.charAt(i)-'0'].charAt(k);
            ch[i] =cd;
            recursion(s,allmnemonics,ch,i+1);

        }
    }
}
