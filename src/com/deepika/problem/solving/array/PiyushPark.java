package com.deepika.problem.solving.array;
import java.util.*;
public class PiyushPark{
    public static void probEscape(char park[][],int minStren,int Strength){
        int flag=0;
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[i].length;j++){
                if(minStren>Strength){
                    flag=1;
                    break;
                }
                if(park[i][j]=='.'){
                    Strength=Strength-2;
                    //Strength=Strength-1;
                }
                if(park[i][j]=='*'){
                    Strength=Strength+5;
                }
                if(j==park[i].length-1 || park[i][j]=='#'){
                    break;
                }
                Strength=Strength-1;
            }
            if(flag==1){
                System.out.println("No");
                return;
            }
        }
        if(flag==0){
            System.out.println("Yes");
            System.out.println(Strength);
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] integers = new int[4];
        for(int i = 0; i < 4; i++)
        {
            integers[i] = sc.nextInt();
        }
        char park[][]= new char[integers[0]][integers[1]];
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[i].length;j++){
                park[i][j]=sc.next().charAt(0);
            }
            //System.out.println();
        }
        probEscape(park,integers[2],integers[3]);
    }
}
