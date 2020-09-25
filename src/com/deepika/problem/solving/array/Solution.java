package com.deepika.problem.solving.array;

import java.util.*;




class Result {

    /*
     * Complete the 'taskOfPairing' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER_ARRAY freq as parameter.
     */

    public static int taskOfPairing(List<Integer> freq) {
        Collections.sort(freq);
        int count =0;
        int i=0;
        int j=1;
        while(i<freq.size() && j<freq.size()){
            if(i!=j && Math.abs(freq.get(i)-freq.get(j))<=1){
                count+=1;
                i++;
                j++;
            }
            if(j<freq.size() && (freq.get(j)-freq.get(i)>1)){
                i++;
            }
            if(j<freq.size() &&(freq.get(j)-freq.get(i))<=0){
                j++;
            }
        }

        return count;
    }

}

public class Solution {
    public static void main(String[] args) {
        List<Integer> freq = new ArrayList<Integer>();
      Scanner s = new Scanner(System.in);
      int x = s.nextInt();
      for (int i=0;i<x;i++){
          int ele=s.nextInt();
          freq.add(ele);
      }
        int result = Result.taskOfPairing(freq);
        System.out.println(result);

    }
}
