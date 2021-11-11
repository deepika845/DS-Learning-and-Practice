package com.LeetCode.Trees;

public class Diameter {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
    public static int height(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        int left=diameterOfBinaryTree(root.left);
        int right=diameterOfBinaryTree(root.right);

        int heights=height(root.left)+height(root.right)+1;
        return Math.max(Math.max(left,right),heights);

    }

    public static void main(String[] args) {
        TreeNode root= new TreeNode(1);
//        root.left=new TreeNode(2);
//        root.right=new TreeNode(3);
//        root.left.left=new TreeNode(4);
//        root.left.right=new TreeNode(5);
        diameterOfBinaryTree(root);
    }
}
