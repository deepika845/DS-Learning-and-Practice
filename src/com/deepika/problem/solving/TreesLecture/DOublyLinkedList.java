package com.deepika.problem.solving.TreesLecture;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class DOublyLinkedList {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int dd){
            this.data=dd;
        }
    }
    Node head;
    Node prev;

    public void findDOublyLinkedList(Node curr){
        if (curr==null){
            return ;
        }
         findDOublyLinkedList(curr.left);
        if (prev==null){
            head=curr;
        }
        if(prev!=null){
            prev.right=curr;
            curr.left=prev;
        }
        prev=curr;
        findDOublyLinkedList(curr.right);
    }
    public void printDoubly(){
        Node curr=head;
        while (curr!=null){
            System.out.println(curr.data);
            curr=curr.right;
        }
    }
    public  int findSumTree(Node curr){
        if (curr==null){
            return 0;
        }
        int ts= curr.data;
        curr.data=findSumTree(curr.left)+findSumTree(curr.right);
        return ts+curr.data;
    }
    public Node findBiaryTree(int[] preOrder,int[] inOrder,int preStart,int start,int end){
        if(start>end){
            return null;
        }
        Node tt = new Node(preOrder[preStart]);
        if (start==end){
            return tt;
        }
        int index=search(inOrder,start,end,inOrder[preStart]);
        tt.left=findBiaryTree(preOrder,inOrder,preStart+1,start,index-1);
        tt.right =findBiaryTree(preOrder,inOrder,preStart+1,index+1,end);
        return tt;

    }
    class Pair<T,V>{
        T key;
        V val;
        Pair(T key,V val){
            this.key=key;
            this.val=val;
        }
        public T getKey(){
            return key;
        }
        public V getVal(){
            return val;
        }
    }

    private int search(int[] inOrder, int start, int end, int item) {
        for (int i=start;i<=end;i++){
            if(inOrder[i]==item){
                return i;
            }
        }
        return -1;
    }
    public  void inOrder(int[] inOrder, int n, ArrayList<Integer> arr1, int index){
        if (index>=n){
            return ;
        }
        inOrder(inOrder,n,arr1,2*index+1);
        arr1.add(inOrder[index]);
        inOrder(inOrder,n,arr1,2*index+2);
    }
    public int findMinSwaps(int[] inOrder){
        ArrayList<Integer> inOrderList = new ArrayList<>();
        inOrder(inOrder,inOrder.length,inOrderList,0);
        ArrayList<Pair<Integer,Integer>> track = new ArrayList<>();
        for (int i=0;i<inOrderList.size();i++){
            track.add(new Pair<Integer, Integer>(inOrderList.get(i),i));
        }
        Collections.sort(track, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                return p1.key-p2.key;
            }
        });
        int minSwaps=0;
        boolean[] vis = new boolean[inOrderList.size()];
        //int i=0;
        for (int i=0;i<track.size();i++){
            if (track.get(i).val==i){
                continue;
            }
            int temp=track.get(i).key;
            int f1=track.get(track.get(i).val).key;
            track.get(i).key=track.get(track.get(i).val).key;
            track.get(track.get(i).val).key=temp;
            int temp1=track.get(i).val;
            int f2=track.get(track.get(i).val).val;
            track.get(i).val=f2;
            track.get(track.get(i).val).val=temp1;
            int dd=track.get(i).val;
            if (track.get(i).val!=i){
                i--;
            }
            minSwaps++;
        }
        return minSwaps;
    }

    public static void main(String[] args) {
       DOublyLinkedList ddl = new DOublyLinkedList();
//        Node root= new Node(10);
//        root.left=new Node(12);
//        root.right=new Node(15);
//        root.left.left=new Node(25);
//        root.left.right=new Node(30);
//        root.right.left= new Node(36);
//        ddl.findSumTree(root);
//        ddl.findDOublyLinkedList(root);
//        ddl.printDoubly();
//        int[] inOrder= {2,4,3,1,9};
//        int[] preOrder={4,2,1,3,9};
//        Node root=ddl.findBiaryTree(preOrder,inOrder,0,0,inOrder.length-1);
//        ddl.findDOublyLinkedList(root);
//        ddl.printDoubly();
       ddl.findMinSwaps(new int[]{5, 6, 7, 8, 9, 10, 11 });
    }
}
