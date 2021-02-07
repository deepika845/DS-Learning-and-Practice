package com.deepika.problem.solving.TreesLecture;

class HeightBalancedTree {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val){
            this.val=val;
        }
    }
    TreeNode root;
    public TreeNode sortedArrayToBST(int[] nums) {
        for(int i=0;i<nums.length;i++){
            root=insertToAvl(root,nums[i]);
        }
        return root;

    }
    public int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        else if(root.left==null && root.right==null){
            return 1;
        }
        else{
            return Math.max(getHeight(root.left),getHeight(root.right))+1;
        }
    }
    public TreeNode insertToAvl(TreeNode root,int key){
        if(root==null){
            return new TreeNode(key);
        }
        if(root.val>key){
            root.left=insertToAvl(root.left,key);
        }
        else if(root.val < key){
            root.right=insertToAvl(root.right,key);
        }
        int diff = getHeight(root.left)-getHeight(root.right);
        if(diff>1){
            if(getHeight(root.left.left)>=getHeight(root.left.right)){
                root = rotateRight(root);
            }
            else{
                root.left=rotateLeft(root.left);
                root=rotateRight(root);
            }
        }
        else if(diff<-1){
            if(getHeight(root.right.right)>=getHeight(root.right.left)){
                root=rotateLeft(root);
            }
            else{
                root.right=rotateRight(root.right);
                root=rotateRight(root);
            }
        }
        return root;
    }
    public TreeNode rotateRight(TreeNode root){
        TreeNode newNode =root.left;
        root.left=newNode.right;
        newNode.right=root;
        root=newNode;
        return root;

    }
    public TreeNode rotateLeft(TreeNode root){
        TreeNode newNode = root.right;
        root.right=newNode.left;
        newNode.left=root;
        root=newNode;
        return root;
    }

    public static void main(String[] args) {
        HeightBalancedTree hbt = new HeightBalancedTree();
        hbt.sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }
}