package com.deepika.problem.solving.Strings;

import java.util.Scanner;

public class EncodeDecode {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int ss = s.nextInt();
        String i = encoder(ss);
        System.out.println(i);
        //System.out.println( decoder(ss));
       // System.out.println(DecodedValue);
    }

    private static String encoder(int ss) {
        boolean isNegative = false;
        if(ss<0){
            isNegative=true;
        }
        StringBuilder encoded= new StringBuilder();
        if(isNegative){
            ss=-ss;
        }
        while (ss>0){
            encoded.append((char)('0'+ss%10));
            ss=ss/10;
        }
        if(isNegative){
            encoded.append('-');
        }
        encoded.reverse();
        return encoded.toString();
    }


    private static int decoder(String ss) {
       // boolean isNegative =false;
        int len = ss.length();
        int sum=0;
        //int powerOfTen = (int) Math.pow(10.0,(double) len-1);
        for (int i=(ss.charAt(0)=='-')?1:0;i<len;i++){
            sum=(sum*10)+(ss.charAt(i)-'0');
            //powerOfTen=powerOfTen/10;
        }
        return (ss.charAt(0)=='-' ? -sum:sum);
    }
}
