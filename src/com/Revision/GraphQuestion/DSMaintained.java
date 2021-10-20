package com.Revision.GraphQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DSMaintained<T> {
    class Node{
        T val;
        int weight;
        Node(T val,int weight){
            this.val=val;
            this.weight=weight;
        }
    }
    HashMap<T,Integer> positionedMaintained= new HashMap<>();
    List<Node> listMaintained= new ArrayList<>();
    public void add(T val,int weight){
        listMaintained.add(new Node(val,weight));
        positionedMaintained.put(val,listMaintained.size()-1);
        upheapify(listMaintained.size()-1);
    }

    private void upheapify(int currValue) {
        int parentValue=(currValue-1)/2;
        int www=listMaintained.get(parentValue).weight;
        int wess=listMaintained.get(currValue).weight;
        if(listMaintained.get(parentValue).weight>listMaintained.get(currValue).weight){
            swap(parentValue,currValue);
            upheapify(parentValue);
        }
    }

    private void swap(int parentValue, int currValue) {
        Node temp=listMaintained.get(parentValue);
        listMaintained.set(parentValue,listMaintained.get(currValue));
        listMaintained.set(currValue,temp);
        positionedMaintained.put(listMaintained.get(currValue).val,currValue);
        positionedMaintained.put(listMaintained.get(parentValue).val,parentValue);

    }
    public T extractMin(){
        swap(0,listMaintained.size()-1);
        Node poped = listMaintained.remove(listMaintained.size()-1);
        positionedMaintained.remove(poped.val);
        downheapify(0);
        return poped.val;
    }
    public void decreaseKey(T val, int newWeight){
        int pos=positionedMaintained.get(val);
        Node nv=listMaintained.get(pos);
        nv.weight=newWeight;
        upheapify(pos);
    }

    private void downheapify(int i) {
        int min=i;
        int li=2*i+1;
        int ri=2*i+2;


        if(li<listMaintained.size() && listMaintained.get(min).weight>listMaintained.get(li).weight){
            min=li;
        }
        if (ri<listMaintained.size() && listMaintained.get(min).weight>listMaintained.get(ri).weight){
            min=ri;
        }
        if (min!=i){
            swap(i,min);
            downheapify(min);
        }
    }
    public boolean isEmpty(){
        return listMaintained.isEmpty();
    }
    public boolean contains(T val){
        return positionedMaintained.containsKey(val);
    }
    public int getWeight(T val){
        return listMaintained.get(positionedMaintained.get(val)).weight;
    }
    public int peekWeight(){
        return listMaintained.get(0).weight;
    }


}
