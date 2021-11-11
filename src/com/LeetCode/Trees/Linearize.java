package com.LeetCode.Trees;

import javax.sound.sampled.Line;
import java.util.ArrayList;

public class Linearize {
 class Node{
     int key;
     ArrayList<Node> children;
     Node(int key){
         this.key=key;
         this.children=new ArrayList<>();
     }
 }
   Node root=null;
   Node prev=null;
    int ff=-1;
    int currrr=-1;
    public  void linearize(Node node){
        // write your code here
        if(node==null){
            return;
        }
        prev=node;
        ff=prev.key;
        for(int i=0;i<node.children.size();i++){
            Node child=node.children.get(i);
            currrr=child.key;
            if(prev!=null){
                node.children.remove(child);
                prev.children.add(child);
            }
            linearize(child);
        }
    }


    /*

    function getCheapestCost(rootNode):
    n = rootNode.numberOfChildren()

    if (n == 0):
        return rootNode.cost
    else:
        # initialize minCost to the largest integer in the system
        minCost = MAX_INT
        for i from 0 to n-1:
            tempCost = getCheapestCost(rootNode.child[i])
            if (tempCost < minCost):
                minCost = tempCost

    return minCost + rootNode.cost
    */

    public static void main(String[] args) {
        Linearize ll= new Linearize();

        ll.root=ll.new Node(10);
        Node child1=ll. new Node(20);
        Node child2= ll.new Node(30);
        Node child3= ll.new Node(40);
        Node child21=ll.new Node(50);
        Node child22= ll.new Node(60);
        Node child31= ll.new Node(70);
        ll.root.children.add(child1);
        ll.root.children.add(child2);
        ll.root.children.add(child3);
        child2.children.add(child21);
        child2.children.add(child22);
        child3.children.add(child31);
        ll.linearize(ll.root);
        System.out.println(ll.root.key);
        for (int i=0;i<ll.root.children.size();i++){
            System.out.println(ll.root.children.get(i).key);
        }
    }
}
