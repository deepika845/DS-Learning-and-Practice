package com.Revision.Trie;

//import javax.transaction.TransactionRequiredException;
import java.util.HashMap;

public class TrieImplementation{
    TrieNode root;
    class TrieNode{
        HashMap<Character,TrieNode> mapMaintained;
        boolean isWord;
        TrieNode(){
            mapMaintained=new HashMap<>();
            isWord=false;
        }
    }
    public void addNode(String newString){
        if(root==null){
            root=new TrieNode();
        }
        TrieNode curr=root;
        for (int i=0;i<newString.length();i++){
            char ch=newString.charAt(i);
            if (!curr.mapMaintained.containsKey(ch)){
                curr.mapMaintained.put(ch,new TrieNode());
            }
            curr=curr.mapMaintained.get(ch);
        }
        curr.isWord=true;
    }
    public boolean search(String newString){
        TrieNode curr = root;
        for (int i=0;i<newString.length();i++){
            char ch = newString.charAt(i);
            if(curr.mapMaintained.containsKey(ch)){
                curr=curr.mapMaintained.get(ch);
            }
            else {
                return  false;
            }
        }
        return curr.isWord;
    }
    public void delete(String wrd){
        delete(wrd,0,root);
    }

    private boolean delete(String wrd, int index, TrieNode curr) {
        if(wrd.length()==index){
            if(curr.isWord==true){
                curr.isWord=false;
            }
            else {
                return false;
            }
            return curr.mapMaintained.size()==0;
        }
        char ch = wrd.charAt(index);
        TrieNode currNext = curr.mapMaintained.get(ch);
        boolean isEmpty = delete(wrd,index+1,currNext);
        if(isEmpty){
            curr.mapMaintained.remove(ch);
            return curr.mapMaintained.size()==0;
        }
        return false;
     }

    public static void main(String[] args) {
        TrieImplementation dd = new TrieImplementation();
        dd.addNode("acde");
        dd.addNode("acd");
        System.out.println(dd.search("acde"));
        System.out.println(dd.search("acd"));
        dd.delete("acd");
        System.out.println(dd.search("acd"));
    }

}
