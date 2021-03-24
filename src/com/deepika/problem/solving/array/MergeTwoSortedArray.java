package com.deepika.problem.solving.array;

public class MergeTwoSortedArray {
    public static void sortedArray(int[] arr1,int arr2[]){
        int m=arr1.length;
        int n = arr2.length;
        for (int i=n-1;i>=0;i--){
            int j,last=arr1[m-1];
            for (j=m-2;j>=0 && arr1[j]>arr2[i];j--){
                arr1[j+1]=arr1[j];
            }
            if (j!=m-2 || last>arr2[i]){
                arr1[j+1]=arr2[i];
                arr2[i]=last;
            }
        }
        for (int i=0;i<m;i++){
            System.out.print(arr1[i]+" , ");
        }
        for (int i=0;i<n;i++){
            System.out.print(arr2[i]+" , ");
        }
    }

    public static void main(String[] args) {
        sortedArray(new int[]{1,2,3,5,8,9},new int[]{10,13,15,20});
    }
}
