package com.deepika.problem.solving.Interviewquestions;

public class EggDropProblem {


    static int eggDrop(int n, int k)
    {

        if (k == 1 || k == 0)
            return k;


        if (n == 1)
            return k;

        int min = Integer.MAX_VALUE;
        int x, res;

        for (x = 1; x <= k; x++) {
            res = Math.max(eggDrop(n - 1, x - 1),
                    eggDrop(n, k - x));
            if (res < min)
                min = res;
        }

        return min + 1;
    }


    public static void main(String args[])
    {
        int n = 3, k = 10;
        System.out.print( eggDrop(n, k));
    }

}
