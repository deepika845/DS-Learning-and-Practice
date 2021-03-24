package com.deepika.problem.solving.Stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class InorderStack {
   static   class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;

      TreeNode(int val) { this.val = val; }
  }
    public static List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stackMaintained= new Stack<TreeNode>();
        List<Integer> inorder = new ArrayList<Integer>();
        TreeNode curr= root;
        while(curr!=null || !stackMaintained.isEmpty()){
            //stackMaintained.push(curr);
            while(curr!=null){
                stackMaintained.push(curr);
                curr=curr.left;
            }
            TreeNode poped=stackMaintained.pop();
            inorder.add(poped.val);
            curr=poped.right;
        }
        return inorder;
    } public static List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stackMaintained= new Stack<TreeNode>();
        List<Integer> inorder = new ArrayList<Integer>();
        TreeNode curr= root;
        while(curr!=null || !stackMaintained.isEmpty()){
            //stackMaintained.push(curr);
            while(curr!=null){
                stackMaintained.push(curr);
                curr=curr.right;
            }
            TreeNode poped=stackMaintained.peek();
            curr=poped.left;
            stackMaintained.push(curr);
            TreeNode poped1=stackMaintained.pop();
            inorder.add(poped1.val);}
        return inorder;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);
        preorderTraversal(root);



    }
}
