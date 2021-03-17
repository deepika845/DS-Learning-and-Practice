package com.deepika.problem.solving.array;

import com.deepika.problem.solving.SearchAndSort.FirstAndLastOccur;

public class FirstAndLastOccurence {
    public  int findFirstOccurence1(int[] arr, int item,int start,int end){
        if (start<=end){
            int mid=(start+end)/2;
            if ((mid==0 || arr[mid-1]<item) && arr[mid]==item){
                return mid;
            }
            else if (item>arr[mid]){
               return findFirstOccurence1(arr,item,mid+1,end);
            }
            else {
                return findFirstOccurence1(arr,item,start,mid-1);
            }
        }
        return -1;
    }
    public  int findLastOccurence(int[] arr, int item,int start,int end){
        if (start<=end){
            int mid=(start+end)/2;
            if ((mid==arr.length-1 || arr[mid+1]>item) && arr[mid]==item){
                return mid;
            }
            else if (item>arr[mid]){
                return findLastOccurence(arr,item,mid+1,end);
            }
            else {
               return findLastOccurence(arr,item,mid+1, end);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstAndLastOccurence fs = new FirstAndLastOccurence();
        fs.findFirstOccurence1(new int[]{1,2,3,4,5,5,5},5,0,6);
        fs.findLastOccurence(new int[]{1,2,3,4,5,5,5},5,0,6);

    }
}
