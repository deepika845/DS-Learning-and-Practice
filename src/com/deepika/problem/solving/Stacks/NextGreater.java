package com.deepika.problem.solving.Stacks;

import java.util.Stack;

public class NextGreater {
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk = new Stack<Integer>();
        stk.push(0);
        int[] ans= new int[temperatures.length];

        for(int i=1;i<temperatures.length;i++){

            int next=temperatures[i];
            while(!stk.isEmpty()){
                int ele= stk.pop();
                while(temperatures[ele]<next){
                    ans[ele]=i-ele;
                    if(stk.isEmpty()){
                        break;
                    }
                    else {
                        ele = stk.pop();
                    }
                }
                if(temperatures[ele]>=next){
                    stk.push(ele);
                    break;
                }
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            int ind= stk.pop();
            ans[ind]=-1;
        }
        return ans;
    }

    public static void main(String[] args) {
        dailyTemperatures(new int[]{89,62,70,58,47,47,46,76,100,70});
    }
}
