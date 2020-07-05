package com.deepika.problem.solving.HashMap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class OrderStatistics  {
    static class Order implements Comparator<Map.Entry<Integer,Integer>> {
        @Override
        public int compare(Map.Entry<Integer,Integer> ff,Map.Entry<Integer,Integer> ff1) {
            return ff1.getValue() - ff.getValue();
        }
    }
    public static void findKThLargest(int arr[]){
        HashMap<Integer,Integer> hll =new HashMap<Integer, Integer>();
        for (int i=0;i<arr.length;i++){
            if (!hll.containsKey(arr[i])){
                hll.put(arr[i],1);
            }
            else {
                hll.put(arr[i],hll.get(arr[i])+1);
            }
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pp = new PriorityQueue<Map.Entry<Integer, Integer>>(hll.size(),new Order());
        for (Map.Entry<Integer,Integer> mp : hll.entrySet()){
            pp.add(mp);
        }
        System.out.println(pp.poll());
        System.out.println(pp.poll());
        System.out.println(pp.poll());

    }
    public static void main(String[] args) {
        int aee[] = {1,2,3,1,1,4,5,3,2};
        findKThLargest(aee);

    }
}
