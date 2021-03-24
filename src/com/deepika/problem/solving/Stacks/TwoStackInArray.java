package com.deepika.problem.solving.Stacks;

public class TwoStackInArray {
    int arr[];
    int top1=-1;
    int top2=arr.length/2-1;
    TwoStackInArray(int size){
        arr=new int[size];
    }
    public void push1(int item){
        if(top1==(arr.length/2-1)){
            return;
        }
        else {
            arr[++top1]=item;
        }
    }
    public int pop(){
        return arr[top1--];
    }
    public void push2(int item){
        if(top1>=(arr.length-1)){
            return;
        }
        else {
            arr[++top1]=item;
        }
    }
    public int pop2(){
        return arr[top2--];
    }


}
