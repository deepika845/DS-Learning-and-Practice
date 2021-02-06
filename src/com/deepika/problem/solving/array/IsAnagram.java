package com.deepika.problem.solving.array;

class IsAnagram {
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int freqArray[]=new int[26];
        for(int i=0;i<s.length();i++){
            freqArray[s.charAt(i)-'a']++;
            freqArray[t.charAt(i)-'a']--;
        }
        for(int i : freqArray){
            if(i!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("magaran","anamgran"));
    }
}