package com.Revision.StackRevision;

public class QueueImplementation {
    int front=-1;
    int rear=-1;
    int size;
    int maxCapacity;
    int arrMaintained[];
    QueueImplementation(int maxCapacity){
        arrMaintained= new int[maxCapacity];
        this.maxCapacity=maxCapacity;
        size=0;
    }
    public void add(int item){
        if (isFull()){
            return;
        }
        if (front==-1 && front==rear){
            front=rear=0;
        }
        else {
            rear=(rear+1)%maxCapacity;
        }
        arrMaintained[rear]=item;
        size++;
    }
    public int remove(){
        int removed= arrMaintained[front];
        front=(front+1)%maxCapacity;
        size--;
        return removed;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public boolean isFull(){
        return size==maxCapacity;
    }
    public void printQueue(){
        int i=front;
        while (i!=rear){
            System.out.print(arrMaintained[i]+" , ");
            i=(i+1)%maxCapacity;
        }
        System.out.println(arrMaintained[i]);
    }
    public static void main(String[] args) {
        QueueImplementation qtq= new QueueImplementation(5);
        qtq.add(1);
        qtq.add(2);
        qtq.add(3);
        qtq.add(4);
        qtq.add(5);
        qtq.remove();
        qtq.add(1);

        qtq.printQueue();



    }
}
