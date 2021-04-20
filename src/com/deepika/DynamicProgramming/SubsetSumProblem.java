package com.deepika.DynamicProgramming;

public class SubsetSumProblem {
    public boolean ifSubsetExists(int[] arr,int subSum){
        boolean rs=false;
        boolean[][] dpMaintanined= new boolean[arr.length+1][subSum+1];
        dpMaintanined[0][0]=true;
        for (int i=1;i<dpMaintanined.length;i++){
            for (int j=0;j<dpMaintanined[i].length;j++){
                if (j==0){
                    dpMaintanined[i][j]=true;
                }
                else if ( dpMaintanined[i-1][j]){
                    dpMaintanined[i][j]=true;
                }
                else if ( j<arr[i-1]){
                    dpMaintanined[i][j]=dpMaintanined[i-1][j];
                }
                else {
                    dpMaintanined[i][j]=dpMaintanined[i-1][j-arr[i-1]];
                     rs= dpMaintanined[i][j];
                }
            }
        }
        return dpMaintanined[dpMaintanined.length-1][subSum];
    }
    public static void main(String[] args) {
        SubsetSumProblem ssm = new SubsetSumProblem();
        System.out.println(ssm.ifSubsetExists(new int[]{1,5,11,5},10));

    }
}
