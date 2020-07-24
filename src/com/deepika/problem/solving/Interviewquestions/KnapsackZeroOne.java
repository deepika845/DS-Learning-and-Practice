package com.deepika.problem.solving.Interviewquestions;

public class KnapsackZeroOne {
    public static int returnMaxProfit(int wt[] , int profit[],int maxWeight){
        int[][] dpArray = new int[wt.length + 1][maxWeight + 1];
        for (int row = 0;row < dpArray.length ;row++){
            for (int col = 0 ;col<dpArray[row].length;col++){
                if(row==0 || col == 0){
                    dpArray[row][col]=0;
                    continue;
                }
                if(wt[row-1] > col){
                    dpArray[row][col]=dpArray[row-1][col];
                }
                else {
                    dpArray[row][col]=Math.max(dpArray[row - 1][col],profit[row-1]+dpArray[row-1][col-wt[row-1]]);
                }
            }
        }
        return dpArray[dpArray.length-1][dpArray[dpArray.length-1].length-1];
    }
    public static void main(String[] args) {
        System.out.println(returnMaxProfit(new int[]{3,4,5,6},new int[]{2,3,4,1},8));

    }
}
