package com.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Platform {
        static class TrainTime{
            int startTime;
            int endTime;
            TrainTime(int a,int b){
                startTime=a;
                endTime=b;
            }
        }

        static int findPlatform(int arr[], int dep[], int n) {
            // add your code here
            List<TrainTime> allList = new ArrayList<TrainTime>();
            for (int i = 0; i < n; i++) {
                allList.add(new TrainTime(arr[i], dep[i]));
            }
            Collections.sort(allList, new Comparator<TrainTime>() {
                @Override
                public int compare(TrainTime trainTime, TrainTime t1) {
               return trainTime.endTime - t1.endTime;
                }
            });
            int numTrain = 0;
            List<TrainTime> remained = new ArrayList<TrainTime>();
            for (TrainTime current : allList) {
                if (remained.size() == 0) {
                    remained.add(current);
                    numTrain++;
                    continue;
                }
                for (TrainTime ss : remained) {
                    if (ss.startTime > current.startTime && ss.endTime > current.startTime) {
                        numTrain = numTrain;
                    } else if (ss.startTime < current.startTime && ss.endTime < current.startTime) {
                        ss.startTime = current.startTime;
                        ss.endTime = current.endTime;
                    } else {
                        numTrain++;
                        remained.add(new TrainTime(current.startTime, current.endTime));
                        break;
                    }
                }
            }
            return numTrain;
        }

    public static void main(String[] args) {
        System.out.println( findPlatform(new int[]{900,940,950,1100,1500,1800},new int[]{910 ,1200 ,1120, 1130, 1900, 2000},6));
    }


    }
