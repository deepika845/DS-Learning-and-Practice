package com.Revision.StackRevision;

import java.util.Arrays;

public class ImplementNStack {
    int top[];
    int next[];
    int arr[];
    int free=0;
    ImplementNStack(int numSTack,int len){
        arr= new int[len];
        top= new int[numSTack];
        next=new int[len];
        Arrays.fill(top,-1);
        for (int i=0;i<len-1;i++){
            next[i]=i+1;
        }
        next[len-1]=-1;
    }
    public void push(int item,int stackCurr){
        int i=free;
        free=next[i];
        next[i]=top[stackCurr];
        top[stackCurr]=i;
        arr[i]=item;
    }
    public int pop(int stkNum){
        int poppes=arr[top[stkNum]];
        top[stkNum]=next[top[stkNum]];
        next[top[stkNum]]=free;
        free=top[stkNum];
        return poppes;
    }
    public static void main(String[] args) {

    }
}
