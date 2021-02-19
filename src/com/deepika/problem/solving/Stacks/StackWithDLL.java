package com.deepika.problem.solving.Stacks;

public class StackWithDLL {
    DllNode head;
    DllNode mid;
    int midVal;
    int count;
    class DllNode{
        DllNode prev;
        DllNode next;
        int val;
        DllNode(int val){
            this.val=val;
        }
    }
    public void push(int item){
        DllNode newNode = new DllNode(item);
        newNode.prev=null;
        newNode.next= head;
        count+=1;
        if(count==1){
            mid=newNode;
            midVal=mid.val;
        }
        else {
            if(head!=null){
                head.prev=newNode;
            }
            if(count%2==0){
                mid=mid.prev;
                midVal=mid.val;
            }
        }
        head=newNode;
    }
    public void pop(){
        if(count==1 || count==0){
            return;
        }
        head=head.next;
        head.prev=null;
        count=count-1;
        if(count%2==1){
            mid=mid.prev;
            midVal=mid.val;
        }
    }

    public static void main(String[] args) {
        StackWithDLL swd = new StackWithDLL();
        swd.push(3);
        System.out.println(swd.midVal);
        swd.push(2);
        System.out.println(swd.midVal);
        swd.push(4);
        System.out.println(swd.midVal);
        swd.push(5);
        System.out.println(swd.midVal);
    }
}
