package com.LeetCode;

import java.util.Arrays;

class SClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int minDiff=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int temp=nums[i];
            int low=i+1;
            int high=nums.length-1;
            while(low<high){
                if(minDiff>Math.abs(temp+nums[low]+nums[high]-target)){
                    minDiff = temp+nums[low]+nums[high];
                    high--;
                }
                if(minDiff<Math.abs(temp+nums[low]+nums[high]-target)){
                    minDiff = temp+nums[low]+nums[high];
                    low++;
                }



            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        threeSumClosest(new int[]{-1,2,1,-4},1);

    }
}