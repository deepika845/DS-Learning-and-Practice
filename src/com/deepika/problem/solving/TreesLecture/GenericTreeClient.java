package com.deepika.problem.solving.TreesLecture;

import java.util.Scanner;

public class GenericTreeClient {

    public static void main(String[] args) {

        Scanner s= new Scanner(System.in);
        GenericTree trees =new GenericTree();

        trees.insert(s);
//        trees.display();
//        System.out.println(trees.count());
//        System.out.println(trees.max());
        trees.atlevel(1);
        trees.levelorder();


    }
}
