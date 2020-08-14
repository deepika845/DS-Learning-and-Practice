package com.deepika.problem.solving.Interviewquestions;

public class SwapNumber {
    public static void swapNumber(int x,int y){
        x = x^y;
        y=x^y;
        x=x^y;
        System.out.println(x);
        System.out.println(y);

    }
    public static void main(String[] args) {
        swapNumber(3,4);

    }
}
