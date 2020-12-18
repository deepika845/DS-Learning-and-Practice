package com.Revision.GraphQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HeapMapStructure<T> {
    HashMap<T,Integer> mapMaintained = new HashMap<>();
    List<Node> heapMaintained=new ArrayList<>();
    class Node{
        T val;
        int weight;
        Node(T val,int weight){
            this.val=val;
            this.weight=weight;
        }
    }
    public void add(T key,int weight){
        heapMaintained.add(new Node(key,weight));
        mapMaintained.put(key,mapMaintained.size());
        int curr=heapMaintained.size()-1;
        int parent =(curr-1)/2;
        while (parent>=0){
            if(heapMaintained.get(curr).weight<heapMaintained.get(parent).weight){
                swap(heapMaintained.get(parent),heapMaintained.get(curr));
                updatePosition(heapMaintained.get(curr).val,heapMaintained.get(parent).val,curr,parent);
                curr=parent;
                parent=(curr-1)/2;
            }
            else {
                break;
            }
        }
    }
    public T extractMin(){
        swap(heapMaintained.get(0),heapMaintained.get(heapMaintained.size()-1));
        mapMaintained.remove(heapMaintained.get(heapMaintained.size()-1).val);
        Node kk =heapMaintained.remove(heapMaintained.size()-1);

        int size = heapMaintained.size()-1;
        int parent =0;
        while (true){
            int left=2*parent+1;
            int right =2*parent+2;
            if(left>size){
                break;
            }
            if(right>size){
                right=left;
            }
            int smallestIndex=heapMaintained.get(left).weight<=heapMaintained.get(right).weight?left:right;
            if(heapMaintained.get(smallestIndex).weight<heapMaintained.get(parent).weight){
                swap(heapMaintained.get(smallestIndex),heapMaintained.get(parent));
                updatePosition(heapMaintained.get(smallestIndex).val,heapMaintained.get(parent).val,smallestIndex,parent);
                parent=smallestIndex;
            }
            else {
                break;
            }
        }
        return kk.val;
    }
    public void decreaseKey(T key,int newWeight){
        int curr=mapMaintained.get(key);
        Node ach = heapMaintained.get(curr);
        ach.weight=newWeight;
        int parent=(curr-1)/2;
        while (parent>=0){
            if(heapMaintained.get(curr).weight<heapMaintained.get(parent).weight){
                swap(heapMaintained.get(parent),heapMaintained.get(curr));
                updatePosition(heapMaintained.get(curr).val,heapMaintained.get(parent).val,curr,parent);
                curr=parent;
                parent=(curr-1)/2;
            }
            else {
                break;
            }
        }
    }
    private void updatePosition(T val, T val1, int curr, int parent) {
        mapMaintained.put(val,curr);
        mapMaintained.put(val1,parent);
    }

    private void swap(Node node, Node node1) {
        int weightk = node.weight;
        T valk= node.val;
        node.val=node1.val;
        node.weight=node1.weight;
        node1.weight=weightk;
        node1.val=valk;
    }
    public boolean containsData(T key){
        return mapMaintained.containsKey(key);
    }
    public int min(){
        return heapMaintained.get(0).weight;
    }
    public boolean isEmpty(){
        return heapMaintained.isEmpty();
    }
    public Integer getWeight(T key){
        Integer posi = mapMaintained.get(key);
        if(posi==null){
            return null;
        }
        return heapMaintained.get(posi).weight;
    }

}
