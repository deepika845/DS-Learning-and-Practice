package com.deepika.problem.solving;

public class BinaryTree {
    Node root;
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    class ReturnType{
        boolean isPerfect;
        boolean isComplete;
        int size;
        Node rootTree;
    }
    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();
        bt.root=bt.new Node(1);
        bt.root.left=bt.new Node(2);
        bt.root.right=bt.new Node(3);
        bt.root.left.left=bt.new Node(4);
        bt.root.left.left.left=bt.new Node(8);
        bt.root.right.right=bt.new Node(5);
        bt.root.right.left=bt.new Node(6);
        bt.root.right.right.left=bt.new Node(7);

        //System.out.println(bt.checkIfBalanced(bt.root));
        System.out.println(bt.isComplete(bt.root).size);
        //System.out.println(rss.size);
        //System.out.println(isBalanced);
    }
    public int height (int n){
        return (int)Math.ceil(Math.log(n+1)/Math.log(2));
    }
    public ReturnType isComplete(Node root){
        ReturnType rt = new ReturnType();
        if(root==null){
            rt.isComplete=true;
            rt.isPerfect=true;
            rt.size=0;
            rt.rootTree=null;
            return rt;
        }
        ReturnType lv = isComplete(root.left);
        ReturnType rv = isComplete(root.right);
        if(lv.isPerfect==true && rv.isComplete==true && (height(lv.size)==height(rv.size))){
            rt.isComplete=true;
            rt.isPerfect=(rv.isPerfect)?true:false;
            rt.size=(rv.size)+lv.size+1;
            rt.rootTree=root;
        }
        else if(lv.isComplete==true && rv.isPerfect==true && (height(lv.size)==(height(rv.size)+1))){
            rt.isComplete=true;
            rt.isPerfect=false;
            rt.size=(rv.size)+lv.size+1;
            rt.rootTree=root;
        }
        else{
            rt.isPerfect=false;
            rt.isComplete=false;
            rt.size=(lv.size>rv.size)?lv.size:rv.size;
            rt.rootTree=(lv.size > rv.size ? lv.rootTree : rv.rootTree);
            return rt;
        }
        return rt;
    }
    private boolean checkIfBalanced(Node root) {
        if(root==null){
            return true;
        }
        boolean b1=checkIfBalanced(root.left);
        boolean b2 = checkIfBalanced(root.right);
        if(b1 && b2 && Math.abs(height(root.left)-height(root.right))<=1) {
            return true;
        }
        return false;
    }

    private int height(Node left) {
        if(left==null){
            return 0;
        }
        return height(left.left)+height(left.right)+1;
    }
}
