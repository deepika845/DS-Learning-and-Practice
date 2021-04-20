package com.Revision.StackRevision;

public class ImplementedStackUsingArray {
    int arrMaintained[];
    int maxSize;
    int top;
    ImplementedStackUsingArray(int maxSize){
        this.arrMaintained=new int[maxSize];
        this.maxSize=maxSize;
        top=-1;
    }
    public void  push(int item){
        if (!isFull())
        arrMaintained[++top]=item;
        else {
            throw new ArrayIndexOutOfBoundsException("stack is full");
        }
    }
    public int pop(){
        if (!isEmpty())
        return arrMaintained[top--];
        throw new ArrayIndexOutOfBoundsException("array is EMpty");
    }
    public boolean isEmpty(){
        return (top==-1);
    }
    public  boolean isFull(){
        return top==maxSize-1;
    }
    public void  printStack(){
        int k=top;
        while (k!=-1){
            System.out.print(arrMaintained[k--]+" , ");
        }
    }

    public static void main(String[] args) {
        ImplementedStackUsingArray imt=new ImplementedStackUsingArray(6);
        imt.push(2);
        imt.push(3);
        imt.push(4);
        imt.push(5);
        imt.push(60);
        imt.printStack();
        System.out.println();
        imt.push(9);
        imt.printStack();
        imt.push(77);



    }
}
