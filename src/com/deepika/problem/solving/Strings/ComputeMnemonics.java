package com.deepika.problem.solving.Strings;

public class ComputeMnemonics {
    public static void main(String[] args)
    {
        computeAllmnemonics("9","");
        strStr("ababbabaabbabac","abbabac");
    }

    private static void computeAllmnemonics(String unprocessed,String processed ) {
        if(unprocessed.length()==0){
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        unprocessed=unprocessed.substring(1);
        int digit = ch-'0';
        for (int i=3*(digit-1);i<3*digit;i++){
            if(i==26){
                continue;
            }
            computeAllmnemonics(unprocessed,processed+(char)(i+'a'));
        }
    }
    public static int strStr(String haystack, String needle) {
        int lps[]  = findList(needle.toCharArray());
        int i=0;
        int j=0;
        int kg=0;
        char[] a1=haystack.toCharArray();
        char[] a2 = needle.toCharArray();
        while(i<a1.length && j<a2.length){
            if(a1[i]==a2[j]){
                i++;
                j++;
            }
            else{
                if(j!=0)
                    j=lps[j-1];
                else
                    i++;
            }

        }
        if(j==needle.length()){
            return i-j;
        }
        return -1;
    }
    public static int[] findList(char[] arr){
        int i=0;

        int[] lps = new int[arr.length];
        for(int j=1;j<arr.length;){
            if(arr[i]==arr[j]){
                lps[j]=i+1;
                i++;
                j++;
            }
            else{
                if(i!=0){
                    i=lps[i-1];

                }
                else{
                    j++;
                }
            }
        }
        return lps;
    }

}
