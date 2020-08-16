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
    public static Node efficientClone(Node node){
        Node curr = node;
        while (curr!=null){
            Node temp = curr.next;
            curr.next = new Node(curr.data);
            curr.next.next=temp;
            curr=temp;
        }
        curr=node;
        while (curr != null)
        {
            if(curr.next != null)
                curr.next.prev = (curr.prev != null)
                        ? curr.prev.next : curr.prev;

            // move to the next newly added node by
            // skipping an original node
            curr = (curr.next != null) ? curr.next.next
                    : curr.next;
        }

        Node original = node, copy = node.next;

        // save the start of copied linked list
        Node temp = copy;

        // now separate the origiznal list and copied list
        while (original != null && copy != null)
        {
            original.next = (original.next != null)?
                    original.next.next : original.next;

            copy.next = (copy.next != null) ? copy.next.next
                    : copy.next;
            original = original.next;
            copy = copy.next;
        }
        return temp;
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
        four.prev=one;
        Set<Integer> vv = new HashSet<>();
        Node cloneRoot = findClone(root,vv);
        System.out.println(cloneRoot.data);
        System.out.println(cloneRoot.prev.data);
        efficientClone(one);
    }
}
