package com.deepika.problem.solving.Interviewquestions;
public class BooleanParenthesizationProblem {
    public static int findNumTrue( String s,int i,int j,boolean isTrue){
        if (i>j){
            return 0;
        }
        if (i== j ){
            if(isTrue){
                if(s.charAt(i)=='T'){
                    return 1;
                }
                else {
                    return 0;
                }
            }
            else{
                if(s.charAt(i)=='F'){
                    return 1;
                }
                else {
                    return 0;
                }
            }}
            int ans=0;
            for (int k=i+1;k<=j-1;k=k+2){
                int leftTrue = findNumTrue(s,i,k-1,true);
                int leftFalse = findNumTrue(s,i,k-1,false);
                int rightFalse = findNumTrue(s,k+1,j,false);
                int rightTrue = findNumTrue(s,k+1,j,true);
                if(s.charAt(k)== '|'){
                    if(isTrue){
                    ans += (leftFalse *rightTrue)+(leftTrue*rightFalse) + (leftTrue * rightTrue);
                    }
                    else {
                        ans += (leftFalse * rightFalse);
                    }
                }
                if(s.charAt(k)== '&'){
                    if(isTrue){
                        ans +=  (leftTrue * rightTrue);
                    }
                    else {
                        ans += (leftFalse * rightFalse)+(leftFalse *rightTrue)+(leftTrue*rightFalse) ;
                    }
                }
                if(s.charAt(k)== '^'){
                    if(isTrue){
                        ans += (leftFalse *rightTrue)+(leftTrue*rightFalse) ;
                    }
                    else {
                        ans += (leftFalse * rightFalse)+ (leftTrue * rightTrue);
                    }
                }
            }
            return ans;

        }

    public static void main(String[] args) {
        String ss = "T|F&T";
      findNumTrue(ss,0,ss.length()-1,true);
    }
    }

