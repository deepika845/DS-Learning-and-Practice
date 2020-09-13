package com.deepika.problem.solving.Stacks;

import java.util.Deque;
import java.util.LinkedList;

public class CheckBrackets {
    public static boolean checkIfBalanced(String str){
        Deque<Character> dqu=new LinkedList<Character>();
        for (int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='(' || ch== '{' || ch=='['){
                dqu.addFirst(ch);
            }
            else{
                if(dqu.isEmpty()){
                    return false;
                }
                if((ch=='}' && dqu.peekFirst()!='{')||(ch==')' && dqu.peekFirst()!='(')||(ch==']' && dqu.peekFirst()!='[')){
                    return false;
                }
                dqu.removeFirst();
            }
        }
        return dqu.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(checkIfBalanced("()]"));

    }
}
