package com.deepika.problem.solving.Interviewquestions;

public class FindMedianInTwoSOrtedArray {
    public static double findMedian(int arr[],int arr1[]){
        if(arr.length >arr1.length){
            return findMedian(arr1,arr);
        }
        int low = 0;
        int high = arr.length;
        while (low<=high){
            int partitionX = (low + high )/2;
            int partitionY = (arr.length + arr1.length + 1 )/2 - partitionX;
                int maxLeftX = (partitionX==0) ? Integer.MIN_VALUE : arr[partitionX-1];
                int minRightX = (partitionX==arr.length) ? Integer.MAX_VALUE : arr[partitionX];
            int maxLeftY = (partitionY==0) ? Integer.MIN_VALUE : arr1[partitionY-1];
            int minRightY = (partitionX==arr.length) ? Integer.MAX_VALUE : arr1[partitionY];
            if(maxLeftX < minRightY && maxLeftY<minRightX){
                if((arr.length + arr1.length)%2==0){
                    return (double) ((Math.max(maxLeftX,maxLeftY)+ Math.min(minRightX,minRightY))/2);
                }
                else {
                    return (double) Math.max(maxLeftX,maxLeftY);
                }
            }
            else if(maxLeftX > minRightY){
                high = partitionX - 1;
            }
            else {
                low=partitionX+1;
            }

        }
        return 0.0;
    }
    public static void main(String[] args) {
 findMedian(new int[]{5,9,13,15},new int[]{2,4,8});

    }
}
