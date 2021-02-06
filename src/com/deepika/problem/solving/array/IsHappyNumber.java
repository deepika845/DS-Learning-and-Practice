package com.deepika.problem.solving.array;

import java.util.HashSet;
import java.util.Set;

class IsHappyNumber {
    public static boolean isHappy(int n) {
        Set<Integer> visited= new HashSet<Integer>();
        while(visited.add(n)){
            int sum=0;
            while(n>0){
                int rem=n%10;
                n=n/10;
                sum+=(rem*rem);
            }
            n=sum;
            if(n==1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}