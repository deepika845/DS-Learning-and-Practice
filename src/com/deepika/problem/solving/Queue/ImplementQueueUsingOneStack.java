package com.deepika.problem.solving.Queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ImplementQueueUsingOneStack {
    Stack<Integer> stacked= new Stack<Integer>();
    Deque<Integer> maxPredictor=new LinkedList<Integer>();
    int size=10;
    //int max;
    public void enqueue(int data){
        stacked.add(data);
        while (!maxPredictor.isEmpty() && stacked.size()>1){
            if(maxPredictor.getLast()>data){
                break;
            }
            maxPredictor.removeLast();
        }
        maxPredictor.addLast(data);
    }
    public int dequeue() {

        while (!stacked.isEmpty()) {
            int x = stacked.pop();
            int j = dequeue();
            if (j == -1) {
                if (maxPredictor.peekFirst() == x) {
                    maxPredictor.removeFirst();
                }
                return x;
            }
            stacked.push(x);
            return j;
        }
        return -1;
    }
    public int max()  {
       if(!maxPredictor.isEmpty()){
           return maxPredictor.removeFirst();
       }
       throw new ArithmeticException("No max");
    }

    public static void main(String[] args)  {
        ImplementQueueUsingOneStack imptd = new ImplementQueueUsingOneStack();
        imptd.enqueue(8);
        imptd.enqueue(2);
        imptd.enqueue(5);
        imptd.enqueue(4);
        System.out.println(imptd.max());
        imptd.dequeue();
        System.out.println(imptd.max());
    }
}
