package com.deepika.problem.solving.Stacks;

import java.util.Stack;

class MaxAreaRectangle {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<Integer>();
        int i=0;
        int maxArea=Integer.MIN_VALUE;
        while(i<heights.length){
            if(stk.isEmpty()){
                stk.push(i);
            }
            else if(heights[stk.peek()]<=heights[i]){
                stk.push(i);
            }
            else if(heights[stk.peek()]>heights[i]){
                int ind= stk.pop();
                if(stk.isEmpty()){

                    maxArea=Math.max(maxArea,heights[ind]*i);
                }
                else{
                    while(!stk.isEmpty()){
                        if(heights[ind]>heights[i]){

                        maxArea=Math.max(maxArea,heights[ind]*(i-stk.peek()-1));
                        ind=stk.pop();
                    }
                        else {
                            break;
                        }
                    }
                    if(heights[ind]<=heights[i]){
                        stk.push(ind);
                    }

            }
                stk.push(i);}
            i++;
        }
        while (!stk.isEmpty()){
            int ind1 = stk.pop();
            if(stk.isEmpty()){
                maxArea=Math.max(maxArea,heights[ind1]*i);
            }
            else {
                maxArea=Math.max(maxArea,heights[ind1]*(i-stk.peek()-1));
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
       largestRectangleArea(new int[]{5,4,4,6,3,2,9,5,4,8,1,0,0,4,7,2});
    }
}
