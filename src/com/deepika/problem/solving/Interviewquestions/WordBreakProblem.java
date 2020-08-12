package com.deepika.problem.solving.Interviewquestions;

import java.util.HashSet;
import java.util.Set;

public class WordBreakProblem {
    static  Set<String> dictionary = new HashSet<String>();
    public static boolean findIfBreakable(String s){
        int size = s.length();
        if (size == 0){
            return  true;
        }
        for (int i=1;i<=size;i++){
            if (dictionary.contains(s.substring(0,i)) && findIfBreakable(s.substring(i,size))){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String[] duct = {"mobile","samsung","sam","sung",
                "man","mango","icecream","and",
                "go","i","like","ice","cream"};
        for (String ss : duct){
            dictionary.add(ss);
        }
        System.out.println(findIfBreakable("ilikesamsung"));

    }
}
