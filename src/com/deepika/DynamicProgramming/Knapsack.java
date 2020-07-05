package com.deepika.DynamicProgramming;

/* A Naive recursive implementation
of 0-1 Knapsack problem */
class Knapsack {
    public static int findMaxValue(int weight, int wt[] ,int val[], int n ){
        if(n==0 || weight ==0){
            return 0;
        }
        if(wt[n-1] > weight){
            return  findMaxValue(weight,wt,val,n-1);
        }
        return Math.max(val[n-1]+findMaxValue(weight-wt[n-1],wt,val,n-1),findMaxValue(weight,wt,val,n-1));
    }
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        return K[n][W];
    }
    public static void main(String[] args) {
        int arr[] = {1,3,5,7,9};
        int arr1[] = {10,20,80,40,50};
       knapSack(12,arr,arr1,arr.length);

    }
}

