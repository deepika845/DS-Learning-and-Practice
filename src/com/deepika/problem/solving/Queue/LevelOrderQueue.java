package com.deepika.problem.solving.Queue;

import java.util.ArrayList;
import java.util.LinkedList;import java.util.Queue;
import java.util.Stack;

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
    public static ArrayList<ArrayList<Integer>> levelOrder() {
        ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
        Queue<Node> queueOrder = new LinkedList<Node>();
        boolean checked = true;
        int len = 0;
        queueOrder.add(root);
        Stack<Node> stackOrder = new Stack<Node>();
        stackOrder.add(root);
        while (!queueOrder.isEmpty() || !stackOrder.isEmpty()) {
            ArrayList<Integer> thisLevel = new ArrayList<Integer>();
            if (checked) {
                len = stackOrder.size();
            } else {
                len = queueOrder.size();
            }
            for (int i = 0; i < len; i++) {
                if (checked) {
                    Node currNode = stackOrder.pop();
                    if (!queueOrder.isEmpty()) {
                        queueOrder.remove();
                    }
                    thisLevel.add(currNode.val);
                    if (currNode.left != null) {
                        queueOrder.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        queueOrder.add(currNode.right);
                    }
                } else {
                    Node currNode = queueOrder.remove();

                    if (!stackOrder.isEmpty()) {
                        stackOrder.pop();
                    }
                    thisLevel.add(currNode.val);
                    if (currNode.right != null) {
                        stackOrder.push(currNode.right);
                    }
                    if (currNode.left != null) {
                        stackOrder.push(currNode.left);
                    }
                }
            }
            checked = !checked;
            levels.add(thisLevel);
        }
        return levels;
    }
    public static ArrayList<ArrayList<Integer>> levelReverse(){
        ArrayList<ArrayList<Integer>> level = new ArrayList<ArrayList<Integer>>();
        Queue<Node> queueOrder = new LinkedList<Node>();
        Stack<Node> stackOrder = new Stack<Node>();
        queueOrder.add(root);
        boolean checked = false;
        while (!queueOrder.isEmpty()) {
            ArrayList<Integer> thisLevel = new ArrayList<Integer>();
            int len = queueOrder.size();
            checked = !checked;
            for (int i = 0; i < len; i++) {
                Node currNode = queueOrder.remove();
                thisLevel.add(currNode.val);
                if (checked) {
                    if(currNode.left!=null){
                    queueOrder.add(currNode.left);
                    stackOrder.push(currNode.left);}
                    if(currNode.right!=null){
                    queueOrder.add(currNode.right);
                    stackOrder.push(currNode.right);}
                }
                else{
                   Node ff = stackOrder.pop();
                   if(ff.right!=null){
                       queueOrder.add(ff.right);
                   }
                   else if(ff.left!=null){
                       queueOrder.add(ff.left);
                   }
                }
            }
            level.add(thisLevel);
        }
        return level;

    }
    public static void main(String[] args) {
        root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.right=new Node(4);
        root.right.left=new Node(5);
       // levelOrder();
        System.out.println(levelReverse());

    }
}
