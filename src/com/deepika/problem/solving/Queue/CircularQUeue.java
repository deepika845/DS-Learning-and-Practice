package com.deepika.problem.solving.Queue;

import com.deepika.DynamicProgramming.MinCoinChange;

public class CircularQUeue {
    int[] arr;
    int front = -1;
    int rear;
    int size;
    int MIN_CAPACITY = 5;

    CircularQUeue(int capacity) {
        arr = new int[MIN_CAPACITY];
    }

    public void enqueue(int data) {
        if (front == -1) {
            front = rear = 0;
            arr[front] = data;
        } else if ((rear + 1) % MIN_CAPACITY == front) {
            resize(data);
        } else {
            rear = (rear + 1) % MIN_CAPACITY;
            arr[rear] = data;
        }
        size++;
    }

    private void resize(int data) {
        int temp[] = new int[MIN_CAPACITY * 2];
       // MIN_CAPACITY=MIN_CAPACITY*2;
        int i = front;
        int k = 0;
        while (i!=rear) {
            temp[k++] = arr[i];
            i = (i + 1) % MIN_CAPACITY;
        }
        temp[k++]=arr[i];
        temp[k]=data;
        MIN_CAPACITY=MIN_CAPACITY*2;
        front=0;
        rear=k ;
        arr = temp;
    }


    public int dequeue() {
        if (front == -1) {
            return -1;
        }
        int temp = arr[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % MIN_CAPACITY;
        }
        size--;
        return temp;

    }
    public int sizeOfQueue(){
        return size;

    }
    public void printArray(){
        int i=front;
        while (i!=rear){
            System.out.print(arr[i]+",");
            i=(i+1)%MIN_CAPACITY;
        }
        System.out.print(arr[rear]);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQUeue cq=new CircularQUeue(5);
        cq.enqueue(1);
        cq.enqueue(2);
        cq.enqueue(3);
        cq.enqueue(4);
        cq.enqueue(5);
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.enqueue(6);
        cq.enqueue(7);
        cq.enqueue(8);
        cq.printArray();
        System.out.println("Size : "+cq.size);
        cq.enqueue(9);
        cq.printArray();
        System.out.println("Size : "+cq.size);
    }
}