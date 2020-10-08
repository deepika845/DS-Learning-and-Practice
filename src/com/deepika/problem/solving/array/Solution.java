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
static class Bully implements Comparator<Integer>{

    @Override
    public int compare(Integer integer, Integer t1) {
       return t1-integer;
    }
}
public static void printRuntimeMedian(List<Integer> freq){
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Bully());
    Iterator<Integer> itd = freq.iterator();
    while(itd.hasNext()){
        int x = itd.next();
        if(minHeap.isEmpty()){
            minHeap.add(x);
        }
        else if(minHeap.peek()<x){
            minHeap.add(x);
        }
        else{
            maxHeap.add(x);
        }
        if(minHeap.size()>maxHeap.size()+1){
            maxHeap.add(minHeap.remove());
        }
        if(maxHeap.size()>minHeap.size()+1){
            minHeap.add(maxHeap.remove());
        }
        System.out.println((minHeap.size()==maxHeap.size())?0.5*(minHeap.remove()+maxHeap.remove()):minHeap.remove());
    }
}
}

public class Solution {
    public static void main(String[] args) {
        List<Integer> freq = new ArrayList<Integer>();
      Scanner s = new Scanner(System.in);
      int x = s.nextInt();
      s.next();
      for (int i=0;i<x;i++){
          int ele=s.nextInt();
          freq.add(ele);
          s.nextInt();
      }
 Result.printRuntimeMedian(freq);
//        System.out.println(result);


    }
}
