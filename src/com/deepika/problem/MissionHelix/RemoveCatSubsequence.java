package com.deepika.problem.MissionHelix;

public class RemoveCatSubsequence {
    public static void removeCatSubSequenece(String processed,String unprocessed,String backup){
        if(unprocessed.equals("")){
            System.out.println(processed.length());
            System.out.println(processed);
            return;
        }
        char ch=unprocessed.charAt(0);
        unprocessed=unprocessed.substring(1);
        if(ch=='c'||ch=='a'||ch=='t'){
            backup+=String.valueOf(ch);
            if(backup.indexOf("cat")==-1){
               // backup+=String.valueOf(ch);
                processed+=String.valueOf(ch);
            }
            else {
                backup=backup.substring(0,backup.length()-1);
            }
        }
        else {
            processed+=String.valueOf(ch);
        }
        removeCatSubSequenece(processed,unprocessed,backup);
    }
    public static void main(String[] args) {
        removeCatSubSequenece("","abcaef","");

    }
}
