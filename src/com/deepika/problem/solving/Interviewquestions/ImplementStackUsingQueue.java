package com.deepika.problem.solving.Interviewquestions;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {
Queue<Integer> stack = new LinkedList<Integer>();
int currSize = 10 ;
public void push(int ele){
    if(stack.size() == currSize){
        return;
    }
    int rls = stack.size();
    stack.add(ele);
    for (int i=0;i<rls ;i++){
        int popped = stack.remove();
        stack.add(popped);
    }
}
public int pop(){
    if(stack.size()==0){
        return -1;
    }
    return stack.remove();
}
public static void main(String[] args) {
    ImplementStackUsingQueue kk = new ImplementStackUsingQueue();
    kk.push(1);
    kk.push(2);
    kk.push(3);
    kk.push(4);
    System.out.println(kk.pop());
}
}

