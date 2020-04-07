import java.util.Scanner;

public class PascalRight {
    public static void makeArray(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(i==j||j==0){
                    arr[i][j]=1;
                }
                else{
                    arr[i][j]=arr[i-1][j]+arr[i-1][j-1];
                }
            }
        }
        printArray(arr);
    }
    public static void printArray(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner  s= new Scanner(System.in);
        int g=s.nextInt();
        int arr[][]=new int[g][];
        for(int i=0;i<g;i++){
            arr[i]=new int[i+1];
        }
        makeArray(arr);
    }

}
