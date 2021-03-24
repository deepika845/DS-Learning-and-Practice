package com.deepika.problem.solving.TreesLecture;

import java.util.*;

public class BinaryTrees {
    private Node root;
    public void insert(Scanner s){
        this.root=insert(root,s);
    }
    private Node insert(Node node,Scanner s){
        if(node==null){
            int val=s.nextInt();
            return new Node(val);
        }
        System.out.println("Enter the direction"+node.value);
        String dir=s.next();
        if(dir.equals("left")){
            node.left=insert(node.left,s);
        }
        else{
            node.right=insert(node.right,s);
        }
        return node;
    }
    public void findLCa(int a ,int b){
     findLCA(a,b,this.root);
    }
    public void display(){
        display(this.root,"");
    }
    public void display(Node node,String indent){
        if(node==null)
            return;
        System.out.println(indent+node.value);
        display(node.left,indent+"\t");
        display(node.right,indent+"\t");
    }
    public int height(){
        return  height(root);
    }
    public int height(Node node){
        if(node==null){
            return 0;
        }
        return 1+(Math.max(height(node.left),height(node.right)));
    }
    public boolean find(int value){
        return find(root,value);
    }
    public boolean find(Node node,int value){
        if(node==null){
            return false;
        }
        if(node.value==value){
            return true;
        }
        return find(node.left,value) || find(node.right,value);
    }
    public int diameter(){
        return diameter(root);
    }
    private int diameter(Node node){
        if(node == null){
            return 0;
        }
        int current = 1+height(node.left)+height(node.right);
        int max=Math.max(diameter(node.left),diameter(node.right));
        return Math.max(max,current);
    }
    public boolean findLCA(int a ,int b, Node root){
        if(root == null){
            return false;
        }
        if(root.value == a || root.value == b){
            return true;
        }
        boolean b1 = findLCA(a,b,root.left);
        boolean b2 = findLCA(a,b,root.right);
        if (b1 && b2){
            System.out.println(root.value);
            return false;
        }
        if (b1 || b2 ){
            return true;
        }
        else {
            return false;
        }
    }

    public List<List<Integer>> pathSum( int sum) {
        List<List<Integer>> allPath = new ArrayList<List<Integer>>();
        List<Integer> currLevel =new ArrayList<Integer>();
        allPath(root,allPath,currLevel,0,sum);
        return allPath;
    }
    public void allPath(Node root,List<List<Integer>> allPath,List<Integer> currPath,int currSum,int targetSum){
        if(root==null){
            return;
        }
        currSum+=root.value;
        currPath.add(root.value);
        if(root.left==null && root.right==null){
            if(currSum==targetSum){
                List<Integer> arr=new ArrayList<Integer>();
                Collections.copy(currPath,arr);
                allPath.add(arr);
            }
            return;
        }
        allPath(root.left,allPath,currPath,currSum,targetSum);
        if(root.left!=null){
        currPath.remove(currPath.size()-1);}
        allPath(root.right,allPath,currPath,currSum,targetSum);
        if(root.right!=null){
        currPath.remove(currPath.size()-1);}
    }
    public void inorderWithoutRecursion(){
        inorderWithoutRecursion(root);
    }
    public void inorderWithoutRecursion(Node root){
        if(root == null){
            return;
        }
        Node curr = root;
        Stack<Node> ss = new Stack<Node>();
        while (curr != null || ss.size() > 0){
            while (curr != null){
                ss.push(curr);
                curr =curr.left;
            }
            Node popped = ss.pop();
            System.out.println(popped.value + "->");
            curr = popped.right;
        }
    }

    class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value=value;
        }

    }
}
