package com.Revision.GraphQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DsMaintained<T> {
    HashMap<T,Integer> mapMaintained= new HashMap<>();
    List<Node> listMaintained= new ArrayList<>();
    class Node{
        T val;
        int weight;
        Node(T val,int index){
            this.val=val;
            this.weight=index;
        }
    }
    public void add(T val,int weight){
        listMaintained.add(new Node(val,weight));
        mapMaintained.put(val,listMaintained.size()-1);
        upheapify(listMaintained.size()-1);
    }

    private void upheapify(int i) {
        int parent =(i-1)/2;
        if (parent>=0){
            if (listMaintained.get(parent).weight>listMaintained.get(i).weight){
                swap(i,parent);
                upheapify(parent);
            }
        }
    }

    private void swap(int i, int parent) {
        Node gg= listMaintained.get(i);
        listMaintained.set(i,listMaintained.get(parent));
        listMaintained.set(parent,gg);

        mapMaintained.put(listMaintained.get(i).val,i);
        mapMaintained.put(listMaintained.get(parent).val,parent);

    }
    public  T extractMin(){
        swap(0,listMaintained.size()-1);
        Node poped=listMaintained.remove(listMaintained.size()-1);
        mapMaintained.remove(poped.val);
        downheapify(0);
        return poped.val;
    }


    private void downheapify(int i) {
        int curr=i;
        int li=2*i+1;
        int ri=2*i+2;
        if (li<listMaintained.size()  && listMaintained.get(li).weight<listMaintained.get(curr).weight){
            curr=li;
        }
        if (ri<listMaintained.size()  && listMaintained.get(ri).weight<listMaintained.get(curr).weight){
            curr=ri;
        }
        if (curr!=i){
            downheapify(curr);
        }
    }
    public void decreaseKey(T val,int newWeight){
        int index= mapMaintained.get(val);
        Node getted= listMaintained.get(index);
        getted.weight=newWeight;
        upheapify(index);
    }
    public boolean isEmpty(){
        return listMaintained.isEmpty();
    }
    public boolean containsData(T val){
        return mapMaintained.containsKey(val);
    }
    public int findWeight(T val){
        return listMaintained.get(mapMaintained.get(val)).weight;
    }

}
