package com.LeetCode.Trees;

import java.util.Scanner;

public class PreAndInorder {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static int findIndex(int val,int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==val){
                return i;
            }
        }
        return -1;
    }
    public static TreeNode buildTree(int[] preorder,int[] inorder,int start,int end,int startPre){
        if(startPre>=preorder.length){
            return null;
        }
        if(start>end){
            return null;
        }
        if(start==end){
            return new TreeNode(preorder[startPre]);
        }
        int index=findIndex(preorder[startPre],inorder);
        TreeNode currNode= new TreeNode(preorder[startPre]);
        currNode.left=buildTree(preorder,inorder,start,index-1,startPre+1);
        currNode.right=buildTree(preorder,inorder,index+1,end,startPre+index-start+1);
        return currNode;
    }
    public static TreeNode buildTreePost(int[] postorder,int[] inorder,int start,int end,int lastPost){
        if(lastPost<0){
            return null;
        }
        if(start>end){
            return null;
        }
        if(start==end){
            return new TreeNode(postorder[lastPost]);
        }
        int index=findIndex(postorder[lastPost],inorder);
        TreeNode currNode= new TreeNode(postorder[lastPost]);
        currNode.left=buildTreePost(postorder,inorder,start,index-1,lastPost-(end-index+1));

        currNode.right=buildTreePost(postorder,inorder,index+1,end,lastPost-1);
        return currNode;
    }


    public static TreeNode buildTreePost(int[] postorder, int[] inorder) {
        return buildTreePost(postorder,inorder,0,postorder.length-1,postorder.length-1);
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,0,preorder.length-1,0);
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTreePost(pre, in);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}