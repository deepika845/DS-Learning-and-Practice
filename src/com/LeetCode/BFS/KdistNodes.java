package com.LeetCode.BFS;

import java.util.*;

public class KdistNodes {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
    static HashMap<TreeNode,TreeNode> parents=new HashMap<>();
    public static List<Integer> getKDistNodes(TreeNode root, TreeNode target,int k){
        setParent(root,null);
        Queue<TreeNode> treeNodes= new LinkedList<>();
        treeNodes.add(target);
            Set<TreeNode> visited= new HashSet<>();
        visited.add(target);
        List<Integer> result= new ArrayList<>();
        while (!treeNodes.isEmpty()){
            int size=treeNodes.size();

            for(int i=0;i<size;i++){
                TreeNode popped= treeNodes.remove();
                if(k==0){
                    result.add(popped.val);
                }
            if(popped.left!=null&&!visited.contains(popped.left)){
            treeNodes.add(popped.left);
            visited.add(popped.left);
            }
            if(popped.right!=null&&!visited.contains(popped.right)){
                treeNodes.add(popped.right);
                visited.add(popped.right);

            }
            if (parents.get(popped)!=null && !visited.contains(parents.get(popped))){
                treeNodes.add(parents.get(popped));
                visited.add(parents.get(popped));
            }


        }
            k--;
        }
        return result;

    }

    private static void setParent(TreeNode root, TreeNode parent) {
        if(root==null){
            return;
        }
        parents.put(root,parent);
        setParent(root.left,root);
        setParent(root.right,root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(5);
        root.right=new TreeNode(1);
        root.left.left=new TreeNode(6);
        root.left.right=new TreeNode(2);
        root.right.left=new TreeNode(0);
        root.right.right=new TreeNode(8);
        root.left.right.left=new TreeNode(7);
        root.left.right.right=new TreeNode(4);
        System.out.println( getKDistNodes(root,root.left,2));

    }
}
