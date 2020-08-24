package com.deepika.problem.solving.array;



public class KthElementInSpiral {
    public static int findNthSpiral(int arr[][],int i,int j,int m,int n,int k){
        if(m<1 || n<1){
            return -1;
        }
        if(k<=n){
            return arr[i][j+k-1];
        }
        if(k<=(n+m-1)){
            return arr[i+k-m][j+m-1];
        }
        if(k<(n+m-1+n-1)){
            return arr[i+m-1][j + n - 1 - (k - (m + n - 1))];
        }
        if (k <= (n + m - 1 + n - 1 + m - 2))
        return arr[i + m - 1 - (k - (n + m - 1 + n - 1))][j + 0];
       return findNthSpiral(arr,i+1,j+1,m-2,n-2,k - (2 * n + 2 * m - 4));
    }

    public static void main(String[] args) {
        System.out.println(findNthSpiral(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}},0,0,3,4,11));
    }

    
}
