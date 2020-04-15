package testQues;

import java.util.*;
//This is The Coding Area
class CalcSmallerAngle{
    public static float calcSmallAngle(int x,float d){
        float f =((float)x/360)*(d);
        int j =(int)f;
        float l=f-j;
        float dd =  calcTheAngle(j,l);
        return dd;
    }
    public static float calcTheAngle(int k,float l){
        float f= ((11f/2)*l)-30*k;
        return f;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int rotation = s.nextInt();
        float f= s.nextFloat();
        String change= String.format("%.2f",f);
        float ll =Float.parseFloat(change);
        float result = calcSmallAngle(24,82.5f);
        System.out.printf("%.2f",result);

    }


}