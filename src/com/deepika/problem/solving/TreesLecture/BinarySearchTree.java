package com.deepika.problem.solving.TreesLecture;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinarySearchTree {
    private Node root;
    public void insert(int value){
        this.root=insert(root,value);
    }

    private Node insert(Node node,int val){
        if(node==null){
            return new Node(val);
        }
        if(node.value>val){
            node.left=insert(node.left,val);
        }
        else{
            node.right=insert(node.right,val);
        }
        return node;
    }
    public void display(){
        display(root,"");
    }
    private void display(Node node,String indent){
        if(node==null){
            return;
        }
        System.out.println(indent+node.value);
        display(node.left,indent+"\t");
        display(node.right,indent+"\t");
    }
    public void inorder(){
        inorder(root,"");
    }
    private void inorder(Node node,String indent){
        if(node==null){
            return;
        }
        inorder(node.left,indent+"\t");
        System.out.println(node.value);
        inorder(node.right,indent+"\t");
    }
    public int successor(int val){
       Node succ =null;
       Node curr =root;
       while(curr!=null){
           if(curr.value>val){
               if(succ==null || curr.value<succ.value){
                   succ=curr;
               }
               curr=curr.left;
           }
           else{
               curr=curr.right;
           }
       }
       return succ.value;
    }
    public void inrange(int k1,int k2){
        inrange(root,k1,k2);
    }
    public void inrange(Node node,int k1,int k2){
        if(node==null){
            return;
        }
        if(node.value>k1 && node.value<k2){
            System.out.println(node.value);
        }
        if(node.value>k1){
            inrange(node.left,k1,k2);
        }
        if(node.value<k2){
            inrange(node.right,k1,k2);
        }
    }
    public  void makeFromSortedArray(int arr[],int start,int end){
        if(start>end){
            return;
        }
        int mid=(start+end)/2;
        insert(arr[mid]);
        makeFromSortedArray(arr,start,mid-1);
        makeFromSortedArray(arr,mid+1,end);
    }
    public void levelOrder(){
        levelOrder(root);
    }
    public void levelOrder(Node node){
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node temp=queue.remove();
            System.out.println(temp.value);
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }
    }
    private int find(int ar[],int val){
        for(int i=0;i<ar.length;i++){
            if(ar[i]==val)
                return i;
        }
        return -1;
    }
    /*public void makeFromPreIn(int pre[],int in[]){
        this.root=makeFromPreIn(root,pre,in);
    }
    public Node makeFromPreIn(Node node,int[] pre,int[] in){
        if(in.length==0){
            return null;
        }
        int val=pre[0];
        int index=find(in,val);
        int[] preleft= Arrays.copyOfRange(pre,1,index+1);
        int[] preright=Arrays.copyOfRange(pre,index+1,pre.length);
        int[] inleft=Arrays.copyOfRange(in,0,index);
        int[] inright=Arrays.copyOfRange(in,index+1,in.length);
        Node node1 = new Node(val);

        node1.left= makeFromPreIn()(node1.left,preleft,inleft);
        node1.right=makeFromPreIn()(node1.right,preright,inright);

        return node1;
    }*/
    public boolean isBinarySearchTree(Node root,int max,int min){
        if(root==null){
            return true;
        }
        if(root.value<max || root.value>min){
            return false;
        }
        return (isBinarySearchTree(root.left,root.value,min) && isBinarySearchTree(root.right,max,root.value));
    }
    class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value=value;
        }
    }
    public boolean isSameTree(Node p, Node q) {
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if(p.value==q.value){
            return true;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
