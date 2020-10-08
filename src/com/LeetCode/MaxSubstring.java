package com.LeetCode;

public class MaxSubstring{
    public int lengtOfLongestSubstring(String unprocessed){
        String processed="";
        String max = "";
        return findSubString(unprocessed,processed,max);
    }

    private int findSubString(String unprocessed, String processed, String max) {
        if(unprocessed.length()==0){
            return max.length();
        }
        char ch = unprocessed.charAt(0);
        unprocessed=unprocessed.substring(1);
        if(processed.indexOf(String.valueOf(ch))==-1) {
            processed += String.valueOf(ch);
        }
        else{
            int lm=processed.indexOf(String.valueOf(ch));
            processed=processed.substring(lm+1,processed.length())+String.valueOf(ch);
        }
        if(processed.length()>max.length()){
            max=processed;
        }

        return findSubString(unprocessed,processed,max);
    }

    public static void main(String[] args) {
        MaxSubstring ms = new MaxSubstring();
        System.out.println(  ms.lengtOfLongestSubstring("dvdf"));
    }
}