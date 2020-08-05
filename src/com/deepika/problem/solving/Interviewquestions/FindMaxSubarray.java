package com.deepika.problem.solving.Interviewquestions;

import java.util.*;

public class FindMaxSubarray {
    public static int[] maxSumSubarray(int[] arr,int k){
        Deque<Integer> dekk= new LinkedList<Integer>();
        int i;
        for (i = 0; i < k; ++i) {
            // For every element, the previous smaller elements are useless so
            // remove them from Qi
            while (!dekk.isEmpty() && arr[i] >= arr[dekk.peekLast()])
                dekk.removeLast(); // Remove from rear

            // Add new element at rear of queue
            dekk.addLast(i);
        }
        int arrmax[] = new int[arr.length-k+1];
        int f=0;
        for (int j =i ;j<arr.length ;j++){
            arrmax[f++] = arr[dekk.peekFirst()];
            while (!dekk.isEmpty() && dekk.peek()<=j-k){
                dekk.removeFirst();
            }
            while (!dekk.isEmpty() && arr[dekk.peekLast()]<arr[j]){
                dekk.removeLast();
            }
            dekk.addLast(j);
        }
        arrmax[f] =arr[dekk.peekFirst()];
        return arrmax;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSumSubarray(new int[]{12, 1, 78, 90, 57, 89, 56},3)));
    }
}
