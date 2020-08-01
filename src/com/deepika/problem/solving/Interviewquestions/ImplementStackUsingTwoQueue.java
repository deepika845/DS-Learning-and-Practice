package com.deepika.problem.solving.Interviewquestions;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingTwoQueue {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    public void push(int ele){
        q2.add(ele);
        while (!q1.isEmpty()){
            q2.add(q1.poll());
        }
        Queue<Integer> temp =q1;
        q1= q2;
        q2=temp;
    }
    public int pop(){
        if(q1.isEmpty()){
            return -1;
        }
        return q1.peek();
    }

    public static void main(String[] args) {
        ImplementStackUsingTwoQueue im = new ImplementStackUsingTwoQueue();
        im.push(4);im.push(3);
        im.push(2);
        im.push(1);
        System.out.println(im.pop());

    }
}
