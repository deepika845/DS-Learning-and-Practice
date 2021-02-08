package com.deepika.problem.solving.GreedyALgorithms;

import java.util.*;

import java.util.Comparator;
import java.util.Scanner;

public class JobSequencingProblem {
    static class Job{
        int id;
        int profit;
        int deadline;
        Job(int x,int y,int z){
            this.id=x;
            this.profit=z;
            this.deadline=y;
        }
    }
    class SortComparator implements Comparator<Job> {

        @Override
        public int compare(Job job, Job t1) {
            if(t1.profit>job.profit){
                return 1;
            }
            else{
                return -1;
            }
        }
    }
    public int[] scheduleTheJob(Job allJobs[],int n){
        int[] scheduled=new int[n+1];
        Arrays.fill(scheduled,-1);
        Arrays.sort(allJobs,new SortComparator());
        boolean[] visited = new boolean[n+1];
        int totalProfit=0;
        int Count=0;
        for(Job curr:allJobs){
        adjustAtSuitable(visited,scheduled,curr);
        if(visited[curr.id]){
            Count++;
            totalProfit+=curr.profit;
        }
        }
        int res[]=new int[2];
        res[0]=Count;
        res[1]=totalProfit;
        return res;
    }

    private void adjustAtSuitable(boolean[] visited, int[] scheduled, Job curr) {
        int deadLine =curr.deadline-1;
        while(deadLine>0 && scheduled[deadLine]!=-1){
            deadLine--;
        }
        if(deadLine>=0 && scheduled[deadLine]==-1 ){
        scheduled[deadLine]=curr.id;
        visited[curr.id]=true;
        }
    }

    public static void main(String[] args) {
        JobSequencingProblem jbg = new JobSequencingProblem();
        Scanner s = new Scanner(System.in);
        int n= Integer.parseInt(s.nextLine());
        Job[] allJobs = new Job[n];
        for (int i=0;i<n;i++){

            String stmt= s.nextLine();
            String[] arr = stmt.split(" ");
            allJobs[i]=new Job(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]),Integer.parseInt(arr[2]));
        }
        int[] res= jbg.scheduleTheJob(allJobs,n);
        System.out.println(res[0] +" "+ res[1]);
    }
}
