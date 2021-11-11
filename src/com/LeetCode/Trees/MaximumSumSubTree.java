package com.LeetCode.Trees;
import java.io.*;
import java.util.*;

public class MaximumSumSubTree {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }
    static int maxSum=Integer.MIN_VALUE;
    static int node1=-1;
    public static int maxSumBranch(Node curr){
        if(curr==null){
            return 0;
        }
        int numToReturn = curr.data;
        for(Node child:curr.children){
            int br= maxSumBranch(child);
            numToReturn+=br;
        }
        if(numToReturn>maxSum){
            maxSum=Math.max(maxSum,numToReturn);
            node1=curr.data;
        }
        return numToReturn;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        // write your code here
        maxSumBranch(root);
        System.out.println(node1+"@"+maxSum);
    }

}
