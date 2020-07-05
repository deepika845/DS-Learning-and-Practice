package com.deepika.problem.solving.Heaps;

import java.util.ArrayList;

public class Heap {
    ArrayList<Integer> data = new ArrayList<Integer>();
    public void add(int item){
        data.add(item);
        upheapify(data.size()-1);
    }
    private void upheapify(int ci){
        int pi=(ci - 1)/2;  //No base case required coz (0-1)/2 again 0
        if(data.get(ci)<data.get(pi)){
            swap(ci,pi);
            upheapify(pi);
        }
    }
    private void swap(int i ,int j){
        int ith = data.get(i);
        int jth=data.get(j);
        data.set(i,jth);
        data.set(j,ith);
    }
    public void display(){
        System.out.println(data);
    }
    public int size(){
        return this.data.size();
    }
    public boolean isEmpty(){
        return this.size() == 0;
    }
    public int remove(){
        swap(0,this.data.size()-1);
        int rv = this.data.remove(this.data.size()-1);
        downHeapify(0);
        return rv;
    }
    private void downHeapify(int pi){
        int lci = 2*pi+1;
        int rci=2*pi+2;
        int mini = pi;
        if(lci<data.size()&&data.get(lci)<data.get(mini)){
            mini = lci;
        }
        if(rci<data.size()&&data.get(rci)<data.get(mini)){
            mini = rci;
        }
        if(mini != pi){
           swap(pi,mini);
           downHeapify(mini);
        }
    }
    public int get(){
        return this.data.get(0);
    }
}
