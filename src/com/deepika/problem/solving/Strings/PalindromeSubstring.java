package com.deepika.problem.solving.Strings;

public class PalindromeSubstring {
    public static int maxPalindomic(String str){
        int maxPalindrmicLength=Integer.MIN_VALUE;
        for (int i=0;i<str.length();i++){
            int left=i;
            int right=i;
            while (left>=0 && right<str.length()){
                if (str.charAt(left--)==str.charAt(right++)){
                    maxPalindrmicLength=Math.max(maxPalindrmicLength,right-left-1);
                }
                else {
                    break;
                }
            }
        }
        for (int i=0;i<str.length();i++){
            int left=i;
            int right=i+1;
            while (left>=0 && right<str.length()){
                if (str.charAt(left--)==str.charAt(right++)){
                    maxPalindrmicLength=Math.max(maxPalindrmicLength,right-left-1);
                }
                else {
                    break;
                }
            }
        }
        return maxPalindrmicLength;
    }
    public static void main(String[] args) {
        System.out.println(maxPalindomic("abadada"));
    }
}
