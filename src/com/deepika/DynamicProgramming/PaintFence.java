package com.deepika.DynamicProgramming;
import java.io.*;
import java.util.*;

public class PaintFence {

        public static void main(String[] args) throws Exception {
            Scanner s = new Scanner(System.in);
            int n  = Integer.parseInt(s.nextLine());
            int[][] matrix = new int[3][n];
            for(int i = 0;i<n;i++){
                String[] str = s.nextLine().split(" ");
                for(int j=0;j<3;j++){
                    matrix[j][i] = Integer.parseInt(str[j]);
                }
            }

            int nred = 0;
            int nblue = 0;
            int ngreen = 0;
            for(int i = 0;i<n;i++){

                nred = Math.min(nblue,ngreen) + matrix[0][i];
                nblue = Math.min(nred,ngreen) + matrix[1][i];
                ngreen = Math.min(nred,nblue) + matrix[2][i];

            }
            System.out.println(Math.min(Math.min(nred,nblue),ngreen));


        }
}
