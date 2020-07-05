package com.deepika.problem.solving.TreesLecture;

public class BinarySearchTreeClient {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(6);
        tree.insert(2);
        tree.insert(4);
        tree.display();
        tree.inorder();
        System.out.println(tree.successor(3));
        tree.inrange(2,6);
    }

}
