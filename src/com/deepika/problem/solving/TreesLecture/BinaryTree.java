package com.deepika.problem.solving.TreesLecture;


public class BinaryTree {
    Node root;
    class Node{
        char data;
        Node left;
        Node right;
        Node(char data){
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
        bt.root=bt.new Node('A');
        bt.root.left=bt.new Node('B');
        bt.root.right=bt.new Node('B');
      //  bt.root.right=bt.new Node('I');
        //bt.root.left.left=bt.new Node('C');
        //bt.root.left.left.left=bt.new Node('D');
        //bt.root.left.left.right=bt.new Node('E');
        bt.root.left.right=bt.new Node('C');
        //bt.root.left.right.right=bt.new Node('G');
        //bt.root.left.right.right.left=bt.new Node('H');
        bt.root.right.left=bt.new Node('C');
       // bt.root.right.right=bt.new Node('D');
        //bt.root.right.right.right=bt.new Node('P');
       // bt.root.right.left.left=bt.new Node('E');
        //bt.root.right.left.right.left=bt.new Node('L');
        //bt.root.right.left.right.right=bt.new Node('N');
        //bt.root.right.left.right.left.right=bt.new Node('M');
        //System.out.println(bt.checkIfBalanced(bt.root));
      //  System.out.println(bt.isComplete(bt.root).size);
        //System.out.println(rss.size);
        //System.out.println(isBalanced);
        //bt.findKthSymmetric(bt.root,3);
        System.out.println( bt.isSymmetric(bt.root));
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
    public boolean isSymmetric(Node node){
        if(node==null){
            return true;
        }
        return isSymmetric(node.left,node.right);
    }
    public boolean isSymmetric(Node left,Node right){
        if(left==null && right==null){
            return true;
        }
        if(left==null || right==null){
            return false;
        }
        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left) && (left.data==right.data);
    }
    public int count(Node node){
        if(node==null){
            return 0;
        }
        if(node.left==null && node.right==null){
            return 1;
        }
        return count(node.left)+count(node.right)+1;
    }
    public Node findKthSymmetric(Node root, int k){
        if(root == null){
            return null;
        }
        char sss=root.data;
        if(root.left==null && root.right==null){
            return root;
        }
        Node node1=findKthSymmetric(root.left,k);
        Node node2=findKthSymmetric(root.right,k);
        if(Math.abs(count(root.left)-count(root.right))<=3 && (node1!=null || node2!=null)){
            return root;
        }
        System.out.println(root.data);
        return null;
    }

    private int height(Node left) {
        if(left==null){
            return 0;
        }
        return height(left.left)+height(left.right)+1;
    }
}
