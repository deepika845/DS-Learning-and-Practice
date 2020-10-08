package com.LeetCode;

import java.util.List;

class LinkedSum {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(){ }
        ListNode(int val){
            this.val=val;
        }
        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode head=null;
        ListNode curr = null;
        while(l1 != null && l2!=null){
            int mod = (l1.val+l2.val+carry)%10;
            if(curr==null){
                curr=new ListNode(mod);
                head=curr;
            }
            else{
                curr.next=new ListNode(mod);
                curr=curr.next;
            }
            carry=(l1.val+l2.val+carry)/10;
            l1=l1.next;
            l2=l2.next;
        }
        if(l1!=null){
            while(l1!=null){
                int mod = (l1.val+carry)%10;
                curr.next=new ListNode(mod);
                curr=curr.next;
                carry= (l1.val+carry)/10;
                l1=l1.next;
            }
        }
        if(l2!=null){
            while(l2!=null){
                int mod = (l2.val+carry)%10;
                curr.next=new ListNode(mod);
                curr=curr.next;
                carry= (l2.val+carry)/10;
                l2=l2.next;
            }

        }

        return head;
    }

    public static void main(String[] args) {
        LinkedSum ls = new LinkedSum();
        ListNode l1 = new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);
  ListNode l3 =  ls.addTwoNumbers(l1,l2);
        while (l3!=null){
            System.out.print(l3.val+" -> ");
            l3=l3.next;
        }
        System.out.println();
    }
}