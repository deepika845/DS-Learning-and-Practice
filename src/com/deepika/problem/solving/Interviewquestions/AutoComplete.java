package com.deepika.problem.solving.Interviewquestions;

import java.util.HashSet;
import java.util.Set;

public class AutoComplete {
    static class Trie{
        Trie[] children = new Trie[26];
        boolean isWord;
    }
    private Set<String> buildTrie(String[] words,String prefix)
    {
        Trie root = new Trie();
        for (String word : words) {
            Trie current = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new Trie();
                }
                current = current.children[index];
            }
            current.isWord = true;
        }
        Trie node = search(root,prefix);
        Set<String> allCompletes = new HashSet<String>();
        if (node==null){
            return allCompletes;
        }
        findPrefix(node,prefix,allCompletes);
        return allCompletes;
    }
    private Trie search(Trie node,String prefix) {
        Trie curr = node;
        for (char c : prefix.toCharArray()){
            if(curr.children[c-'a']==null){
                return null;
            }
            else {
                curr=curr.children[c-'a'];
            }

        }
        return curr;
    }

    public void findPrefix(Trie node, String prefix, Set<String> allAutoCorrect){
        if(node.isWord){
            allAutoCorrect.add(prefix);

        }
        for (int i=0;i<26;i++){
            if(node.children[i]!=null){
                findPrefix(node.children[i],prefix + (char)(i+'a'),allAutoCorrect);
            }
        }

    }

    public static void main(String[] args) {
        AutoComplete kk = new AutoComplete();
        String[] dict = {"abc", "acd", "bcd", "def", "a", "aba"};
        System.out.println(kk.buildTrie(dict,"a"));

    }
}
