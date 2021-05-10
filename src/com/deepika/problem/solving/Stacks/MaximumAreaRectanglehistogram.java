package com.deepika.problem.solving.Stacks;

import java.util.Stack;

public class MaximumAreaRectanglehistogram {
    public static int maxArea(int[] arr){
        Stack<Integer> stkMaintained= new Stack<>();
        int i=0;
        int maxArea=0;
        int area=0;
        for (i=0;i<arr.length;){
            if (stkMaintained.isEmpty()||arr[stkMaintained.peek()]<arr[i]){
                stkMaintained.push(i++);
            }
            else {
                int pop=stkMaintained.pop();
                if (stkMaintained.isEmpty()){
                    area=arr[pop]*(i);
                }
                else {
                    area=arr[pop]*(i-stkMaintained.peek()-1);
                }
                maxArea=Math.max(maxArea,area);
            }
        }
        while (!stkMaintained.isEmpty()){
            int pop=stkMaintained.pop();
            if (stkMaintained.isEmpty()){
                maxArea=Math.max(maxArea,arr[pop]*i);
            }
            else {
                maxArea=Math.max(maxArea,arr[pop]*(i-stkMaintained.peek()-1));
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{6,2,5,4,5,1,6}));
    }
}
