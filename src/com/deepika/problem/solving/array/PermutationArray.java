package com.deepika.problem.solving.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationArray {
    public static List<int[]> findAllPermute(int arr[]){
        List<int[]> lss = new ArrayList<int[]>();
        findAllPermute(arr,0,lss);
        return lss;
    }
    public static void findAllPermute(int arr[],int start,List<int[]> lss){
        if(start>=arr.length){
            lss.add(arr.clone());
        }
        else {
            for(int i=start;i<arr.length;i++){
                swap(arr,start,i);
                findAllPermute(arr,start+1,lss);
                swap(arr,start,i);
            }
        }
        return ;
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void printList(List<int[]> lss){
        for (int i=0;i<lss.size();i++){
            System.out.println(Arrays.toString( lss.get(i))); }
    }

    public static void main(String[] args) {
      findAllPermute(new int[]{1,2,3});
      // printList(ll);
    }
}
