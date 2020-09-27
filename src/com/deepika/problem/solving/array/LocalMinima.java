package com.deepika.problem.solving.array;

public class LocalMinima {
    public static int findLocalMinima(int arr[]){
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid =(left+right)/2;
            if((mid==0||arr[mid]<arr[mid-1])&&(arr[mid]<arr[mid+1]||mid==arr.length-1)){
                return arr[mid];
            }
            if(mid>0 && arr[mid]>arr[mid-1]){
                right=mid-1;
                continue;
            }

                left =mid+1;

        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(findLocalMinima(new int[]{1,2,4,5,6,9,8}));

    }
}
