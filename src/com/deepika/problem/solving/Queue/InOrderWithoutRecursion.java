package com.deepika.problem.solving.Queue;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class InOrderWithoutRecursion {
    Node root ;
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    public ArrayList<Integer> findInOrder(){
       Deque<Node> deque= new LinkedList<Node>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Node curr =root;
        while (curr!=null || !deque.isEmpty()){
            if(curr!=null){
                int x = curr.data;
                deque.addFirst(curr);
                curr=curr.left;
            }
            else{
                Node jj=deque.removeFirst();
                int n =jj.data;
                arr.add(jj.data);
                curr=jj.right;
            }
        }
        return arr;
    }
    public ArrayList<Integer> findPreOrder(){
        Deque<Node> deque = new LinkedList<Node>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Node curr = root;
        while (curr!=null || !deque.isEmpty()){
            if(curr!=null){
                int x = curr.data;
                deque.addLast(curr);
                curr=curr.left;
            }
            else{
                Node jj=deque.removeFirst();
                int n =jj.data;
                arr.add(jj.data);
                curr=jj.right;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
       InOrderWithoutRecursion ink = new InOrderWithoutRecursion();
       ink.root=ink.new Node(3);
        ink.root.left=ink.new Node(2);
        ink.root.left.left=ink.new Node(1);
        ink.root.right=ink.new Node(5);
        ink.root.right.left=ink.new Node(4);
        ink.root.right.right=ink.new Node(6);
        System.out.println(ink.findPreOrder());
    }
}
