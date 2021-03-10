package com.deepika.problem.solving.TreesLecture;


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
        NodeObj root= new NodeObj();
        root.data=1;
        root.hd=0;
        root.left=new NodeObj();
        root.left.data=2;
        root.right=new NodeObj();
        root.right.data=3;
        root.right.right=new NodeObj();
        root.right.right.data=9;
        root.right.left=new NodeObj();
        root.right.left.data=5;
        System.out.println(findBottomView(root));
    }
}
