package com.deepika.problem.solving.Coursera;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;


class Check_Brackets {
    static int pos =1;
    public static boolean checkIfBalanced(String text){
        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                opening_brackets_stack.push(new Bracket(next,position));
                // Process opening bracket, write your code here
            }

            if (next == ')' || next == ']' || next == '}') {
                // Process closing bracket, write your code here
                if(opening_brackets_stack.isEmpty()){
                    return false;
                }
                Bracket popped = opening_brackets_stack.pop();
                if(popped.type=='[' && next !=']' || popped.type=='{' && next !='}' || popped.type=='(' && next !=')'){
                    pos = position+1;
                    return false;
                }


            }
        }
        return opening_brackets_stack.isEmpty();
    }
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
        if(checkIfBalanced(text)){
            System.out.println("Success");
        }
        else {
            System.out.println(pos);
        }

    }
}
