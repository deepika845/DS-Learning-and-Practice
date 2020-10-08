
package com.LeetCode;

class ReverseNum {
    public static int reverse(int x) {
        boolean negative = false;
        if(x<0){
            negative =true;
            x=-x;
        }
        long sum=0;
        while(x>0){
            sum=sum*10+(x%10);
            x=x/10;
        }
        if(sum > 2147483647 || sum < -2147483648){
            sum=0;
        }
        if(negative){
            sum=-sum;
        }
       int k =(int)sum;
        return k;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
