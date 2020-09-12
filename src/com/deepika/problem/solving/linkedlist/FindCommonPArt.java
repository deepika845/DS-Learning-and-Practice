package com.deepika.problem.solving.linkedlist;

import java.util.HashMap;

public class FindCommonPArt {
    static class Node {
        int val;
        Node next;

        Node(int value) {
            val = value;
        }
    }

    public static int findCount(Node nn) {
        int count = 0;
        Node ff = nn;
        while (ff != null) {
            ff = ff.next;
            count++;
        }
        return count;
    }

    public static int findCommonPart(Node first, Node second) {
        if (first == second) {
            return first.val;
        }
        return findCommonPart(first.next, second.next);
    }

    public static void printArray(Node n) {
        Node cur = n;
        while (cur != null) {
            System.out.println(cur.val);
            cur=cur.next;
        }
    }

    public static void deleteDuplicates(Node n) {
        if (n == null) {
            return;
        }
        Node fast = n.next;
        Node slow = n;
        while (fast != null) {
            if (fast.val == slow.val) {
                slow.next = fast.next;
                fast = slow.next;
                continue;
            } else {
                slow = fast;
                fast = fast.next;
            }
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(2);
        head1.next.next.next = new Node(2);
        //head1.next.next.next.next = new Node(3);
//        Node head2 = new Node(6);
//        head2.next=head1.next.next;
//        int len1=findCount(head1);
//        int len2 = findCount(head2);
//        int diffLen =Math.abs(len1-len2);
//        while (diffLen>0){
//            head1=head1.next;
//            diffLen--;
//        }
//        System.out.println( findCommonPart(head1,head2));
//    }
        deleteDuplicates(head1);
        printArray(head1);


    }
}