import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int s = sc.nextInt();
        char arr[][] = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.next().charAt(0);
            }

        }
        pattern(arr, k, s);
    }


    public static void pattern(char arr[][],int k,int s){
        boolean var = false;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {


                char ch= arr[i][j];

                if (s < k) {
                    var = true;
                    break;
                }
                if(ch=='.'){
                    s=s-2;
                }
                if (ch=='*'){
                    s=s+5;
                }
                if (ch=='#'){
                    break;
                }
                if(j!=arr[i].length-1){
                    s=s-1;
                }
            }
        }
        if (!var) {
            System.out.println("Yes");
            System.out.println(s);
        } else {
            System.out.println("No");
        }


    }
}


