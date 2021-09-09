package com.LeetCode.Array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Sort3Colors {
    public static void sortColors(int[] nums) {
        int mid=0;
        int high=nums.length-1;
        int low=0;
        while(mid<=high){
            int ch=nums[mid];
            switch(ch){
                case 0:int temp=nums[low];
                    nums[low]=nums[mid];
                    nums[mid]=temp;
                    low++;
                    mid++;
                    break;
                case 1: mid++;
                    break;
                case 2: int temp1=nums[high];
                    nums[high]=nums[mid];
                    nums[mid]=temp1;
                    high--;
                    mid++;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        sortColors(new int[]{1,2,0});

    }
}
