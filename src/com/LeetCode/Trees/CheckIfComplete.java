package com.LeetCode.Trees;

public class CheckIfComplete {
     static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
     static class ReturnType{
        boolean isPerfect;
        boolean isComplete;
        int size;
    }
    public static boolean isCompleteTree(TreeNode root) {
        ReturnType mr = checkIfCompleteOrPerfect(root);
        return mr.isComplete||mr.isPerfect;

    }
    public static int getHeight(int size){
        return (int)Math.ceil(Math.log(size+1)/Math.log(2));
    }
    public static ReturnType checkIfCompleteOrPerfect(TreeNode root){
        if(root==null){
            ReturnType bc= new ReturnType();
            bc.isPerfect=true;
            bc.isComplete=true;
            bc.size=0;
            return bc;
        }
        ReturnType mr= new ReturnType();
        ReturnType left= checkIfCompleteOrPerfect(root.left);
        ReturnType right= checkIfCompleteOrPerfect(root.right);
        if(left.isPerfect && right.isComplete && (getHeight(left.size)==getHeight(right.size))){
            mr.isComplete=true;
            mr.isPerfect=(right.isPerfect)?true:false;
            mr.size=(left.size+right.size)+1;
            return mr;
        }
        if(left.isComplete && right.isPerfect && (getHeight(left.size)==getHeight(right.size)+1)){
            mr.isComplete=true;
            mr.isPerfect=true;
            mr.size=left.size+right.size+1;

        }
        mr.isComplete=true;
        mr.isPerfect=true;
        mr.size=Math.max(left.size,right.size);
        return mr;
    }

    public static void main(String[] args) {
        TreeNode root= new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.right=new TreeNode(7);
        isCompleteTree(root);
    }
}
