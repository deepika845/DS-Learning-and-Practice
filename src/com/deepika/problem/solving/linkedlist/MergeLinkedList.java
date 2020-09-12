package com.deepika.problem.solving.linkedlist;



import java.util.Scanner;

public class MergeLinkedList {
     Node head;
     Node tail;
     class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }

    public static void main(String[] args)
    {
//        Scanner s = new Scanner(System.in);
//        constructLinkedList(s);
//        sortUsingMerge(head,tail);
//        printList();
    }
//
//    private static void printList() {
//        Node curr = head;
//        while (curr!=null){
//            System.out.println(curr.data);
//            curr=curr.next;
//        }
//    }
//    public void addData(int x) {
//        if(head==null) {
//            head=tail=new Node(x);
//            return;
//        }
//        tail.next=new Node(x);
//        tail=tail.next;
    }


//    private  MergeLinkedList sortUsingMerge(MergeLinkedList paraFirst,MergeLinkedList paraSecond) {
//        if(head==tail) {
//        MergeLinkedList mm = new MergeLinkedList();
//        mm.addData(head.data);
//        return mm;
//        }
//            Node mid = findMid(head ,tail);
//            Node nextMid = mid.next;
////            mid.next=null;
////            tail.next=null;
//            MergeLinkedList mm1 = sortUsingMerge(head,mid);
//
//            MergeLinkedList mm2 =sortUsingMerge(nextMid,tail);
//
//            megeAfterSort(mm1,mm2);
//        }
//    }
//
//    private static void megeAfterSort(MergeLinkedList mll,MergeLinkedList mll1) {
//        Node newHead1=head;
//        Node newTail1= tail;
//        Node newHead2 =
//        while (newHead!=null && newTail!=null){
//            if(newHead.data<newTail.data){
//                if(a==null){
//
//                    a=new Node(newHead.data);
//                    head=tail=a;
//                }
//                else{
//                    a.next=new Node(newHead.data);
//                    tail=a.next;
//                }
//                newHead=newHead.next;
//            }
//            else{
//                if(a==null){
//                    a=new Node(newTail.data);
//                    head=tail=a;
//                }
//                else {
//                    a.next=new Node(newTail.data);
//                    tail=a.next;
//                }
//                newTail=newTail.next;
//            }
//            a=a.next;
//        }
//        if(newTail==null){
//            while (newHead!=null){
//                a=new Node(newHead.data);
//                tail=a;
//                newHead=newHead.next;
//                a=a.next;
//            }
//        }
//        else if(newHead==null){
//z            while (newTail!=null){
//                a=new Node(newTail.data);
//                tail=a;
//                newTail = newTail.next;
//                a=a.next;
//            }
//        }
//        //tail=a;
//
//    }
//
//    private static Node findMid(Node head,Node tail) {
//        Node fast =head;
//        Node slow = head;
//        while (fast!=tail && fast.next!=tail){
//            fast=fast.next.next;
//            slow=slow.next;
//        }
//        return slow;
//    }
//
//    private static void constructLinkedList(Scanner s) {
//        System.out.println("Insert?");
//        String demand = s.next();
//        if(demand.equals("yes")){
//           insertLast(s);
//        }
//        else{
//            return;
//        }
//    }
//
//    private static void insertLast(Scanner s) {
//        System.out.print("Enter data : ");
//        int x = s.nextInt();
//        Node newNode = new Node(x);
//        if(head==null){
//            head=tail=newNode;
//        }
//        else{
//            tail.next=newNode;
//            tail=newNode;
//        }
//        constructLinkedList(s);
//    }
