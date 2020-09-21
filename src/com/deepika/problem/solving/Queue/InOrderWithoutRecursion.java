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
        int leftSize;
        Node(int data,int leftSize){
            this.data=data;
            this.leftSize=leftSize;
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
    public ArrayList<Integer> findPreOrder() {
        Deque<Node> deque = new LinkedList<Node>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Node curr = root;
        while (curr != null || !deque.isEmpty()) {
            if (curr != null) {
                int x = curr.data;
                deque.addLast(curr);
                curr = curr.left;
            } else {
                Node jj = deque.removeFirst();
                int n = jj.data;
                arr.add(jj.data);
                curr = jj.right;
            }
        }
        return arr;
    }
    public int findKthNode(int k){
        Node curr =root;
        while (curr!=null){
            int leftSize=curr.left!=null?curr.leftSize:0;
            if(leftSize+1<k){
                k=k-(leftSize+1);
                curr=curr.right;
            }
            if(leftSize==(k-1)){
                return curr.data;
            }
            if(leftSize>k){
                curr=curr.left;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
       InOrderWithoutRecursion ink = new InOrderWithoutRecursion();
       ink.root=ink.new Node(3,2);
        ink.root.left=ink.new Node(2,1);
        ink.root.left.left=ink.new Node(1,0);
        ink.root.right=ink.new Node(5,1);
        ink.root.right.left=ink.new Node(4,0);
        ink.root.right.right=ink.new Node(6,0);
    //    System.out.println(ink.findPreOrder());
        System.out.println(ink.findKthNode(5));
    }
}
