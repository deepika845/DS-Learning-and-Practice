package com.deepika.problem.solving.TreesLecture;

//import org.graalvm.compiler.phases.common.inlining.InliningPhase_OptionDescriptors;

import javax.crypto.spec.PSource;
import java.util.Scanner;

public class LcaPredictor {
    Node root;
    class Node{
        int ch;
        Node left;
        Node right;
        Node(int ch){
            this.ch=ch;
        }
    }
    public void insert(){
        Scanner s = new Scanner(System.in);
        root =insert(s,null,null);
    }
    public Node insert(Scanner s, Node root,Node parent){
        if(root==null){
            if(parent!=null) {
                System.out.println("Insert ?" + parent.ch);
            }
            String k=s.next();
            if(k.equals("yes")){
                System.out.println("Enter data");
                int ch = s.nextInt();
                root= new Node(ch);}
           else {
               return null;
            }
        }
//        System.out.println("INSERT ?");
//        String dec=s.next();
//        if(dec.equals("yes")){
//            System.out.println("Enter direction : ");
//            String dir = s.next();
//            System.out.println("Enter data : ");
//            char x = s.next().charAt(0);
        root.left=insert(s,null,root);
        root.right=insert(s,null,root);
       // char ff =root.ch;
        return root;
    }
//    public char findLCA(char ch1,char ch2){
//        return findLCA(ch1,ch2,this.root).ch;
//    }
//    public Node findLCA(char ch1,char ch2,Node root){
//        if(root==null){
//            return null;
//        }
//        Node left=findLCA(ch1,ch2,root.left);
//        if(left!=null && (root.ch==ch1 || root.ch==ch2)){
//            return root;
//        }
//        Node right = findLCA(ch1,ch2,root.right);
//        if(right!=null && (root.ch==ch1 || root.ch==ch2)){
//            return root;
//        }
//        if(root.ch==ch1 || root.ch==ch2){
//            return root;
//        }
//        if(left!=null && right!=null){
//            return root;
//        }
//        if(left!=null){
//            return left;
//        }
//        if(right!=null){
//            return right;
//        }
//        return null;
//    }
    public void printArray(Node f){
        if(f==null){
            return;
        }
        printArray(f.left);
        System.out.println(f.ch);
        printArray(f.right);
    }
    public static void main(String[] args) {
        LcaPredictor ll = new LcaPredictor();
        ll.insert();
        //ll.printArray(ll.root);
        //System.out.println(ll.root.ch);
     // System.out.println( ll.findLCA('A','E'));
      //  System.out.println( ll.findRootToLeaf());
        System.out.println(ll.checkPathWithSpecifiedSum(11));
    }
    public int findRootToLeaf(){
        return findRootToLeaf(root,0);
    }
    public int findRootToLeaf(Node j,int sum){
        sum=(sum*2) + j.ch;
        if(j.left==null && j.right==null){
            return sum;
        }
          sum=findRootToLeaf(j.left,sum)+findRootToLeaf(j.right,sum);
       // System.out.println(sum);
        return sum;

    }
    public boolean checkPathWithSpecifiedSum(int sum){
        if(root==null){
            return false;
        }
        return checkPathWithSpecifiedSum(root,sum);
    }
    public boolean checkPathWithSpecifiedSum(Node node,int sum){
        if(node==null &&  sum==0){
            return true;
        }
        if(sum!=0 && node==null){
            return false;
        }
        return checkPathWithSpecifiedSum(node.left,sum-node.ch) || checkPathWithSpecifiedSum(node.right,sum-node.ch);
    }

}
//       yes A yes C n n yes F yes D n n yes E n n




       //yes 1 yes 0 yes 1 n m yes 0 no no yes 0 yes 1 0 0 yes 0 n n
