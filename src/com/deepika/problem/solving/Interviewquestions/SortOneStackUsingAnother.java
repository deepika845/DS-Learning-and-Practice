package com.deepika.problem.solving.Interviewquestions;

import java.util.Stack;

public class SortOneStackUsingAnother {
    public static void main(String[] args) {
        Stack<Integer> kk = new Stack<Integer>();
        kk.push(4);
        kk.push(1);
       // kk.push(3);
        //kk.push(2);
        kk = sortTheSatck(kk);
        System.out.println(kk);
    }

    private static Stack<Integer>  sortTheSatck(Stack<Integer> kk) {
        Stack<Integer> mediator = new Stack<Integer>();
        mediator.push(kk.pop());
        while (!kk.isEmpty()){
            if(mediator.peek() < kk.peek()){
                mediator.push(kk.pop());
            }
            else{
                int pop=kk.pop();
                if (mediator.isEmpty()){
                    mediator.push(pop);
                    continue;
                }
                while( ! mediator.isEmpty()&& !(mediator.peek()<pop)){
                    kk.push(mediator.pop());
                }
                mediator.push(pop);
            }
        }
       return mediator;
    }
}
