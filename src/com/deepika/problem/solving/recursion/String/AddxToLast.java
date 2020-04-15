package com.deepika.problem.solving.recursion.String;

public class AddxToLast {
    public static void methodDriven(String processed,String unprocessed,int count){
        if(unprocessed.isEmpty()){
            StringBuffer sk=returnString(processed,count);
            System.out.println(sk);
            return;
        }
        char ch=unprocessed.charAt(0);
        if(ch=='x'){
            methodDriven(processed,unprocessed.substring(1),count+1);
        }else {
            methodDriven(processed + ch, unprocessed.substring(1), count);
        }
    }
    public static StringBuffer returnString(String processed,int count){
        StringBuffer sb = new StringBuffer(processed);


        for(int i=0;i<count;i++){
            sb.append('x');
        }
        return sb;
    }
    public static void main(String[] args) {
        methodDriven("","abexxedgfxfft",0);
    }
}
