package com.deepika.problem.solving.recursion.String;

public class CountHI {
    static int count=0;
    public static int countHi(String s,int count){

        if(s.isEmpty()){
            return count;
        }
        if(s.length()>=2 && "hi".equals(s.substring(0,2))){
            return countHi(s.substring(2),count+1);
        }
        else{
            return countHi(s.substring(1),count);
        }
    }
    public static void replaceBye(String processed,String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        char ch=unprocessed.charAt(0);
        if(unprocessed.length()>=2 && "hi".equals(unprocessed.substring(0,2))){
            replaceBye(processed+"bye",unprocessed.substring(2));
        }
        else{
            replaceBye(processed+ch,unprocessed.substring(1));
        }


    }

    public static void main(String[] args) {
        //System.out.println(countHi("hihitjahihs",0));
        replaceBye("","hihitjahihs");
    }
}
