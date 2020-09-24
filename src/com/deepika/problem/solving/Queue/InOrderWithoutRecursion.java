package com.deepika.problem.solving.Queue;


//import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class InOrderWithoutRecursion {
    static int subIndex=0;
    Node root ;
    class Node{
        int data;
        Node left;
        Node right;
      //  int leftSize;
        Node(int data){
            this.data=data;
        }
        Node(int data,Node left,Node right){
            this.data=data;
            this.left=left;
            this.right=right;
            //this.leftSize=leftSize;
        }
    }
    public ArrayList<Integer> findInOrder(){
       Deque<Node> deque= new LinkedList<Node>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Node curr =root;
        while (curr!=null || !deque.isEmpty()){
            if(curr!=null){
                int x = curr.data;
                deque.addFirst(curr);
                curr=curr.left;
            }
            else{
                Node jj=deque.removeFirst();
                int n =jj.data;
                arr.add(jj.data);
                curr=jj.right;
            }
        }
        return arr;
    }
    public ArrayList<Integer> findPreOrder() {
        Deque<Node> deque = new LinkedList<Node>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Node curr1 = root;
        deque.addFirst(curr1);
        while (!deque.isEmpty()) {
            Node curr= deque.removeFirst();
            if (curr != null) {
                arr.add(curr.data);
                deque.addFirst(curr.right);
                deque.addFirst(curr.left);
            }
        }
        return arr;
    }
//    public int findKthNode(int k){
//        Node curr =root;
//        while (curr!=null){
//            //int leftSize=curr.left!=null?curr.leftSize:0;
//            if(leftSize+1<k){
//                k=k-(leftSize+1);
//                curr=curr.right;
//            }
//            if(leftSize==(k-1)){
//                return curr.data;
//            }
//            if(leftSize>k){
//                curr=curr.left;
//            }
//        }
//        return -1;
//    }
    public Node findTree(int[] inorder,int[] preorder){
        if(inorder.length==0 || preorder.length==0){
            return null;
        }
        Node root = new Node(preorder[0]);
        int hh=root.data;
        int index = findIndex(inorder,preorder[0]);
        root.left=findTree(Arrays.copyOfRange(inorder,0,index),Arrays.copyOfRange(preorder,1,index+1));
        root.right=findTree(Arrays.copyOfRange(inorder,index+1,inorder.length),Arrays.copyOfRange(preorder,index+1,preorder.length));
        return root;
    }
    public void findPreOrder(Node root){
        if (root==null){
            return;
        }
        System.out.println(root.data);
        findPreOrder(root.left);
        findPreOrder(root.right);
    }
    public Node constructBinaryTree(ArrayList<Integer> arr){
        Integer currKey = arr.get(subIndex);
        ++subIndex;
        if(currKey==null){
            return null;
        }
        Node leftKey = constructBinaryTree(arr);

        Node rightKey = constructBinaryTree(arr);
        return new Node(currKey,leftKey,rightKey);
    }
    private int findIndex(int[] inorder, int item) {
        int ff=-1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==item){
                ff=i;
                break;
            }
        }
        if(ff==-1){
            throw new ArithmeticException("Not found");
        }
        return ff;
    }
    public static void main(String[] args) {
       InOrderWithoutRecursion ink = new InOrderWithoutRecursion();
   // ink.root= ink.findTree(new int[]{4,5,6,8,9},new int[]{6,4,5,8,9});
     //   ink.findPreOrder(ink.root);
        ArrayList<Integer> ai = new ArrayList<Integer>();
        ai.add(1);
        ai.add(2);
        ai.add(3);
        ai.add(null);
        ai.add(null);
        ai.add(4);
        ai.add(5);
        ai.add(null);
        ai.add(null);
        ai.add(null);
        ai.add(6);
        ai.add(null);
        ai.add(7);
        ai.add(null);
        ai.add(8);
        ai.add(9);
        ai.add(null);
        ai.add(null);
        ai.add(null);
       ink.root=ink.constructBinaryTree(ai);
        System.out.println(ink.findPreOrder());
  //      System.out.println(ink.findKthNode(5));
    }
}
