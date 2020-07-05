package com.deepika.problem.solving.Heaps;

import java.util.ArrayList;

public class HeapGenerics<T extends Comparable<T>> {
    ArrayList<T> data = new ArrayList<T>();
    public void add(T item){
        data.add(item);
        upheapify(data.size()-1);
    }
    private void upheapify(int ci){
        int pi=(ci - 1)/2;  //No base case required coz (0-1)/2 again 0
        if(isLarger(data.get(ci),data.get(pi))>0){
            swap(ci,pi);
            upheapify(pi);
        }
    }
    private void swap(int i ,int j){
        T ith = data.get(i);
        T jth=data.get(j);
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
    public T remove(){
        swap(0,this.data.size()-1);
        T rv = this.data.remove(this.data.size()-1);
        downHeapify(0);
        return rv;
    }
    private void downHeapify(int pi){
        int lci = 2*pi+1;
        int rci=2*pi+2;
        int mini = pi;
        if(lci<data.size() && isLarger(data.get(lci),data.get(mini))>0){
            mini = lci;
        }
        if(rci<data.size() && isLarger(data.get(rci),data.get(mini))>0){
            mini = rci;
        }
        if(mini != pi){
            swap(pi,mini);
            downHeapify(mini);
        }
    }
    //if t having higher priority then return positive value
    public int isLarger(T t,T o){
        return t.compareTo(o);
    }
    public T get(){
        return this.data.get(0);
    }
}
