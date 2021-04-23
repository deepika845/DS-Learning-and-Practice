package com.Revision.StackRevision;

import java.util.Stack;

public class EvaluatingAirthmeticExpression {
    public int precD(char ch){
        switch (ch)
            {
                case '+':
                case '-':
                    return 1;

                case '*':
                case '/':
                    return 2;

                case '^':
                    return 3;
            }
            return -1;


    }
    public String findPostfixExpression(String infix){
       //  boolean afterPrec=false;
        String result = new String("");
        Stack<Character> stackMaintained= new Stack<>();
        for (int i=0;i<infix.length();i++){
            char ch= infix.charAt(i);
            if (Character.isDigit(ch)){
                result+=ch;
            }
            else if (ch=='('){
                stackMaintained.push(ch);
            }
            else if (ch==')'){
                while (!stackMaintained.isEmpty() && stackMaintained.peek()!='('){
                    result+=stackMaintained.pop();
                }
                stackMaintained.pop();
            }
            else {
                while (!stackMaintained.isEmpty()  &&  precD(ch)<=precD(stackMaintained.peek()) ){
                    if(stackMaintained.peek()=='('){
                        stackMaintained.pop();
                        break;
                    }
                    result+=stackMaintained.pop();

                }


                stackMaintained.push(ch);
            }}
            while (!stackMaintained.isEmpty()){
                if (stackMaintained.peek()=='('){
                    return "invalid String";
                }
                result+=stackMaintained.pop();
            }

        return result;
    }
    public int findResult(char ch,int a,int b){
        switch (ch){
            case '*': return a*b;

            case '/':return a/b;

            case '+':return a+b;

            case '-':return a-b;

            case '^':return a^b;

            default: return -1;
        }

    }
    public int findEvaluationResult(String infixExpression){
        String postFix=findPostfixExpression(infixExpression);
        Stack<Integer> stkMaintained=new Stack<>();
        for (int i=0;i<postFix.length();i++){
            char ch = postFix.charAt(i);
            if (!Character.isDigit(ch)){
                int pop1= stkMaintained.pop();
                int pop2=stkMaintained.pop();
                int result=findResult(ch,pop2,pop1);
                stkMaintained.push(result);
            }
            else {
                if (Character.isLetter(ch)){
                    throw new ArithmeticException("String not correctly Entered");
                }
                stkMaintained.push(Integer.parseInt(ch+""));
            }
        }
        return stkMaintained.pop();
    }
    public static void main(String[] args) {
        EvaluatingAirthmeticExpression eva = new EvaluatingAirthmeticExpression();
        System.out.println(eva.findEvaluationResult("1+(9/7)+4*6"));
    }
}
