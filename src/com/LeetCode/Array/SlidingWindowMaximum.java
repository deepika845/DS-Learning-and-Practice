package com.LeetCode.Array;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq = new LinkedList<>();
        int s=0;
        int[] qp = new int[nums.length-k+1];
        for(int i=0;i<k-1 && i<nums.length;i++){
            if(dq.isEmpty()){
                dq.addFirst(nums[i]);
            }
            else{
                if(nums[i]>dq.peek()){
                    dq.addFirst(nums[i]);
                }
                else{
                    while(!dq.isEmpty() && nums[i]>dq.peekLast()){
                        dq.pop();
                    }
                    dq.add(nums[i]);
                }
            }
        }
      //  qp[s++]= dq.peek();
        for(int j=k-1; j<nums.length;j++){
            if(dq.isEmpty()){
                dq.addFirst(nums[j]);
            }
            else{
                if(nums[j]>dq.peek()){
                    dq.addFirst(nums[j]);
                }
                else{
                    while(!dq.isEmpty() && nums[j]>dq.peekLast()){
                        int ks=dq.peekLast();
                        dq.removeLast();
                    }
                    dq.add(nums[j]);
                }
            }
            qp[s++]=dq.peek();
            if(dq.peek()==nums[j-k+1]){
                dq.removeFirst();
            }

        }
        return qp;
    }

    public static void main(String[] args) {
        maxSlidingWindow(new int[]{9,10,9,-7,-4,-8,2,-6},5);
    }
}
