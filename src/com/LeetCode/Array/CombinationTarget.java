package com.LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

public class CombinationTarget {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<List<Integer>>();
        List<Integer> curr= new ArrayList<Integer>();
        combinationSum(candidates,target,ans,curr,0);
        return ans;
    }
    public static void combinationSum(int[] candidates,int target,List<List<Integer>> allCombination,List<Integer> curr,int start){
        if(start==candidates.length){
            return;
        }
        if(target<0){
            return;
        }
        if(target==0){
            allCombination.add(curr);
            return;
        }
        for(int i=start;i<candidates.length;i++)
        {
            curr.add(candidates[i]);
            combinationSum(candidates, target-candidates[i],allCombination,curr,i+1);
            curr.remove(curr.size()-1);
            combinationSum(candidates,target,allCombination,curr,i+1);

        }
    }

    public static void main(String[] args) {
       combinationSum(new int[]{2,3,6,7},7);
    }
}
