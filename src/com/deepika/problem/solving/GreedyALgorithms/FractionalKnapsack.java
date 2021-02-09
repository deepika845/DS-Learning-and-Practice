package com.deepika.problem.solving.GreedyALgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FractionalKnapsack {
    class Pair{
        int weight;
        int val;
        int ratio;
        Pair(int wt,int vl){
            this.weight=wt;
            this.val=vl;
            this.ratio=(vl/wt);
        }
    }
    class SortCompare implements Comparator<Pair>{

        @Override
        public int compare(Pair pair, Pair t1) {
           return t1.ratio-pair.ratio;
        }
    }
    public int findMaxValue(int[] weight,int[] value,int totalWt){
        List<Pair> allItem = new ArrayList<>();
        for (int i=0;i<weight.length;i++){
            allItem.add(new Pair(weight[i],value[i]));
        }
        int totalVal = 0;
        Collections.sort(allItem,new SortCompare());
        for (Pair curr: allItem){
            int s=curr.val;
            int st=curr.weight;
            if(totalWt>0 && totalWt>curr.weight){
                totalVal+=curr.val;
                totalWt=totalWt-curr.weight;
            }
            else if(totalWt>0){
                totalVal+=(curr.val/curr.weight)*totalWt;
                totalWt=0;
            }
            else{
                break;
            }
        }
        return totalVal;
    }
    public static void main(String[] args) {
        FractionalKnapsack fk = new FractionalKnapsack();
        System.out.println( fk.findMaxValue(new int[] {10,20},new int[]{60,100},50));



    }
}
