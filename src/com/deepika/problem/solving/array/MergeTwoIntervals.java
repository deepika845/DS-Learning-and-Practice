package com.deepika.problem.solving.array;

//import jdk.internal.util.xml.impl.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeTwoIntervals {

        static class Pair{
            int ft;
            int sc;
            Pair(int ft,int sc){
                this.ft=ft;
                this.sc=sc;
            }
        }


        public static ArrayList<Pair> merge(int[][] intervals) {
            ArrayList<Pair> arr= new ArrayList<>();
            ArrayList<Pair> res=new ArrayList<>();
            for(int i=0;i<intervals.length;i++){
                arr.add(new Pair(intervals[i][0],intervals[i][1]));
            }
            Collections.sort(arr,new Comparator<Pair>(){
                public int compare(Pair p1,Pair p2){
                    return p1.ft-p2.ft;
                }
            } );
            int start=arr.get(0).ft;
            int end=arr.get(0).sc;

            for(int i=1;i<arr.size();i++){
                if (arr.get(i).ft<=end){
                    if (arr.get(i).sc<end){
                        start=start;
                        end=end;
                    }
                    else {
                        end=arr.get(i).sc;
                    }
                }
                else {
                    res.add(new Pair(start,end));
                    start=arr.get(i).ft;
                    end=arr.get(i).sc;
                }
            }
            res.add(new Pair(start,end));
            return res;
        }

    public static void main(String[] args) {
        ArrayList<Pair>res =merge(new int[][]{{1,8},{8,10},{10,18}});
        for (int i=0;i<res.size();i++){
            System.out.println(res.get(i).ft+" => "+res.get(i).sc);
        }
    }
    }

