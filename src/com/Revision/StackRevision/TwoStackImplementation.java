package com.Revision.StackRevision;

public class TwoStackImplementation {
    int top1;
    int top2;
    int[] twoStackArray;
    int maxCapacity;
    TwoStackImplementation(int maxCapacity){
        twoStackArray= new int[maxCapacity];
        this.maxCapacity=maxCapacity;
        top1=-1;
        top2=twoStackArray.length;
    }
    public void push1(int item){
        if (top1+1==top2){
            throw new ArrayIndexOutOfBoundsException("Two stack space if full");
        }
        twoStackArray[++top1]=item;
    }
    public void push2(int item){
        if (top1+1==top2){
            throw new ArrayIndexOutOfBoundsException("Two stack space if full");
        }
        twoStackArray[--top2]=item;
    }
    public  int pop1(){
        if (top1>=0){
            return twoStackArray[top1--];
        }
        else {
            throw new ArrayIndexOutOfBoundsException("Two stack array empty");
        }
    }
    public  int pop2(){
        if (top2<=twoStackArray.length){
            return twoStackArray[top2++];
        }
        else {
            throw new ArrayIndexOutOfBoundsException("Two stack array empty");
        }
    }
    public void printArray(){
        int i=0;
        System.out.print("Stack Array1: ");
        while (i<=top1){
            System.out.print(twoStackArray[i++]+" , ");
        }
        System.out.println();
        System.out.print("Stack Array2: ");
        i=twoStackArray.length-1;
        while (i>=top2){
            System.out.print(twoStackArray[i--]+" , ");
        }
    }

    public static void main(String[] args) {
        TwoStackImplementation tsa= new TwoStackImplementation(5);
        tsa.push1(1);
        tsa.push1(2);
        tsa.push1(3);

        tsa.push2(5);
        tsa.push2(4);

        tsa.pop1();
        tsa.push1(6);
        tsa.printArray();


    }
}
