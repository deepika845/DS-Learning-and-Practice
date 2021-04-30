package com.deepika.problem.solving.Stacks;

import java.util.Stack;

public class LongestValidSubstring {
    public static int findLongestValidSubstring(String strAva){
        Stack<Character> characterStack= new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(-1);
        int len=0;
        for (int i=0;i<strAva.length();i++){
            char ch = strAva.charAt(i);
            if (ch=='('){
                characterStack.push(ch);
                indexStack.push(i);
            }
            else if (ch==')'){
                if (characterStack.isEmpty()){
                    indexStack.push(i);
                }
                else {
                    characterStack.pop();
                    indexStack.pop();
                  len=Math.max(len,i-indexStack.peek());
                }
            }
        }
        return len;
    }
    public static void main(String[] args) {
        System.out.println( findLongestValidSubstring("()(()("));
    }
}
