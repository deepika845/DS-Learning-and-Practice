package com.Revision.StackRevision;

import java.io.*;
import java.util.*;

public class InfixEvaluation{

    public static int findPriority(char ch){
        if(ch == '+' || ch == '-'){
            return 1;
        }
        if(ch == '/' || ch == '*'){
            return 2;
        }
        return -1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        String rest[] = exp.split(" ");
        exp = "";
        for (int i=0;i<rest.length;i++){
            exp+=rest[i];
        }
        Stack<Integer> stk1 = new Stack<>();
        Stack<Character> stk2 = new Stack<>();
        for(int i = 0;i<exp.length();i++){
            char ch = exp.charAt(i);
            if(Character.isDigit(ch)){
                stk1.push(Character.getNumericValue(ch));
            }
            else if(ch == '('){
                stk2.push(ch);
            }
            else if(ch == ')'){

                while(stk2.peek() != '('){
                    int b = stk1.pop();
                    int a = stk1.pop();
                    char op = stk2.pop();
                    int res = findRes(a, b, op);
                    stk1.push(res);

                }
                stk2.pop();

            }
            else if(!stk2.empty() && stk2.peek() != '('){
                if(findPriority(ch) > findPriority(stk2.peek())){
                    stk2.push(ch);
                }
                else{
                    char op = stk2.pop();
                    int b = stk1.pop();
                    int a = stk1.pop();
                    int res = findRes(a, b, op);
                    stk1.push(res);
                    stk2.push(ch);


                }
            }
            else {
                stk2.push(ch);
            }

        }
        while (!stk2.isEmpty()){
            int b = stk1.pop();
            int a = stk1.pop();
            char ch = stk2.pop();
            int res = findRes(a,b,ch);
            stk1.push(res);
        }
        System.out.println(stk1.pop());


        // code
    }
    public static int findRes(int a , int b ,  char ch){
        switch(ch){
            case '+':
                return a + b;

            case '-':
                return a - b;

            case '*':
                return a*b;

            case '/':
                return a/b;


        }
        return -1;
    }
}