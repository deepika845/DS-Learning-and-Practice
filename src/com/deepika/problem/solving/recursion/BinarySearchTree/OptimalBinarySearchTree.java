package com.deepika.problem.solving.recursion.BinarySearchTree;

public class OptimalBinarySearchTree {
    public static int optimalSearchTree(int[] freq,int i, int j){
        if(i>j){
            return  0;
        }
        if(i==j){
        return freq[i];
        }
        int currCost=sum(freq,i,j);
        int cost=Integer.MAX_VALUE;
        for(int r=i;r<=j;r++){
            int currMin=optimalSearchTree(freq,i,r-1)+optimalSearchTree(freq,r+1,j);
            if(currMin<cost){
                cost=Math.min(cost,currMin);
            }
        }
        return currCost+cost;
    }

    private static int sum(int[] freq, int i, int j) {
        int sum=0;
        for(int k=i;k<=j;k++){
            sum+=freq[k];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(optimalSearchTree(new int[]{34,8,50},0,2));
    }
}
