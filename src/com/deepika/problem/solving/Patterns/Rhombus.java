package com.deepika.problem.solving.Patterns;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Rhombus {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        int s=n%2!=0?n/2+1:n/2;
        int t=n%2!=0?2*s-1:2*s;
        n=s;

        for(int i=1;i<=t;i++){
            int cc=1;
            for(int j=1;j<=2*t-1;j++){
                if(cc<=i){
                    System.out.print(cc+"\t");
                }
                else {
                    System.out.print("\t");
                }
                if(j<t){
                    cc++;
                }
                else{
                    cc--;
                }
            }
            System.out.println();
        }


    }
}
