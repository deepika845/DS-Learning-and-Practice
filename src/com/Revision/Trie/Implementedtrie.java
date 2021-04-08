package com.Revision.Trie;

import javax.swing.tree.TreeNode;

public class Implementedtrie {
    class Trie{
        Trie[] alphTrack= new Trie[26];
        boolean isEndOfWord= false;
        int freqCount=1;
        Trie(){
            isEndOfWord=false;
//            for (int i=0;i<26;i++){
//                alphTrack[i]=null;
//            }
        }

    }
    Trie root;
    public void insertString(String key){
        Trie curr= root;
        for (int i=0;i<key.length();i++){
            if (root==null){
                curr = root= new Trie();
                root.freqCount=0;
            }
            char ch=key.charAt(i);
            if (curr.alphTrack[key.charAt(i)-'a']==null){

                curr.alphTrack[key.charAt(i)-'a']=new Trie();
            }
            else{
            curr.alphTrack[key.charAt(i)-'a'].freqCount++;}
            if (i!=key.length()-1)
            curr=curr.alphTrack[key.charAt(i)-'a'];
        }
//        for (int i=0;i<curr.alphTrack.length;i++){
//            System.out.print(curr.alphTrack[i]+" ");
//        }
        curr.isEndOfWord=true;

    }
    public  void  findAllPrefixes(Trie curr,String str){
        if (curr.freqCount==1){
            System.out.println(str);
            return;
        }
        for (int i=0;i<curr.alphTrack.length;i++){
            if (curr.alphTrack[i]!=null && curr.alphTrack[i].freqCount>0)
            findAllPrefixes(curr.alphTrack[i],str+(char)(i+'a'));
        }
    }
    public void  findAllPrefixes(){
        findAllPrefixes(root,"");
    }
    public boolean search(String item){
        Trie curr= root;
        for (int i=0;i<item.length();i++){
            if (curr.alphTrack[item.charAt(i)-'a']==null){
                return  false;
            }
            curr=curr.alphTrack[item.charAt(i)-'a'];
        }
        return (curr!=null && curr.isEndOfWord);
    }
    public static void main(String[] args) {
        Implementedtrie imt = new Implementedtrie();
        imt.insertString("zebra");
        imt.insertString("dog");
        imt.insertString("duck");
        imt.insertString("dove");
        imt.findAllPrefixes();

    }
}
