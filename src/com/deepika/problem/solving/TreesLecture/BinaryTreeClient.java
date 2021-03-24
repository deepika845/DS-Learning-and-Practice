package com.deepika.problem.solving.TreesLecture;

//import com.sun.source.tree.BinaryTree;

import java.util.List;
import java.util.Scanner;

public class BinaryTreeClient {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BinaryTrees tree=new BinaryTrees();
        tree.insert(s);
        tree.insert(s);
        tree.insert(s);
        tree.insert(s);
        tree.insert(s);
        tree.insert(s);
        tree.insert(s);
        tree.insert(s);
        tree.insert(s);
        tree.insert(s);
        //tree.display();
        //tree.findLCa(6,3);
        //tree.inorderWithoutRecursion();
      List<List<Integer>> allPath= tree.pathSum(22);
      for (List<Integer> cur : allPath){
          System.out.println(cur);
      }

    }
}
/*
5
left
4
right
8
left
left
11
left
left
left
7
left
left
right
2
right
left
13
right
right
4
right
right
left
5
right
right
right
1

 */