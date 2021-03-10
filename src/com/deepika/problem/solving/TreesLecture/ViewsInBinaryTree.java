package com.deepika.problem.solving.TreesLecture;


import java.net.Inet4Address;
import java.util.*;

public class ViewsInBinaryTree {

    static class NodeObj{
        int data;
        int hd;
        NodeObj left;
        NodeObj right;
    }
    public static ArrayList<Integer> findBottomView(NodeObj root){
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null)
        {
            return res;
        }
        Queue<NodeObj> qtQue= new LinkedList<>();
        Map<Integer, Integer> hm = new TreeMap<>();
        qtQue.add(root);
        while (!qtQue.isEmpty()){
            NodeObj popped = qtQue.remove();
            hm.put(popped.hd,popped.data);
            if(popped.left!=null){
                popped.left.hd=popped.hd-1;
                qtQue.add(popped.left);
            }
            if(popped.right!=null){
                popped.right.hd=popped.hd+1;
                qtQue.add(popped.right);
            }
        }
        for (int x:hm.values()){
            res.add(x);
        }
        return res;
    }

    public static void main(String[] args) {
//        NodeObj root= new NodeObj();
//        root.data=1;
//        root.hd=0;
//        root.left=new NodeObj();
//        root.left.data=2;
//        root.right=new NodeObj();
//        root.right.data=3;
//        root.right.right=new NodeObj();
//        root.right.right.data=9;
//        root.right.left=new NodeObj();
//        root.right.left.data=5;
//        System.out.println(findBottomView(root));
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left= new Node(4);
//        root.right.right=new Node(5);
       // System.out.println(zigZagTraversal(root));
        //diagonalTraversal(root);
        printPreOrder("4(2(3)(1))(6(5))");

    }
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    public static ArrayList<Integer> zigZagTraversal(Node root){
        ArrayList<Integer> findZigZag = new ArrayList<>();
        Stack<Node> currLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();
        currLevel.add(root);
        boolean leftToRight = false;
        while (!currLevel.isEmpty()){
            Node popped = currLevel.pop();
            findZigZag.add(popped.data);
            if(leftToRight){
                if(popped.right!=null){
                    nextLevel.add(popped.right);
                }
                if(popped.left!=null){
                    nextLevel.add(popped.left);
                }
            }
            else {
                if(popped.left!=null){
                    nextLevel.add(popped.left);
                }
                if(popped.right!=null){
                    nextLevel.add(popped.right);
                }
            }
            if(currLevel.isEmpty()){
                Stack<Node> temp=currLevel;
                currLevel=nextLevel;
                nextLevel=temp;
            }

        }
        return findZigZag;
    }
    public static void diagonalTraversal(Node root,int d,Map<Integer,ArrayList<Integer>> hm ){
        if(root==null){
            return;
        }
        if (!hm.containsKey(d)){
            ArrayList<Integer> vt= new ArrayList<>();
            vt.add(root.data);
            hm.put(d,vt);
        }
       else {
            hm.get(d).add(root.data);
        }
        diagonalTraversal(root.right,d,hm);
       diagonalTraversal(root.left,d+1,hm);
    }
    public static void diagonalTraversal(Node root){
        Map<Integer,ArrayList<Integer>> hm = new TreeMap<>();
        diagonalTraversal(root,0,hm);
        for (ArrayList<Integer> att: hm.values()){
            System.out.println(att);
        }

    }
    public static int findIndex(String s, int si,int ei){
        Stack<Character> sit = new Stack<>();
        for (int i=si;i<=ei;i++){
            if(s.charAt(i)=='('){
                sit.push('(');
            }
            else if(s.charAt(i)==')'){
                char ct= sit.peek();
                if (ct=='('){
                    sit.pop();
                    if (sit.isEmpty()){
                        return i;
                    }
                }
            }
        }
        return -1;
    }
    public static void printPreOrder(String s){
        Node root = findTreeFromBracketExpression(s,0,s.length()-1);
        preOrder(root);

    }
    public static void preOrder(Node nn){
        if (nn==null){
            return;
        }
        preOrder(nn.left);
        System.out.print(nn.data+" ");
        preOrder(nn.right);
    }
    public static Node findTreeFromBracketExpression(String s, int si,int ei){
        if(si>ei){
            return null;
        }
        Node root =new Node(s.charAt(si)-'0');
        int index=-1;
        if(si+1<=ei && s.charAt(si+1)=='('){
            index =findIndex(s,si,ei);
        }
        if (index!=-1){
            root.left=findTreeFromBracketExpression(s,si+2,index-1);
            root.right=findTreeFromBracketExpression(s,index+2,ei-1);
        }
        return root;
    }
}
