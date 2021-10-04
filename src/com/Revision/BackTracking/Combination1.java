package com.Revision.BackTracking;

public class Combination1 {
    public static void combinations(int cb, int tb, int ssf, int ts, String asf) {
        // write your code here
        if (ssf >= tb && cb > ts) {
            System.out.println(asf);
            return;
        }
        if (cb <= ts) {
            combinations(cb + 1, tb, ssf + 1, ts, asf + "i");
        }

        combinations(cb, tb, ssf + 1, ts, asf + "-");
    }



    public static void main(String[] args) {
        combinations(1,5,0,3,"");
    }
}
