package com.deepika.problem.solving.Interviewquestions;

import java.util.HashSet;
import java.util.Set;

public class CloneLinkedList {
    static Node root;
    static class Node{
        int data;
        Node prev;
        Node next;
        Node(int data){
            this.data = data;

        }
    }
    public static Node findClone(Node node, Set<Integer> visited){
        if(node == null){
            return null;
        }
        Node newNode;
        if(!visited.contains(node.data)){
             newNode = new Node(node.data);
            visited.add(newNode.data);

        }
        else {
            return node;
        }
        newNode.next=findClone(node.next,visited);
        newNode.prev = findClone(node.prev,visited);
        return newNode;

    }


    public static void main(String[] args) {
        Node one = new Node(1);
        root =one;
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        one.next = two;
        one.prev=three;
        two.next=three;
        two.prev=one;
        three.next=four;
        three.prev =three;
        four.next=one;
        Set<Integer> vv = new HashSet<>();
        Node cloneRoot = findClone(root,vv);
        System.out.println(cloneRoot.data);
        System.out.println(cloneRoot.prev.data);
    }
}
