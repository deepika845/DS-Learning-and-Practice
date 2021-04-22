package com.Revision.StackRevision;

import java.util.Stack;

public class ParenthesisChecker {
    public static boolean checkIfValid(String s){
        if (s.length()==0){
            return true;
        }
        Stack<Character> stkMaintained= new Stack<>();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                stkMaintained.push(s.charAt(i));
                continue;
            }
            if (Character.isDigit(s.charAt(i))||Character.isLetter(s.charAt(i))){
                continue;
            }
             if ((s.charAt(i)==']' && (!stkMaintained.isEmpty() && stkMaintained.peek()!='[')) || (s.charAt(i)==')' && (!stkMaintained.isEmpty() && stkMaintained.peek()!='(')) ||(s.charAt(i)=='}' && (!stkMaintained.isEmpty() && stkMaintained.peek()!='{')) )
                return  false;

             else {
                 stkMaintained.pop();
             }

        }
        return stkMaintained.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(checkIfValid("{[]{ab}{{cd]}}"));


    }
}
