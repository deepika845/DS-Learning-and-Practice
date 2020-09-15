package com.deepika.problem.solving;

import java.util.ArrayList;
import java.util.LinkedList;import java.util.Queue;

public class LevelOrderQueue {
    static Node root;
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }
    public static ArrayList<ArrayList<Integer>> levelOrder(){
        ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
        Queue<Node> queueOrder = new LinkedList<Node>();
        queueOrder.add(root);
        while (!queueOrder.isEmpty()){
            ArrayList<Integer> thisLevel = new ArrayList<Integer>();
            int len=queueOrder.size();
            for (int i=0;i<len;i++){
                Node currNode = queueOrder.remove();
                thisLevel.add(currNode.val);
                if(currNode.left!=null){
                    queueOrder.add(currNode.left);
                }
                if(currNode.right!=null){
                    queueOrder.add(currNode.right);
                }
            }
            levels.add(thisLevel);
        }
        return levels;
    }
    public static void main(String[] args) {
        root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.right=new Node(4);
        root.right.left=new Node(5);
        System.out.println(levelOrder());

    }
}
