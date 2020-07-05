package com.deepika.GenricsInterface;

import java.util.Comparator;

public class Demo {
    public static <T> void display(T[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }
        System.out.println();
    }
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator){
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-i-1;j++){
                if (comparator.compare(arr[j],arr[j+1])>0){
                    T temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Car[] cararr = new Car[5];
        cararr[0] = new Car(1000,400,"Red");
        cararr[1] = new Car(2000,200,"Yellow");
        cararr[2] = new Car(500,900,"Black");
        cararr[3] = new Car(300,30,"Grey");
        cararr[4] = new Car(700,60,"White");

        bubbleSort(cararr,new CarSpeedComparator());
        display(cararr);
    }
}
