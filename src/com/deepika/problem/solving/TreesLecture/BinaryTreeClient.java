package com.deepika.problem.solving.TreesLecture;

//import com.sun.source.tree.BinaryTree;

import java.util.Scanner;

public class BinaryTreeClient {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BinaryTrees tree=new BinaryTrees();
        tree.insert(s);
        tree.insert(s);
        tree.insert(s);
        tree.display();
        System.out.println(tree.find(3));

    }
}
