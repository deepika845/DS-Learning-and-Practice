package com.deepika.problem.solving.linkedlist;

public class FindCommonPArt {
    static class Node{
        int val;
        Node next;
        Node(int value){
            val=value;
        }
    }
    public static int findCount(Node nn){
        int count=0;
        Node ff = nn;
        while (ff!=null){
            ff=ff.next;
            count++;
        }
        return count;
    }
    public static int findCommonPart(Node first,Node second){
        if(first==second){
            return first.val;
        }
        return findCommonPart(first.next,second.next);

    }

    public static void main(String[] args) {
        Node head1 = new Node(32);
        head1.next=new Node(55);
        head1.next.next=new Node(44);
        head1.next.next.next=new Node(79);
        head1.next.next.next.next=new Node(32);
        Node head2 = new Node(6);
        head2.next=head1.next.next;
        int len1=findCount(head1);
        int len2 = findCount(head2);
        int diffLen =Math.abs(len1-len2);
        while (diffLen>0){
            head1=head1.next;
            diffLen--;
        }
        System.out.println( findCommonPart(head1,head2));
    }
}
