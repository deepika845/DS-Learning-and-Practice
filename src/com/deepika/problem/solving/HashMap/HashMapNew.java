package com.deepika.problem.solving.HashMap;
public class HashMapNew<T> {

    private Node head;

    private Node tail;

    private int size=0;

    public void insertfirst(T value){

        Node node = new Node(value);
        node.next= head;
        head= node;

        if(tail==null){
            tail=head;
        }

        size++;
    }

    public void insertlast(T value){

        if(size==0){
            insertfirst(value);
            return;
        }

        Node node = new Node(value);
        tail.next=node;
        tail=node;
        size++;
    }

    public T deletefirst(){

        if(size==0){
            System.out.println("khaali he be");
            return null;
        }

        T value= head.value;

        head=head.next;

        if(head==null){
            tail=null;
        }

        size--;

        return value;
    }

    public T deletelast(){

        if(size<2){
            return deletefirst();
        }

        Node temp = head;

        while(temp.next!=tail){
            temp=temp.next;
        }

        T value= temp.next.value;

        temp.next=null;

        tail=temp;
        size--;

        return value;
    }

    public void display(){

        Node temp=head;

        while(temp!=null){
            System.out.print(temp.value+ " -> ");
            temp=temp.next;
        }
        System.out.print("null");
    }

    public T get(int index){

        Node temp= head;

        for (int i = 0; i <index ; i++) {
            temp=temp.next;
        }
        return temp.value;
    }
    public Node get1(int index){

        Node temp= head;

        for (int i = 0; i <index ; i++) {
            temp=temp.next;
        }
        return temp;
    }

    public void insertbetween(int index, T value){

        if(index==0){
            insertfirst(value);
            return;
        }

        if(index==size){
            insertlast(value);
            return;
        }

        Node prev = get1(index-1);
        Node node = new Node(value);
        node.next=prev.next;
        prev.next=node;
        size++;
    }

   public T deleteatindex(int index){

        if(index==0){
            return deletefirst();
        }

        if(index==size-1){
            return deletelast();
        }

        Node prev= get1(index-1);
        T temp= prev.next.value;

        prev.next=prev.next.next;
        size--;
        return temp;
    }

    public void duplicates(){

        Node temp= head;

        while(temp.next!=null){

            if(temp.value==temp.next.value){
                temp.next=temp.next.next;
                size--;
            }
            else{
                temp=temp.next;
            }
        }
        tail=temp;
    }

    public int find(T value){
        int index=0;
        Node temp= head;

        while(temp!=null){

            if(temp.value.equals(value)){
                return index;
            }
            temp=temp.next;
            index++;
        }
        return -1;
    }

    public void reverse(){
        reverse(head);

    }

    private void reverse(Node node){

        if(node==tail){
            head=tail;
            return;
        }

        reverse(node.next);

        tail.next=node;
        tail=node;
        tail.next=null;
    }



    public Node mid() {

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    public boolean isEmpty(){
        return this.size == 0;
    }


    class Node{

        T value;
        Node next;

        public Node(T value) {
            this.value = value;

        }
    }
}