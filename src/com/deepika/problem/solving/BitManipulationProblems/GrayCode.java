package com.deepika.problem.solving.BitManipulationProblems;

public class GrayCode {
    public static boolean differInOneBit(int start,int second){
        int diffr = start ^ second;
        return (diffr != 0) && ((diffr & (diffr-1))==0) ;
    }
    public static void main(String[] args) {
        System.out.println(differInOneBit(1,3));

    }
}
