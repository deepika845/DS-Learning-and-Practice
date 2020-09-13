package com.deepika.problem.solving.linkedlist;

public class AddTwoLinkedList {
    static class Node{
        int val;
        Node next;
        Node(int vsl){
            val=vsl;
        }
    }

    public static void printArray(Node head){
        Node cur= head;
        while (cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
    public static int addTwoLinkedList(Node head1,Node head2){
        int sum=0;
        int carry=0;
        Node curr1=head1;
        Node curr2=head2;
        int i=0;
        while (curr1!=null && curr2!=null){
            int hs = curr1.val;
            int hs1=curr2.val;
            int currSum = (curr1.val+curr2.val)+carry ;
            carry=(currSum)/10;
            sum += (currSum%10)*(int)Math.pow(10,i);
            curr1=curr1.next;
            curr2=curr2.next;
            i+=1.0;
        }
        if(curr1!=null){
            while (curr1!=null){
                int currsum =  (curr1.val+carry);
                carry=currsum/10;

                sum=(currsum%10*(int)Math.pow(10,i))+sum;
                curr1=curr1.next;
                i+=1;
            }
        }
       if(curr2!=null){
            while (curr2!=null){
                sum=(curr2.val*(int)Math.pow(10,i))+sum;
                curr2=curr2.next;
                i+=1;
            }
        }
        if(carry!=0){
            sum=carry*(int)(Math.pow(10.0,i))+sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        Node head1 = new Node(9);
         head1.next = new Node(0);
         head1.next.next = new Node(0);
        // head1.next.next.next = new Node(3);
        // printArray(head1);
        Node head2 = new Node(0);
        head2.next = new Node(0);
        head2.next.next=new Node(1);
         //printArray(head2);
        System.out.println(addTwoLinkedList(head1,head2));
    }

}
