package com.deepika.problem.solving.Interviewquestions;

import java.util.Stack;

public class ImplementQueueUsingStack {
    Stack<Integer> stack =new Stack<Integer>();
    int currSize=10;
    public void enqueue(int ele){
        if(stack.size() == currSize){
            return;
        }
        stack.add(ele);
    }
    public int dequeue(){
        int k=0;
        if(stack.size()==0){
            return -1;
        }
        if(!stack.isEmpty()){
           int popele = stack.pop();
           if(!stack.isEmpty()){
                k = dequeue();
               stack.push(popele);
           }
           else{
               return popele;
           }
        }
        return k;
    }

    public static void main(String[] args) {
        ImplementQueueUsingStack kk =new ImplementQueueUsingStack();
        //kk.enqueue();
        kk.enqueue(3);
        kk.enqueue(2);
        kk.enqueue(1);
        System.out.println(kk.dequeue());
    }
}

