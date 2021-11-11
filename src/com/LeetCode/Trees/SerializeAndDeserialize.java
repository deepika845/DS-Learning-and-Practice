package com.LeetCode.Trees;

public class SerializeAndDeserialize
{
    static int index=-1;

    // Encodes a tree to a single string.
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }

    public static String serialize(TreeNode root){
        if(root==null){
            return "null";
        }
        String s ="";
        s+=root.val;
        s=  s+" "+serialize(root.left);
        s=s+" "+serialize(root.right);
        return s;
    }


    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String arr[] = data.split(" ");
        return deserialize(arr);
    }
    public static TreeNode deserialize(String[] data){
        index++;
        if(data[index].equals("null")){
            return null;
        }
        TreeNode curr= new TreeNode(Integer.parseInt(data[index]));
        int c=curr.val;
        curr.left=deserialize(data);
        curr.right=deserialize(data);
        return curr;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(5);
        String s= serialize(root);
        deserialize(s);
    }
}
