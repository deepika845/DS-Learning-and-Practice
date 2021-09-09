package com.LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    public  static boolean wordBreak(String s, List<String> wordDict) {

        for(int i=0;i<s.length();i++){
            String curr=s.substring(0,i+1);
            boolean bb= wordDict.contains(curr);
            if(bb ){
       return wordBreak(s.substring(i+1),wordDict);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        List<String> dict= new ArrayList<>();
        dict.add("leet");
        dict.add("code");
        wordBreak("leetcode",dict);
    }
}
