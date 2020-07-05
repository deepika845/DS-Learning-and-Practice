package com.deepika.problem.solving.linkedlist;

public class ListClient {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.insertlast(1);
        list.insertlast(2);
        list.insertlast(3);
        list.insertlast(4);
//        list.insertfirst(3);
//        list.insertfirst(2);
       list.insertlast(5);
       list.insertlast(6);

//        list.display();
//        System.out.println();

//        LinkedList list1 = list.mergesort(list);

//        list1.display();

        //list.odd_even();
        list.reverset(3);

        list.display();
//        System.out.println(list.deletefirst());
//
//        System.out.println(list.deletelast());
//        System.out.println(list.mid());




    }
}
