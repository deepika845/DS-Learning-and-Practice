package com.deepika.problem.solving.Interviewquestions;


class MatrixChainMultiplication
{
    public static int findMatrixChainMultiplication(int arr[] , int i , int j){
        if(i>=j){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i ; k <j ; k++) {
            int minval = findMatrixChainMultiplication(arr, i, k) + findMatrixChainMultiplication(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);
            if (minval<min){
                min = minval;
            }
        }
        return min;
    }

    public static void main(String args[])
    {
    findMatrixChainMultiplication(new int[]{1,2,3,4,3},1,4);

    }
}
/* This code is contributed by Rajat Mishra*/
