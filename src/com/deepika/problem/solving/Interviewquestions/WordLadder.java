package com.deepika.problem.solving.Interviewquestions;

import java.util.*;

public class WordLadder {
    public static int findMinPath(String start, String dest, List<String> dict){
        if (!dict.contains(dest)){
            return 0;
        }
        int currLen = 1;
        HashMap<String,Boolean> wordMap = new HashMap<String, Boolean>();
        for (int i=0 ;i<dict.size();i++){
            wordMap.put(dict.get(i),false);
        }
        Queue<String> wordQueue = new LinkedList<String>();
        wordQueue.add(start);
        wordMap.put(start,true);
        while (!wordQueue.isEmpty()){
            int size = wordQueue.size();
            for (int i=0 ; i<size;i++){
                String kk = wordQueue.poll();
                if(kk.equals(dest)){
                    return currLen;
                }
                wordMatch(kk,wordMap,wordQueue);
            }
            currLen++;
        }
        return currLen;
    }

    private static void wordMatch(String kk, HashMap<String, Boolean> wordMap, Queue<String> wordQueue) {
        for (int i =0 ;i<kk.length();i++){
            char ch[] = kk.toCharArray();
            for (int j=0;j<26;j++){
                ch[i]=(char)('a'+j);
                String word = String.valueOf(ch);
                if(wordMap.containsKey(word) && wordMap.get(word) == false){
                    wordQueue.add(word);
                    wordMap.put(word,true);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<String>();
        dict.add("toon");
        dict.add("loon");
        dict.add("poon");
        dict.add("poin");
        dict.add("poie");
        dict.add("plie");
        dict.add("plee");
        dict.add("plea");
      findMinPath("toon","plea",dict);

    }
}
