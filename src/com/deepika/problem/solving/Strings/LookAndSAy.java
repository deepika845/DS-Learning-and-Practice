package com.deepika.problem.solving.Strings;

public class LookAndSAy {
    public static void main(String[] args) {
        System.out.println(findNthLookAndSay(4).toString());
       // System.out.println(s);
    }

    private static StringBuilder findNthLookAndSay(int i) {
        return findNthLookAndSay1(i,1,new StringBuilder("1"));
    }
    private static StringBuilder findNthLookAndSay1(int i,int j,StringBuilder s){
        if(i==j){
            return s;
        }
        int index=1;
        StringBuilder sb =new StringBuilder();
        for (int k=0;k<s.length();k++){

            if(k==s.length()-1){
                sb.append(index);
                sb.append(s.charAt(k));
                break;
            }
            if(s.charAt(k)==s.charAt(k+1)){
                index++;
                continue;
            }
            else {
                sb.append(index);
                sb.append(s.charAt(k));
            }
        }
        return findNthLookAndSay1(i,j+1,sb);
    }

}//Time Complexity O(n*2^n)
