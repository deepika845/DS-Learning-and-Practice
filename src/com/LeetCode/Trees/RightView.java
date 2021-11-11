package com.LeetCode.Trees;

import java.util.ArrayList;
import java.util.List;

public class RightView {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
    static int maxLevel=0;
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView= new ArrayList<Integer>();
        rightSideView(root,1,rightView);
        return rightView;
    }
    public static void rightSideView(TreeNode root, int level,List<Integer> arr){
        if(root==null){
            return;
        }
        if(maxLevel<level){
            arr.add(root.val);
            maxLevel=level;

        }
        rightSideView(root.right,level+1,arr);
        rightSideView(root.left,level+1,arr);
    }

    public static void main(String[] args) {
        TreeNode root= new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.right.right=new TreeNode(5);
        rightSideView(root);

    }
}
