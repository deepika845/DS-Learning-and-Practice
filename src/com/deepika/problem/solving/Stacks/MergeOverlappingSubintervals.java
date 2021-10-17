package com.deepika.problem.solving.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class MergeOverlappingSubintervals {

    public static void  mergingOverlappingIntervals(Interval[] allIntervals){
        Arrays.sort(allIntervals);
        Stack<Interval> stackMaintained= new Stack<>();
        stackMaintained.push(allIntervals[0]);
        for (int i=1;i<allIntervals.length;i++){
            Interval pop=stackMaintained.peek();
            if (pop.end<allIntervals[i].end){
                stackMaintained.push(allIntervals[i]);
            }
            else{
                if (pop.end<allIntervals[i].end){
                    pop.end=allIntervals[i].end;
                }
            }
        }
        while (!stackMaintained.isEmpty()){
            Interval pop= stackMaintained.pop();
            System.out.println(pop.start+" => "+pop.end);
        }
    }
    public static void main(String[] args){
        Interval []arr = new Interval[4];
        arr[0] = new Interval(6, 8);
        arr[1] = new Interval(1, 9);
        arr[2] = new Interval(2, 4);
        arr[3] = new Interval(4, 7);
        mergingOverlappingIntervals(arr);



    }
   static class Interval implements  Comparable<Interval>{
        int start;
        int end;
        Interval(int start,int end){
            this.start=start;
            this.end=end;
        }

        @Override
        public int compareTo(Interval o) {
            return this.start-o.start;
        }
    }
}
