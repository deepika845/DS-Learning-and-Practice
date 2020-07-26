package com.deepika.problem.solving.Interviewquestions;

public class EditDistance {
    public static int findMinPath(String start,String dest){
        if(start.length()==0){
            return dest.length();
        }
        if(dest.length()==0){
            return start.length();
        }
        int dparr[][] =new int[start.length()+1][dest.length()+1];
        for (int i =0 ;i<dparr.length;i++){
            for (int j=0;j<dparr[0].length;j++){
                if(i==0){
                    dparr[i][j] = j;
                }
               else if(j==0){
                    dparr[i][j]=i;
                }
                else if(start.charAt(i-1)==dest.charAt(j-1)){
                    dparr[i][j]=dparr[i-1][j-1];
                }
                else {
                    dparr[i][j]=Math.min(Math.min(dparr[i-1][j],dparr[i][j-1]),dparr[i-1][j-1]) +1;
                }
            }
        }
        return dparr[dparr.length-1][dparr[0].length-1];
    }
    public static void main(String[] args) {
        String start = "Saturday";
        String end = "Sunday";
        System.out.println(findMinPath(start,end));

    }
}
