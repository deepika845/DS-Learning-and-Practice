package com.deepika.problem.solving.Coursera;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;



public class Check_Brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
        boolean b = true;
        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here
                opening_brackets_stack.push(new Bracket(next,position));
            }

            if (next == ')' || next == ']' || next == '}') {
                // Process closing bracket, write your code here
                if(opening_brackets_stack.empty()){
                    System.out.println("0");
                    b=false;
                    break;
                }
                Bracket toCheck = opening_brackets_stack.pop();
                if(toCheck.type == '(' && next != ')' || toCheck.type == '{' && next != '}'|| toCheck.type == '[' && next != ']'){
                    b=false;
                    System.out.println(toCheck.position+1);
                    break;
                }
            }
            if(opening_brackets_stack.size() == 1){
                System.out.println(1);
            }
        }
        if(b && !(opening_brackets_stack.size()==1) ){
            System.out.println("Success");
        }
        // Printing answer, write your code here
    }
}
