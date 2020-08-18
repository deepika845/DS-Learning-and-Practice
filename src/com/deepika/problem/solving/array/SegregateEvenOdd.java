package com.deepika.problem.solving.array;

import java.util.Arrays;

public class SegregateEvenOdd {
    public static void segregate(int arr[]){
        int even = 0;
        int odd = arr.length-1;
        while (even<odd){
            if(arr[even]%2 == 0){
                even++;
            }
            else {
                int temp = arr[even];
                arr[even] = arr[odd];
                arr[odd--]=temp;
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        segregate(arr);
        System.out.println(Arrays.toString(arr));
    }
}
