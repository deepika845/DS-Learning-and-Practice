package com.deepika.problem.solving.Interviewquestions;


import java.util.Stack;

class SortStackWithoutExtraSpace
{
    private static void sortIt(Stack<Integer> stack,int pop){
        if (stack.isEmpty() || pop>stack.peek()){
            stack.push(pop);
            return;
        }
        int temp = stack.pop();
        sortIt(stack,pop);
        stack.push(temp);
    }
    public  static  void sortTheStack(Stack<Integer> stk){
        if(!stk.isEmpty()){
            int pop = stk.pop();
            sortTheStack(stk);
            sortIt(stk,pop);
        }
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<Integer>();
        st.push(1);
        st.push(3);
        st.push(2);
        st.push(4);
        sortTheStack(st);
        System.out.println(st);

    }
}
