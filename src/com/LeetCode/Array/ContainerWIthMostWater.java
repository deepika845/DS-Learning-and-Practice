package com.LeetCode.Array;

public class ContainerWIthMostWater {
    public static int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxArea=0;
        while(left<=right){
            int area = Math.min(height[left],height[right])*(right-left);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}) )  ;
    }
}
