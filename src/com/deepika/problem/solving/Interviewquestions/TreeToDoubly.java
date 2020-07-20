package com.deepika.problem.solving.Interviewquestions;

import com.deepika.problem.solving.TreesLecture.BinaryTrees;

import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class TreeToDoubly {
    Node root;
    Node head;
    static Node prev;
    class Node {
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data =data;
        }
    }
    public void insert(Scanner s){
        this.root=insert(root,s);
    }
    private Node insert(Node node, Scanner s){
        if(node==null){
            int val=s.nextInt();
            return new Node(val);
        }
        System.out.println("Enter the direction"+node.data);
        String dir=s.next();
        if(dir.equals("left")){
            node.left=insert(node.left,s);
        }
        else{
            node.right=insert(node.right,s);
        }
        return node;
    }
    public void returnDoublyLinkedList(Node node){
        if(node == null){
            return;
        }
        returnDoublyLinkedList(node.left);
        if(prev == null){
            node.left = prev;
            head = node;
        }
        node.left= prev;
        prev.right = node;
        prev = node;
        returnDoublyLinkedList(node.right);
    }
    public int findLongestSequence(){
        if(root == null){
            return 0;
        }
        Result res = new Result();
        findLongestSequence(root,0,root.data,res);
        return res.rk;

    }

    private void findLongestSequence(Node root, int currLength, int data, Result res) {
        if(root == null){
            return;
        }
        if(root.data == data){
            currLength ++;
        }
        else{
            currLength=1;
        }
        res.rk = Math.max(res.rk,currLength);
        findLongestSequence(root.left,currLength,root.data+1,res);
        findLongestSequence(root.right,currLength,root.data+1,res);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        
    }
    class Result{
        int rk = 0;
    }
}
