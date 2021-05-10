package com.deepika.problem.solving.Strings;

public class LongestPalindromicSubstring {
    public  int findLongestPalindromicSubstring(String s){
        int maxLength=0;
        for (int i=0;i<s.length();i++){
            int left=i;
            int right=i;
            while (left>=0 && right<s.length()){
                if (s.charAt(left--)==s.charAt(right++)){
                    maxLength=Math.max(maxLength,s.substring(left+1,right).length());
                }
                else {
                    break;
                }
            }
            left=i;
            right=i+1;
            while (left>=0 && right<s.length()){
                if (s.charAt(left--)==s.charAt(right++)){
                    maxLength=Math.max(maxLength,s.substring(left+1,right).length());
                }
                else {
                    break;
                }
            }


        }
        return maxLength;

    }
    public static void main(String[] args) {



    }
}
