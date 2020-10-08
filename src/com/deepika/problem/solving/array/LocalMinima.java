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
    public static int findElementEqualToIndex(int arr[]){
        int left =0;
        int right =arr.length-1;
        while (left<right){
            int mid =(left+right)/2;
            int diffr=(arr[mid]-mid);
            if(diffr==0){
                return diffr;
            }
            if(diffr>0){
                right=mid-1;
            }
            if (diffr<0){
                left=mid+1;
            }
        }
        return -1;
    }

       public static int findSmallest(int[] arr){
        int left=0;
        int right=arr.length-1;
        while (left<right){
            int mid=(left+right)/2;
            if(arr[mid]>arr[mid+1]){
                left=mid+1;
            }
            else {
                right=mid;
            }
        }
        return left;
     }
    public static void main(String[] args) {
//        System.out.println(findLocalMinima(new int[]{1,2,4,5,6,9,8}));
//        System.out.println(findElementEqualToIndex(new int[]{0,1,2,3}));rens
//        findSmallest(new int[]{7,8,9,10,1});

    }
}
