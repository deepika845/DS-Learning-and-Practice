package com.deepika.problem.solving.recursion;

public class LongestPalindrome {
    public static int findMaxPalindrome(String s,int i,int j){
        if(i==j){
            return 1;
        }
        if(s.charAt(i)==s.charAt(j)&& i+1==j){
            return 2;
        }
        if(s.charAt(i)==s.charAt(j)){
            return findMaxPalindrome(s,i+1,j-1)+2;
        }
       return Math.max(findMaxPalindrome(s,i+1,j),findMaxPalindrome(s,i,j-1));
    }
    public static void main(String[] args) {
        System.out.println(findMaxPalindrome("deepikape",0,8));
    }

}
