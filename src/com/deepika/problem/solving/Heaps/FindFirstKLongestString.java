package com.deepika.problem.solving.Heaps;


import java.util.*;

public class FindFirstKLongestString {
    
    public static void main(String[] args) {
        FindFirstKLongestString fsck = new FindFirstKLongestString();
        HashSet<String> allLength = new HashSet<String>();
        allLength.add("ery");
        allLength.add("kk");
        allLength.add("edp");
        allLength.add("y2234");
        allLength.add("wert");
        Iterator<String> itd = allLength.iterator();
fsck.findKLargest(3,itd);
    }

    private ArrayList<String> findKLargest(int k,Iterator<String> itd) {
        PriorityQueue<String> pq = new PriorityQueue<>(k, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return Integer.compare(s.length(),t1.length());
            }
        });
        while (itd.hasNext()){
            String ss =itd.next();
            if(ss.length()<pq.peek().length()){
                pq.add(ss);
            }
            if(pq.size()>3){
                pq.poll();
            }
        }
        return new ArrayList<String>(pq);
    }
}
