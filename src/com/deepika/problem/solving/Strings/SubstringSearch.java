package com.deepika.problem.solving.Strings;

public class SubstringSearch {
    public static boolean findIndexOfSubstring(String text,String pattern){
        int[] array =findArray(pattern);
        int i=0;
        int j=0;
        while (i<text.length() && j<pattern.length()){
            if(text.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            }
            else{
                if(j!=0){
                j=array[j-1];
                }
                else{
                    i++;
                }
            }
        }
        if(j==pattern.length()){
            return true;
        }
        return  false;

    }
    private static int[] findArray(String pattern){
        int lps[] = new int[pattern.length()];
        int j=0;
        int i=1;
        while (i<pattern.length()){
            if(pattern.charAt(j)==pattern.charAt(i)){
                lps[i]=j+1;
                j++;
                i++;
            }
            else{
                if(j==0){
                    lps[i]=0;
                    i++;

                }
                else{
                    j=lps[j-1];
                }

            }
        }
        return lps;
    }
    public static void main(String[] args) {
        System.out.println(findIndexOfSubstring("abxabcabccby","abcaby"));

    }
}
