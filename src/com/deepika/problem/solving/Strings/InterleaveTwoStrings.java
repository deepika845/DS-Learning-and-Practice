package com.deepika.problem.solving.Strings;

public class InterleaveTwoStrings {

        public static String countAndSay(int n) {
            String res= Integer.toString(n);
            int index=1;
            String res1="";
            for(int i=0;i<res.length();i++){
                if(i==0){
                    continue;
                }
                if(res.charAt(i-1)==res.charAt(i)){
                    index++;
                }
                else{
                    res1+=index;
                    res1+=res.charAt(i-1);
                }
            }
            res1+=index;
            //char ch=res.charAt(res.length()-1);
            res1+=res.charAt(res.length()-1);
            return res1;


        }

    public static boolean isInterleavingString(String first,String second,String result){
        boolean[][] isInterleaving= new boolean[first.length()+1][second.length()+1];
        for (int i=0;i<=first.length();i++){
            for (int j=0;j<=second.length();j++){
                if (i==0 && j==0){
                    isInterleaving[i][j]=true;
                }
                else if (j==0){
                    if (first.charAt(i-1)==result.charAt(i-1)){
                        isInterleaving[i][j]=isInterleaving[i-1][j];
                    }
                }
                else if (i==0){
                    if (second.charAt(j-1)==result.charAt(j-1)){
                        isInterleaving[i][j]=isInterleaving[i][j-1];
                    }
                }
                else if (first.charAt(i-1)==result.charAt(i+j-1) && second.charAt(j-1)!=result.charAt(i+j-1)){
                    isInterleaving[i][j]=isInterleaving[i-1][j];
                }
                else if (first.charAt(i-1)!=result.charAt(i+j-1) && second.charAt(j-1)==result.charAt(i+j-1)){
                    isInterleaving[i][j]=isInterleaving[i][j-1];
                }
                else if (first.charAt(i-1)==result.charAt(i+j-1) && second.charAt(j-1)==result.charAt(i+j-1)){
                    isInterleaving[i][j]=isInterleaving[i-1][j]||isInterleaving[i][j-1];

                }
            }
        }
        return isInterleaving[first.length()][second.length()];
    }
    public static void main(String[] args) {
       // System.out.println(isInterleavingString("XXY", "XXZ", "XXXXZY"));
        System.out.println( countAndSay(1));

    }
}
/*
 test("XXY", "XXZ", "XXZXXXY");
    test("XY", "WZ", "WZXY");
    test("XY", "X", "XXY");
    test("YX", "X", "XXY");
    test("XXY", "XXZ", "XXXXZY");
 */