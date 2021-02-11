package com.deepika.problem.solving.SearchAndSort;

public class FirstAndLastOccur {
    public int[] findFirstAndLastOccur(int arr[],int item){
        int firstOccur=findFirstInd(arr,item,0,arr.length-1);
        int lastOccur= findLastInd(arr,item,0,arr.length-1);
        int[] result = new int[2];
        result[0]=firstOccur;
        result[1]=lastOccur;
        return  result;
    }

    private int findFirstInd(int[] arr, int item, int start, int end) {
        if(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]==item && arr[mid-1]<item){
                return mid;
            }
            else if(arr[mid]<item){
                return findFirstInd(arr,item,mid+1,end);
            }
            else{
                return findFirstInd(arr,item,start,mid-1);
            }
        }
        return -1;
    }

    private int findLastInd(int[] arr, int item,int start,int end) {
        if(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]==item && arr[mid+1]>item){
                return mid;
            }
            else if(arr[mid]>item){
                return findLastInd(arr,item,start,mid-1);
            }
            else{
                return findLastInd(arr,item,mid+1,end);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstAndLastOccur ft = new FirstAndLastOccur();
        int res[]=ft.findFirstAndLastOccur(new int[]{1,2,2,3,4,5},4);
        System.out.println(res[0]+" , "+res[1]);
    }
}
