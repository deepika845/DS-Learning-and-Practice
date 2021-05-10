package com.Revision.GraphQuestion;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinDistWithhinKStops {
    class Pair{
        int city;
        int cost;
        Pair(int city,int cost){
            this.city=city;
            this.cost=cost;
        }
    }
    class City{
        int city;
        int distFromSrc;
        int costFromSrc;
        City(int city,int distFromSrc,int costFromSrc){
            this.city=city;
            this.costFromSrc=costFromSrc;
            this.distFromSrc=distFromSrc;
        }
    }
    public int findMinimumDistance(int n,int flights[][],int src,int dest,int k){
        List<List<Pair>> allPairs=new ArrayList<>();
        this.buildPairs(n,flights,allPairs);
        PriorityQueue<City> pq= new PriorityQueue<>(new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return o1.costFromSrc-o2.costFromSrc;
            }
        });
        pq.add(new City(src,0,0));
        while (!pq.isEmpty()){
            City polled= pq.poll();
            if (polled.city==dest){
                return polled.costFromSrc;
            }
            else if (polled.distFromSrc>k){
                continue;
            }
            for (Pair neigh:allPairs.get(polled.city)){
                pq.add(new City(neigh.city,polled.distFromSrc+1,polled.costFromSrc+neigh.cost));
            }
        }
        return -1;
    }

    private void buildPairs(int n, int[][] flights,List<List<Pair>> allPairs) {
        for (int i=0;i<n;i++){
            allPairs.add(new ArrayList<Pair>());
        }
        for (int i=0;i<n;i++){
            allPairs.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
    }

    public static void main(String[] args) {


    }
}
