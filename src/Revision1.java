import java.util.Scanner;

public class Revision1 {
    public static void patternMethod(int f){
        int row =1;
        int ll=1;
        while(ll<=2*f-1){
            int col=row;
            int k=1;
            int space=1;
            while(space<=f-row){
                System.out.print(" ");
                space+=1;
            }
            while(k<=(2*row-1)){
                System.out.print(col);
                if(k<row){
                    col+=1;
                }
                else{
                    col-=1;
                }
                k+=1;
            }
            if(ll<f){
                row+=1;
            }
            else{
                row-=1;
            }
            ll+=1;
            System.out.println();
        }
    }
    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);
        int k=s.nextInt();
        patternMethod(k);

    }
}
