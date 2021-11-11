package com.LeetCode.Trees;

import com.LeetCode.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PathSum {
    public static class TreeNode {
        int val;
        TreeNode left;
       TreeNode right;
        TreeNode(int val) {
            this.val = val;

        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }}
    public List<List<Integer>> hasPathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> curr= new ArrayList<>();
        ArrayList<List<Integer>> allPaths= new ArrayList<>();

         hasPathSum(root,targetSum,root.val,curr,allPaths);
         return allPaths;
    }
    public void hasPathSum(TreeNode curr, int targetSum, int currSum, ArrayList<Integer> currList, ArrayList<List<Integer>> allList){
        if(curr==null){
            return;
        }
        int d= curr.val;
        currList.add(curr.val);

        if(curr.left==null && curr.right==null){
            if(currSum==targetSum) {
               allList.add(new ArrayList<>(currList));
            }
            currList.remove(currList.size()-1);
            return;
        }

        hasPathSum(curr.left,targetSum,currSum+(curr.left==null?0:curr.left.val),currList,allList);
        hasPathSum(curr.right ,targetSum,currSum+(curr.right==null?0:curr.right.val),currList,allList);
        currList.remove(currList.size()-1);
    }
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        Stack<TreeNode> stk= new Stack<TreeNode>();
        TreeNode curr=root;
        TreeNode prev=null;
        stk.push(curr);
        while(!stk.isEmpty()){
            TreeNode poped=stk.pop();
            int f= poped.val;
            if(prev!=null){
                prev.right=poped;

            }
            prev=poped;
            if(poped.right!=null){
                stk.push(poped.right);
            }
            if(poped.left!=null){
                stk.push(poped.left);
            }

        }

    }

    public static void main(String[] args) {
        TreeNode td= new TreeNode(1);
        td.left=new TreeNode(2);
        td.right=new TreeNode(5);
        td.left.left=new TreeNode(3);
        td.left.right=new TreeNode(4);

        td.right.right=new TreeNode(6);

        PathSum ps= new PathSum();
      //  ps.hasPathSum(td,22);
        ps.flatten(td);
    }
}
