import java.util.Scanner;

public class PrintNthFibonacci {
    public static void printFibonacci(int n){
        int f=0;
        int t=1;
        //int i=1;
        //int s=0;
        while(f<n){
            System.out.println(f);
            int s=f+t;
            f=t;
            t=s;
          //  i=i+1;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int f=s.nextInt();
        printFibonacci(f);
    }
}
