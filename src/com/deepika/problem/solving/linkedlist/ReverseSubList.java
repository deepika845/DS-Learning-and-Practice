package com.deepika.problem.solving.linkedlist;

public class ReverseSubList {
    Node head;
    Node tail;
    class Node{
        int value;
        Node next;
        Node(int value){
            this.value=value;
            next = null;
        }
    }
    public void reverseSubList(int x,int y){
        Node curr =head;
        int count =1;
        Node prevX= null;
        while (count<x){
            prevX=curr;
            curr=curr.next;
            count+=1;
        }
        Node nodeX = curr;
        while (count<y){
            curr=curr.next;
            int hn =curr.value;
            count+=1;
        }
        Node nodeY =curr;
        Node afterY =curr.next;
        Node iterator = nodeX;
        Node previous =prevX;
        Node next = iterator;
        while (next!=nodeY){
             next =iterator.next;
             int d = next.value;
            iterator.next= next.next;
            if(previous==null){
                next.next=head;
                head=next;

            }
            else {
            next.next=previous.next;
            previous.next=next;
            }
        }


    }
    public void printList(){
        Node curr =head;
        while (curr!=null){
            System.out.println(curr.value);
            curr=curr.next;
        }
    }
    public static void main(String[] args) {
        ReverseSubList rs = new ReverseSubList();
        rs.head = rs.new Node(3);
        rs.head.next = rs.new Node(2);
        rs.head.next.next = rs.new Node(5);
        rs.head.next.next.next = rs.new Node(4);
        rs.head.next.next.next.next = rs.new Node(-1);
        rs.head.next.next.next.next.next= rs.new Node(-9);
        rs.reverseSubList(1,5);
        rs.printList();

    }
}
