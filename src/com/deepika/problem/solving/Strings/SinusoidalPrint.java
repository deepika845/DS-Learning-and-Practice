package com.deepika.problem.solving.Strings;

import java.util.Arrays;

public class SinusoidalPrint {
    public static char[][] findSinuSoidalPattern(String s,int k){
        boolean down = true;
        int col =0;
        char[][] pattern = new char[k][s.length()];
        int row=0;
        for (int i=0;i<s.length();i++){
            char ff = s.charAt(i);
            pattern[row][i]=ff;
            if(row==k-1){
                down=false;
            }
            if (row==0){
                down=true;
            }
            if (down) {
                row++;
            } else {
                row--;
            }
        }
        return pattern;
    }

    public static void main(String[] args) {
      char[][] pp=  findSinuSoidalPattern("abcdef",3);
        for (int i=0;i<pp.length;i++){
            System.out.println(Arrays.toString(pp[i]));
        }
    }
}
