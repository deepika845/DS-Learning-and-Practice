package com.LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length<3){
            return res;
        }
        for(int i=0;i<nums.length;i++){
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
                if(nums[l]+nums[r]+nums[i]==0){
                    List<Integer> currAns= new ArrayList<Integer>();
                    currAns.add(nums[i]);
                    currAns.add(nums[l]);
                    currAns.add(nums[r]);
                    res.add(currAns);
                    l++;
                    r--;
                }
                else if(nums[l]+nums[r]+nums[i]>0){
                    r--;

                }
                else if(nums[l]+nums[r]+nums[i]<0){
                    l++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}
