package com.deepika.problem.solving.Stacks;

import java.util.Deque;
import java.util.LinkedList;

public class StackWithMaxAPI {
    static class ElementMaxCache {
        int element;
        int max;

        ElementMaxCache(int element, int max) {
            this.element = element;
            this.max = max;
        }
    }

    Deque<ElementMaxCache> stackMaintained = new LinkedList<>();
    public boolean isEmpty(){
        return stackMaintained.isEmpty();
    }
    public void push(int ele){
        stackMaintained.addFirst(new ElementMaxCache(ele,Math.max(ele,isEmpty()?ele:max())));
    }

    private int max() {
        if(isEmpty()){
            throw new IllegalStateException("empty Stack");
        }
        return stackMaintained.peekFirst().max;
    }
    private int pop() {
        if(isEmpty()){
            throw new IllegalStateException("empty Stack");
        }
        return stackMaintained.removeFirst().element;
    }

    public static void main(String[] args) {
        StackWithMaxAPI ii = new StackWithMaxAPI();
        ii.push(1);
        ii.push(0);
        System.out.println(ii.max());
    }
}