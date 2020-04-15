package com.deepika.problem.solving.recursion.String;

public class HiHitPlay {
    public static void sortHiHit(String processed,String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        char ch=unprocessed.charAt(0);
        if(unprocessed.length()>=3 && "hi".equals(unprocessed.substring(0,2)) && "hit".equals(unprocessed.substring(0,3))){
            sortHiHit(processed+ch,unprocessed.substring(1));
        }
        else if(unprocessed.length()>=2 && "hi".equals(unprocessed.substring(0,2)))
        {
            sortHiHit(processed,unprocessed.substring(2));
        }
        else{
            sortHiHit(processed+ch,unprocessed.substring(1));
        }
    }

    public static void main(String[] args) {
        sortHiHit("","hihitjithidhithi");

    }
}
