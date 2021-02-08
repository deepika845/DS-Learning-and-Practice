package com.deepika.problem.solving.GreedyALgorithms;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanEncoding {
    class HuffmanNode{
        char c;
        int val;
        HuffmanNode left;
        HuffmanNode right;
    }
    class  SortComparator implements Comparator<HuffmanNode>{

        @Override
        public int compare(HuffmanNode huffmanNode, HuffmanNode t1) {
            return huffmanNode.val-t1.val;
        }
    }
    public void findEncoding(char[] alph,int[] freq){
        PriorityQueue<HuffmanNode>  q= new PriorityQueue<HuffmanNode>(new SortComparator());
        for(int i=0;i<alph.length;i++){
            HuffmanNode hn= new HuffmanNode();
            hn.c=alph[i];
            hn.val=freq[i];
            q.add(hn);
        }
        HuffmanNode root =null;
        while (q.size()>1){
            HuffmanNode r1= q.poll();
            HuffmanNode r2=q.poll();
            HuffmanNode newNode = new HuffmanNode();
            newNode.c='-';
            newNode.val=r1.val+r2.val;
            newNode.left=r1;
            newNode.right=r2;
            root=newNode;
            q.add(newNode);
        }
        printCC(root,"");

    }

    private void printCC(HuffmanNode root,String s) {
        if(root.left==null && root.right==null && Character.isLetter(root.c)){
            System.out.println(root.c +" : "+s);
            return;
        }
        printCC(root.left,s+"0");
        printCC(root.right,s+"1");
    }

    public static void main(String[] args) {
        HuffmanEncoding he = new HuffmanEncoding();
        he.findEncoding(new char[]{'a','b','c','d','e','f'},new int[]{5,9,12,13,16,45});
    }
}
