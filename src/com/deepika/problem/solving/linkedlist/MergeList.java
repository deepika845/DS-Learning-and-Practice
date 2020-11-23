package com.deepika.problem.solving.linkedlist;

public class MergeList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    public static Node findMerge(Node head1,Node head2){
        Node resultHead=null;
        Node head=null;
        while (head1!=null && head2!=null){
            if(head1.data<head2.data){
                if(resultHead==null){
                    resultHead=head1;
                    head=head1;
                }
                else {
                    resultHead.next=head1;
                    resultHead=resultHead.next;
                }
                head1=head1.next;
            }
            else {
                if (resultHead == null) {
                    resultHead = head2;
                    head = head2;
                } else {
                    resultHead.next = head2;
                    resultHead=resultHead.next;
                }
                head2 = head2.next;
            }
        }
        while (head2!=null){
            resultHead.next=head2;
            resultHead=resultHead.next;
            head2=head2.next;
        }
        while (head1!=null){
            resultHead.next=head1;
            resultHead=resultHead.next;
            head1=head1.next;
        }
        return head;
    }
    public static Node findResultant(Node head1,Node head2){
        Node prev = new Node(0);
        Node dummy=prev;
        while (head1!=null && head2!=null){
            if(head1.data<head2.data) {
                prev.next = head1;
                head1 = head1.next;
                prev = prev.next;
            }
            else {
               prev.next=head2;
               head2=head2.next;
               prev=prev.next;
            }
        }
        prev.next=(head1==null)?head2:head1;
        return dummy.next;
    }

    public static void main(String[] args) {
        Node head1=new Node(3);
        head1.next=new Node(5);
        head1.next.next=new Node(8);
        head1.next.next=new Node(10);
        Node head2=new Node(4);
        head2.next=new Node(7);
        head2.next.next=new Node(9);
        head2.next.next=new Node(11);
    //  Node result=findMerge(head1,head2);
        Node result=findResultant(head1,head2);
        while (result!=null){
            System.out.println(result.data);
            result=result.next;
        }
    }
}
