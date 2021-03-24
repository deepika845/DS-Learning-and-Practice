package com.deepika.problem.solving.SearchAndSort;

public class OptimalLocationPoint {
    static int EPS=(int)(1e-6)+1;
    static class Line{
        int a;
        int b;
        int c;
        Line(int a,int b,int c){
            this.a=a;
            this.b=b;
            this.c=c;
        }
    }
    static class Point{
        int x;
        int y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static double returnSquare(double x){
        return x*x;
    }
    public static double returnDistance(double x,double y,Point b){
        return Math.sqrt(returnSquare(x-b.x)+returnSquare(y-b.y));
    }
    public static double computeDistance(Point[] allPoints,Line l,double mid){
        double y=-1*(l.c+l.a*mid)/l.b;
        int res=0;
        for (int i=0;i<allPoints.length;i++){
            res+=returnDistance(mid,y,allPoints[i]);
        }
        return res;
    }
    public static double optimalLoc(Point[] allPoints,Line l){
        double low=-1e6;
        double high=1e6;
        while ((high-low) > EPS){
            double mid1=low+(high-low)/3;
            double mid2=high-(high-low)/3;
            double dist1=computeDistance(allPoints,l,mid1);
            double dist2=computeDistance(allPoints,l,mid2);
            if (dist1 < dist2) {
                high=mid2;
            }
            else {
                low=mid1;
            }
        }
        return computeDistance(allPoints,l,(low+high)/2);

    }
    private static double findOptimalLocation(Line l,int[][] points){
        Point[] pp=new Point[points.length];
        for (int i=0;i<points.length;i++){
            pp[i]=new Point(points[i][0],points[i][1]);
        }
        return optimalLoc(pp,l);
    }
    public static void main(String[] args) {
        Line l=new Line(1,-1,-3);
        int[][] points={{-3,-2},{-1,0},{-1,2},{1,2},{3,4}};
        System.out.println(findOptimalLocation(l,points));
    }
}
