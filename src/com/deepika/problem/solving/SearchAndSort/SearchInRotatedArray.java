package com.deepika.problem.solving.SearchAndSort;

public class SearchInRotatedArray {
    public int findItem(int[] arr,int item,int start,int end){
       while (start<=end){
            int mid=(start+end)/2;
            if(arr[mid]==item){
                return mid;
            }
            if(arr[start]<arr[mid]){
               if(item>=arr[start] && item<=arr[mid]){
                   end=mid-1;
               }
               else {
                   start=mid+1;
               }
            }
            else{
                if(item>=arr[mid] && item<=arr[end]){
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
        SearchInRotatedArray sin = new SearchInRotatedArray();
        System.out.println( sin.findItem(new int[]{1,3},3,0,1));
    }
}
