package com.deepika.problem.solving.Strings;

public class SinusoidalPattern {
    public static void main(String[] args) {
        sinusoidal("helloworld");
    }

    private static void sinusoidal(String s) {
        StringBuilder sb =new StringBuilder();
        sb.append(" ");
        for(int i=1;i<s.length() ;i+=4 ){
           sb.append(s.charAt(i));
            sb.append("     ");
        }
        sb.append("\n");
        System.out.print(sb);
        sb=new StringBuilder("");
        for (int i=0;i<s.length();i+=2){
            sb.append(s.charAt(i));
            sb.append("  ");
        }
        sb.append("\n    ");
        System.out.print(sb);
        sb=new StringBuilder("");
        for (int i=3;i<s.length();i+=4){
            sb.append(s.charAt(i));
            sb.append("     ");
        }
        sb.append("\n  ");
        System.out.print(sb);
    }

}
