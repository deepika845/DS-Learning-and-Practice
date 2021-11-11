package com.LeetCode.Trees;
import java.io.*;
import java.util.*;
public class KDistNodes {
    public static class Node {
            int data;
            Node left;
            Node right;

            Node(int data, Node left, Node right) {
                this.data = data;
                this.left = left;
                this.right = right;
            }
        }

        public static class Pair {
            Node node;
            int state;

            Pair(Node node, int state) {
                this.node = node;
                this.state = state;
            }
        }

        public static Node construct(Integer[] arr) {
            Node root = new Node(arr[0], null, null);
            Pair rtp = new Pair(root, 1);

            Stack<Pair> st = new Stack<>();
            st.push(rtp);

            int idx = 0;
            while (st.size() > 0) {
                Pair top = st.peek();
                if (top.state == 1) {
                    idx++;
                    if (arr[idx] != null) {
                        top.node.left = new Node(arr[idx], null, null);
                        Pair lp = new Pair(top.node.left, 1);
                        st.push(lp);
                    } else {
                        top.node.left = null;
                    }

                    top.state++;
                } else if (top.state == 2) {
                    idx++;
                    if (arr[idx] != null) {
                        top.node.right = new Node(arr[idx], null, null);
                        Pair rp = new Pair(top.node.right, 1);
                        st.push(rp);
                    } else {
                        top.node.right = null;
                    }

                    top.state++;
                } else {
                    st.pop();
                }
            }

            return root;
        }

        public static void display(Node node) {
            if (node == null) {
                return;
            }

            String str = "";
            str += node.left == null ? "." : node.left.data + "";
            str += " <- " + node.data + " -> ";
            str += node.right == null ? "." : node.right.data + "";
            System.out.println(str);

            display(node.left);
            display(node.right);
        }
        public static Node find(Node curr,int data){
            if(curr==null){
                return null;
            }
            if(curr.data==data){
                return curr;
            }
            Node c1=find(curr.left,data);
            Node c2=find(curr.right,data);
            return c1==null?c2:c1;
        }
        private static void setParent(Node root, Node parent,HashMap<Node,Node> parents) {
            if(root==null){
                return;
            }
            parents.put(root,parent);
            setParent(root.left,root,parents);
            setParent(root.right,root,parents);
        }
        public static void printKNodesFar(Node node, int data, int k) {
            // write your code here
            Node target=find(node,data);
            if(target==null){
                return;
            }
            HashMap<Node,Node> hm= new HashMap<Node,Node>();
            // hm.put(node,null);
            Set<Node> visited= new HashSet<Node>();
            setParent(node,null,hm);
            Queue<Node> qtq= new LinkedList<Node>();
            qtq.add(target);
            visited.add(target);
            while(!qtq.isEmpty()){
                int size=qtq.size();
                for(int i=0;i<size;i++){
                    Node pop=qtq.remove();

                    if(k==0){
                        System.out.println(pop.data);

                    }
                    if(pop.left!=null && !visited.contains(pop.left))
                    {
                        visited.add(pop.left);
                        qtq.add(pop.left);
                    }
                    if(pop.right!=null && !visited.contains(pop.right))
                    {
                        visited.add(pop.right);
                        qtq.add(pop.right);
                    }
                    if(hm.get(pop)!=null && !visited.contains(hm.get(pop))){
                        visited.add(hm.get(pop));
                        qtq.add(hm.get(pop));
                    }
                }
                k--;
            }

        }

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            Integer[] arr = new Integer[n];
            String[] values = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                if (values[i].equals("n") == false) {
                    arr[i] = Integer.parseInt(values[i]);
                } else {
                    arr[i] = null;
                }
            }

            int data = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());

            Node root = construct(arr);
            printKNodesFar(root, data, k);
        }


}
