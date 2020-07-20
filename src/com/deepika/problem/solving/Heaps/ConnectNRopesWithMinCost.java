package com.deepika.problem.solving.Heaps;

import java.util.*;

public class ConnectNRopesWithMinCost {
    private static Node root;
    static int i ;
    public static int findMinCost(int arr[]){
        if(arr.length==1){
            return arr[0];
        }
        else if(arr.length==2){
            return arr[0]+arr[1];
        }
        PriorityQueue<Integer> pp = new PriorityQueue<Integer>();
        for (int i=0;i<arr.length;i++){
            pp.add(arr[i]);
        }
        int res=0;
        while (pp.size() > 1){
            int first = pp.poll();

            int second = pp.poll();
            res += (first + second);
            pp.add(first + second);
        }
        return res;
    }
    public static int[] mergeKSortedArray(int arr[][]){
        PriorityQueue<ArrayContainer> pp = new PriorityQueue<ArrayContainer>();
        int total = 0;
        for(int i=0;i<arr.length;i++){
            pp.add(new ArrayContainer(arr[i],0));
            total += arr[i].length;
        }
        int index=0;
        int result[] = new int[total];
        while(!pp.isEmpty()){
            ArrayContainer ac = pp.poll();
            result[index++]=ac.arr[ac.index];
            if(ac.index<ac.arr.length-1){
                pp.add(new ArrayContainer(ac.arr,ac.index+1));
            }
        }
        return result;
    }
    public static void inorderTraversal(Node node,Vector<Integer> vv){
        if(node==null){
            return;
        }
        inorderTraversal(node.left,vv);
        vv.add(node.data);
        inorderTraversal(node.right,vv);
    }
    public static void makeMinHeap(Node node,Vector<Integer> vv){
        if(node == null){
            return ;
        }
        node.data= vv.get(i++);
        makeMinHeap(node.left,vv);
        makeMinHeap(node.right,vv);
    }
    public static void returnMinHeap(){
        returnminHeap(root);
    }
    public static void returnminHeap(Node node){
        if(node == null){
            return ;
        }
        else if(node.left==null && node.right == null){
            return ;
        }
        Vector<Integer> vv = new Vector<Integer>();
        inorderTraversal(node,vv);
        makeMinHeap(node,vv);
    }
    class Node{
        int data;
        Node left;
        Node right;
        Node(int dta){
            data=dta;
        }
    }
    public void makeBinarySearchTree(int data){
        root = makeBinarySearchTree(root,data);
    }
    private Node makeBinarySearchTree(Node node,int data){
        if(node == null){
            return new Node(data);
        }
        if(node.data>data) {
            node.left = makeBinarySearchTree(node.left,data);
        }
        else{
            node.right=makeBinarySearchTree(node.right,data);
        }
        return node;
    }
    public static void preOrderTraversal(){
        preOrderTraversal(root);
    }
    public static void preOrderTraversal(Node node){
        if(node == null){
            return;
        }
        preOrderTraversal(node.left);
        System.out.println(node.data);
        preOrderTraversal(node.right);
    }
    public static void main(String[] args) {
//        int arr[] = {4,3,2,6};
//        System.out.println(findMinCost(arr));
//         int arr[] = {1,3,10,11};
//         int arr1[]={12,14,15};
//         int arr2[]={0,2,7,8,9};
//         int result[] = mergeKSortedArray(new int[][]{arr,arr1,arr2});
//         System.out.println(Arrays.toString(result));
         ConnectNRopesWithMinCost cpw = new ConnectNRopesWithMinCost();
         cpw.makeBinarySearchTree(4);
         cpw.makeBinarySearchTree(2);
         cpw.makeBinarySearchTree(6);
         cpw.makeBinarySearchTree(1);
         cpw.makeBinarySearchTree(3);
         cpw.makeBinarySearchTree(5);
         cpw.makeBinarySearchTree(7);
         returnMinHeap();
         preOrderTraversal();

    }

}
class ArrayContainer implements Comparable<ArrayContainer> {
    int arr[];
    int index;
    ArrayContainer(int arr[],int index){
        this.arr=arr;
        this.index=index;
    }
    @Override
    public int compareTo(ArrayContainer o)
    {
        return this.arr[index] - o.arr[o.index];
    }
}
