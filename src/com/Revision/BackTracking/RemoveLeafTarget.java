package com.Revision.BackTracking;


import javax.sound.midi.Soundbank;

public class RemoveLeafTarget {
   static class Node {
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
        Node(int val,Node left,Node right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    public static Node removeLeaves(Node root, int target){
        if(root==null){
            return  null;
        }
         root.left=removeLeaves(root.left,target);
         root.right=removeLeaves(root.right,target);
        if (root.left==null &&root.right==null &&root.val==target){
            return null;
        }
        return root;
    }
    public static void preOrder(Node root){
       if(root==null){
           return;
       }
        System.out.println(root.val);
       preOrder(root.left);
       preOrder(root.right);

    }
    public  static  int maxProduct(int[] nums){
        int maxProduct=nums[0];
        int minProduct=nums[0];
        int res=maxProduct;
        for(int i=1;i<nums.length;i++){
            int bcMax=maxProduct;
            int bcMin=minProduct;
            maxProduct=Math.max(bcMax*nums[i],bcMax*nums[i]);
            maxProduct=Math.max(maxProduct,nums[i]);
            minProduct=Math.min(bcMin*nums[i],bcMin*nums[i]);
            minProduct=Math.min(minProduct,nums[i]);
            res=Math.max(res,maxProduct);

        }
        return res;
    }
    public static void main(String[] args) {
       /* Node lflf=  new Node(2);
        Node rtlf=  new Node(2);
        Node rtrt=  new Node(4);
        Node lf=  new Node(2,lflf,null);
        Node rt=  new Node(3,rtlf,rtrt);
        Node root=  new Node(1,lf,rt);
        removeLeaves(root,2);
        preOrder(root);*/
        System.out.println(maxProduct(new int[]{2,3,-2,4}));

    }
}
