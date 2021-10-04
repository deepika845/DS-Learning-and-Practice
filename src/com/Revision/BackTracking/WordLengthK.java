package com.Revision.BackTracking;
import java.io.*;
import java.util.*;

    public class WordLengthK {
        public static void permute(int i, int len,String ustr, Character slots[],int j, int k){
            if(i==len)
            {
                if(j==k){
                    for(int st=0;st<slots.length;st++){
                        System.out.print(slots[st]);
                    }
                    System.out.println();
                }
                return;
            }
            char ch = ustr.charAt(i);
            for(int st=0;st<slots.length;st++){
                if(slots[st]==null){
                    slots[st]=ch;
                    permute(i+1,len,ustr,slots,j+1,k);
                    slots[st]=null;
                }
            }
        }
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());

            HashSet<Character> unique = new HashSet<>();
            String ustr = "";
            for (char ch : str.toCharArray()) {
                if (unique.contains(ch) == false) {
                    unique.add(ch);
                    ustr += ch;
                }
            }
            Character[] slots= new Character[k];
            permute(0,ustr.length(),ustr,slots,0,k);



        }
    }
//
//}
