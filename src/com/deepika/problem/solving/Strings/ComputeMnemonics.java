package com.deepika.problem.solving.Strings;

public class ComputeMnemonics {
    public static void main(String[] args) {
        computeAllmnemonics("12345","");
    }

    private static void computeAllmnemonics(String unprocessed,String processed ) {
        if(unprocessed.length()==0){
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        unprocessed=unprocessed.substring(1);
        int digit = ch-'0';
        for (int i=3*(digit-1);i<3*digit;i++){
            if(i==26){
                continue;
            }
            computeAllmnemonics(unprocessed,processed+(char)(i+'a'));
        }
    }
}
