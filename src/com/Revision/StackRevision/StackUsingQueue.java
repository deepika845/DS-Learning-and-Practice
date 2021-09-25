package com.Revision.StackRevision;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> q1= new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    public void push(int item){
        q2.add(item);
        while (!q1.isEmpty()){
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1=q2;
        q2=temp;
    }
    public int pop(){
        return !q1.isEmpty()?q1.remove():-1;
    }

    public static void main(String[] args) {
        StackUsingQueue stq= new StackUsingQueue();
        stq.push(3);
        stq.push(2);
        stq.push(1);
        System.out.println(stq.pop());
    }
}
