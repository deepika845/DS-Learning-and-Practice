package com.deepika.problem.solving.Interviewquestions;
import java.util.Stack;

public class ImplementQueueUsingTwoStack {
  Stack<Integer> s1 = new Stack<>();
  Stack<Integer> s2 = new Stack<>();
   public void enqueue(int ele){
       s1.push(ele);
   }
   public int dequeue(){
       if(s1.isEmpty()){
           return -1;
       }
       while (!s1.isEmpty()){
           int p = s1.pop();
           s2.push(p);
       }
       return s2.pop();
   }
    public static void main(String[] args) {
       ImplementQueueUsingTwoStack nn = new ImplementQueueUsingTwoStack();
       nn.enqueue(4);
       nn.enqueue(3);
        nn.enqueue(2);
        nn.enqueue(1);
        nn.enqueue(0);
        System.out.println(nn.dequeue());

    }
}
