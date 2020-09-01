package com.deepika.problem.solving.Strings;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public  class ValidIpAddress{
    public static List<String> findAllValid(String ip){
        List<String> result =new ArrayList<String>();
        for (int i=1;i<4 && i<ip.length();i++){
            final String first = ip.substring(0,i);
            if(isValid(first)){
                for (int j=1;i+j<ip.length() && j<4 ;j++){
                    final String second = ip.substring(i,i+j);
                    if (isValid(second)){
                        for (int k=1;i+j+k<ip.length() && k<4 ; k++){
                            final String third = ip.substring(i+j,i+j+k);
                            final String fourth = ip.substring(i+j+k);
                            if (isValid(third)&&isValid(fourth)){
                                result.add(first+" . "+second+" . "+third+" . "+fourth);
                            }
                        }
                    }
                }
            }
        }
        return result;

    }

    private static boolean isValid(String first) {
        if(first.length()>3)
            return false;
        else if(first.startsWith("0") && first.length()>1){
            return false;
        }
        else {
            int k = Integer.parseInt(first);
            if(k>=0 && k <=255){
                return true;
            }
            else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findAllValid("19221232201"));

    }
}