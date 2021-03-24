package com.deepika.problem.solving.GreedyALgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NMeetingsOneRoom {
    static class Pair{
        int startTime;
        int endTime;
        int pos;
        Pair(int p,int q,int r){
            this.startTime=p;
            this.endTime=q;
            this.pos=r;
        }
    }
    static class SortingBasis implements Comparator<Pair>{

        @Override
        public int compare(Pair pair, Pair t1) {
            if(pair.endTime>t1.endTime){
                return 1;
            }
            else if(pair.endTime<t1.endTime){
                return -1;
            }
            else {
                return 0;
            }
        }
    }
    public static void maxMeetings(ArrayList<Pair> allMeetings){
        int timeLimit=0;
        ArrayList<Integer>  position= new ArrayList<Integer>();
        Collections.sort(allMeetings,new SortingBasis());
        position.add(allMeetings.get(0).pos);
        timeLimit=allMeetings.get(0).endTime;
        for (int i=1;i<allMeetings.size();i++){
            if(timeLimit<allMeetings.get(i).startTime){
                position.add(allMeetings.get(i).pos);
                timeLimit=allMeetings.get(i).endTime;
            }
        }
        for (int i=0;i<position.size();i++){
            System.out.print(position.get(i)+1 +"  ");
        }
    }

    public static void main(String[] args) {
        int s[] = {75250,50074,43659,8931,11273,
                27545,50879,77924};
        int f[] = {112960,114515,81825,93424,
                54316,35533,73383,160252};
        ArrayList<Pair> meetings = new ArrayList<>();
        for (int i=0;i<s.length;i++){
            meetings.add(new Pair(s[i],f[i],i));
        }
        maxMeetings(meetings);
    }
}
