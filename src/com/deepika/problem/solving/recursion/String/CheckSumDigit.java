package com.deepika.problem.solving.recursion.String;

public class CheckSumDigit {
    public static int recursiveSum(String unprocessed,int sum){
        if(unprocessed.length()==0){
            sum=0;
            return sum;
        }
        int digit=unprocessed.charAt(0)-'0';
        unprocessed=unprocessed.substring(1);
        sum=recursiveSum(unprocessed,sum);
        int rr=sum+digit;
        return rr;
    }
    public static void main(String[] args){
        System.out.println(recursiveSum("990",0));

    }
}
