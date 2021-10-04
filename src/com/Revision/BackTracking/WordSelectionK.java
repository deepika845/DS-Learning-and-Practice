package com.Revision.BackTracking;
import java.io.*;
import java.util.*;

public class WordSelectionK {
//    public static void selection(int start, String ustr, HashMap<Character,Integer> hm,String asf,int c, int k){
//        if(start==ustr.length()){
//            if(c==k){
//                System.out.println(asf);
//
//            }
//            return;
//        }
//        char ch = ustr.charAt(start);
//        if(hm.get(ch)>0){
//        for(int i=hm.get(ch);i>=0;i--){
//            String add="";
//            for(int j=0;j<i;j++){
//                add=add+ch;
//            }
//            hm.put(ch,hm.get(ch)-i);
//            selection(start+1,ustr,hm,asf+add,c+i,k);
//            hm.put(ch,hm.get(ch)+i);
//        }
//        }
//       // selection(start+1,ustr,hm,asf,c,k);
//
//
//
//
//    }
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();
//        int k = Integer.parseInt(br.readLine());
//
//        HashMap<Character, Integer> unique = new HashMap<>();
//        String ustr = "";
//        for (char ch : str.toCharArray()) {
//            if (unique.containsKey(ch) == false) {
//                unique.put(ch, 1);
//                ustr += ch;
//            } else {
//                unique.put(ch, unique.get(ch) + 1);
//            }
//        }
//        selection(0,ustr,unique,"",0,k);
//
//
//    }
public static void selection(int lcui, String ustr, HashMap<Character,Integer> hm, Character[] slots,int start){
    if(start==slots.length){
        for(int i=0;i<slots.length;i++){
            System.out.print(slots[i]);
        }
        System.out.println();
        return;
    }
    if(lcui>=ustr.length()){
        return;
    }
    char ch=ustr.charAt(lcui);
    if(hm.get(ch)>=1){
        slots[start]=ch;
        hm.put(ch,hm.get(ch)-1);
        selection(lcui,ustr,hm,slots,start+1);
        slots[start]=null;
        hm.put(ch,hm.get(ch)+1);
    }

        selection(lcui+1,ustr,hm,slots,start);


}

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashMap<Character, Integer> unique = new HashMap<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.containsKey(ch) == false) {
                unique.put(ch, 1);
                ustr += ch;
            } else {
                unique.put(ch, unique.get(ch) + 1);
            }
        }
        Character slots[]= new Character[k];
        selection(0,ustr,unique,slots,0);


    }
}
