package com.deepika.problem.solving.array;

public class SearchSortedRotated {
    public static int findPosition(int[] arr,int item,int start,int end){
        while (start<=end){
            int mid=(start+end)/2;
            if (arr[mid]==item){
                return mid;
            }
            if (arr[mid]>=arr[start]){
                if (item>=arr[start] && item<arr[mid] ){
                    end=mid-1;
                }
                else {
                    start=mid+1;
                }
            }
            else {
                if (item<=arr[end] && item>arr[mid] ){
                    start=mid+1;
                }
                else {
                    end=mid-1;
                }

            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(findPosition(new int[]{5,6,7,0,1,2,3,4},0,0,7));

    }
}
