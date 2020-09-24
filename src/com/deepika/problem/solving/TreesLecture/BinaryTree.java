package com.deepika.problem.solving.TreesLecture;
import java.util.Scanner;
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
    class Status
    {
        int numTarget;
        Node ancestor;
        Status(int numTarget,Node ancestor){
            this.numTarget=numTarget;
            ancestor=ancestor;
        }
    }
    public void insert(){
        Scanner s = new Scanner(System.in);
        root =insert(s,null);
    }
    public Node insert(Scanner s,Node root){
        if(root==null){
            System.out.println("Insert ?");
            String k=s.next();
            if(k.equals("yes")){
            System.out.println("Enter data");
            char ch = s.next().charAt(0);
            root= new Node(ch);}
            else{
                return root;
            }
        }
//        System.out.println("INSERT ?");
//        String dec=s.next();
//        if(dec.equals("yes")){
//            System.out.println("Enter direction : ");
//            String dir = s.next();
//            System.out.println("Enter data : ");
//            char x = s.next().charAt(0);
                root.left=insert(s,null);
                root.right=insert(s,null);
                return root;
    }

    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();
        //System.out.println( bt.isSymmetric(bt.root));
       bt.insert();
       // bt.printArray(bt.root);
        bt.findLCA('D','E');
    }
    public char findLCA(char c1,char c2){
        return findLCA(c1,c2,root).ancestor.data;
    }
    public Status findLCA(char nodeLeft,char nodeRight,Node curr){
        if(curr==null)
        {return new Status(0,null);}
        Status leftStatus=findLCA(nodeLeft,nodeRight,curr.left);
        if(leftStatus.numTarget==2){
            return leftStatus;
        }
        Status rightStatus = findLCA(nodeLeft,nodeRight,curr.right);
        if(rightStatus.numTarget==2){
            return rightStatus;
        }
        int numTarget = leftStatus.numTarget+rightStatus.numTarget+(curr.data==nodeLeft?1:0)+(curr.data==nodeRight?1:0);
        return new Status(numTarget,(numTarget==2?curr:null));
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
    public void printArray(Node f){
        if(f==null){
            return;
        }
        printArray(f.left);
        System.out.println(f.data);
        printArray(f.right);
    }
}
