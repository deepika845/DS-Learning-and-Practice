package com.deepika.problem.solving.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomSubset {
    public static void findRandom(List<Integer> list , int k){
        Random gen = new Random();
        for (int i=0;i<k;i++){
            Collections.swap(list,i,i+gen.nextInt(list.size()-i));
        }
    printArray(list,k);
}

    private static void printArray(List<Integer> list, int k) {
        for (int i=0;i<k;i++){
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> kk = new ArrayList<Integer>();
        kk.add(1);
        kk.add(2);
        kk.add(3);
        kk.add(4);
        kk.add(5);
        findRandom(kk,3);
    }
}